package com.qurdao.qdsns.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.qurdao.qdsns.Constant;
import com.qurdao.qdsns.R;
import com.qurdao.qdsns.utils.NetworkUtil;

public class StartActivity extends Activity {

    private final static String TAG = Constant.PAKAGE_TAG + "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_start, null);
        Log.d(TAG, "onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(view);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 1F);
        alphaAnimation.setDuration(2000);
        view.startAnimation(alphaAnimation);
        Log.d(TAG, "network is ok :" + NetworkUtil.isNetworkAvailble(getApplicationContext()));
        Log.d(TAG, "use wifi :" + NetworkUtil.isWifiOpen(getApplicationContext()));
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Log.d(TAG, "a");
    }
}

