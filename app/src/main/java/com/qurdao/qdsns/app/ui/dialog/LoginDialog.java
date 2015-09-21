package com.qurdao.qdsns.app.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.qurdao.qdsns.Constant;
import com.qurdao.qdsns.R;
import com.qurdao.qdsns.app.MyApplication;
import com.qurdao.qdsns.app.api.ApiHttpClient;
import com.qurdao.qdsns.app.api.UrlConstant;
import com.qurdao.qdsns.app.bean.TokenVo;
import com.qurdao.qdsns.utils.CyptoUtils;
import com.qurdao.qdsns.utils.JacksonUtil;
import com.qurdao.qdsns.utils.UIHelper;

import org.apache.http.Header;

import java.lang.reflect.Field;

/**
 * Created by xiex on 2015/8/21.
 */
public class LoginDialog {

    private static final String TAG = Constant.PAKAGE_TAG;

    private static AlertDialog alertDialog;
    private static Context context;
    private static String username = null;
    private static String password = null;


    private static AsyncHttpResponseHandler loginHandle = new AsyncHttpResponseHandler() {

        @Override
        public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                              Throwable arg3) {
            Log.d(TAG, "onFailure");
            Log.d(TAG, arg0 + "");
            Log.d(TAG, new String(arg2));
            Toast.makeText(context, R.string.msg_login_failure, Toast.LENGTH_SHORT).
                    show();
        }

        @Override
        public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
            String json = new String(arg2);
            TokenVo tokenVo = JacksonUtil.jsonToObj(json, TokenVo.class);
            if (tokenVo == null || tokenVo.loginFailure()) {
                Toast.makeText(context, R.string.msg_login_error, Toast.LENGTH_SHORT).
                        show();
            } else {
                closeDialog(alertDialog);
                Toast.makeText(context, R.string.msg_login_success, Toast.LENGTH_SHORT).
                        show();
                MyApplication.setPro(Constant.USER_NAME, username);
                MyApplication.setPro(Constant.PASSWORD,CyptoUtils.encode(password));
                MyApplication.setPro(Constant.TOKEN, tokenVo.getAccessToken());
                MyApplication.setPro(Constant.TOKEN_TIME, String.valueOf(System.currentTimeMillis() / (1000 * 60)));
            }
        }
    };

    // 显示对话框
    public static void showWaiterAuthorizationDialog(final Context context) {
        LoginDialog.context = context;
        LayoutInflater factory = LayoutInflater.from(context);
        final View textEntryView = factory.inflate(R.layout.activity_login,
                null);
        TextView textView = (TextView) textEntryView.findViewById(R.id.click_me_register);
        EditText usernameView = (EditText) textEntryView.findViewById(R.id.etuserName);
        EditText passwordView = (EditText) textEntryView.findViewById(R.id.etPWD);
        String username = MyApplication.getPro(Constant.USER_NAME);
        String password = MyApplication.getPro(Constant.PASSWORD);
        usernameView.setText(username);
        passwordView.setText(CyptoUtils.decode(password));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIHelper.openSysBrowser(context, Constant.QURDAO_REGISTER_URL);
            }
        });
        alertDialog = new AlertDialog.Builder(context)
                .setTitle(R.string.login)
                .setView(textEntryView)
                .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                disclosedDialog(alertDialog);
                                final EditText etUserName = (EditText) textEntryView
                                        .findViewById(R.id.etuserName);
                                final EditText etPassword = (EditText) textEntryView
                                        .findViewById(R.id.etPWD);
                                String userName = etUserName.getText().toString()
                                        .trim();
                                String password = etPassword.getText().toString()
                                        .trim();
                                if (userName.isEmpty() || password.isEmpty()) {
                                    Toast.makeText(context, R.string.msg_username_password_empty, Toast.LENGTH_SHORT).
                                            show();
                                    return;
                                }
                                final RequestParams params = new RequestParams();
                                params.add("grant_type", "password");
                                params.add("client_id", "123456");
                                params.add("scope", "Basic");
                                params.add("username", userName);
                                params.add("password", password);
                                ApiHttpClient.post(UrlConstant.USER_LOGIN, params, "application/x-www-form-urlencoded", loginHandle);
                                LoginDialog.username = userName;
                                LoginDialog.password = password;
                            }
                        }

                )
                        // 对话框的“退出”单击事件
                .

                        setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        closeDialog(dialog);
                                    }
                                }

                        ).

                        setCancelable(false)

                .

                        create();

        alertDialog.show();

    }


    private static void disclosedDialog(DialogInterface dialog) {
        Field field = null;
        try {
            field = dialog.getClass().getSuperclass()
                    .getDeclaredField("mShowing");
            field.setAccessible(true);
            field.set(dialog, false);
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void closeDialog(DialogInterface dialog) {
        Field field = null;
        try {
            field = dialog.getClass().getSuperclass()
                    .getDeclaredField("mShowing");
            field.setAccessible(true);
            field.set(dialog, true);
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
