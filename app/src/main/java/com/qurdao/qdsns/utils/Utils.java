package com.qurdao.qdsns.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Utils {

	public static void setCloseActionTitle(final Activity context, String title) {
		context.setTitle(title);
		int titleId = Resources.getSystem().getIdentifier("action_bar_title",
				"id", "android");
		TextView tvTitle = (TextView) context.findViewById(titleId);
		tvTitle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				context.finish();
			}
		});
	}

	public static void setCloseActionTitle(final Activity context, int title) {
		context.setTitle(title);
		int titleId = Resources.getSystem().getIdentifier("action_bar_title",
				"id", "android");
		TextView tvTitle = (TextView) context.findViewById(titleId);
		tvTitle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				context.finish();
			}
		});
	}

}
