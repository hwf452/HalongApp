package com.halong.halongapp.util;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;

import com.halong.halongapp.R;

public class MyActivity extends Activity {

	private float mAnimWidth, mAnimHeight;
	private float mPlaneBig;

	private FrameLayout mTopFrameLayout, mBodyFrameLayout;

	private Button mBackButton;
	/**
	 * 判断是否是跳转，设置动画效果
	 */
	private boolean mIsToOrder = true;

	/**
	 * 打开activity播放动画，布局文件需要topFrameLayout，bodyFrameLayout
	 */
	public void myStartAnimation() {
		mTopFrameLayout = (FrameLayout) findViewById(R.id.topFrameLayout);
		mBodyFrameLayout = (FrameLayout) findViewById(R.id.bodyFrameLayout);
		// 头部动画
		Animation animation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(500);
		mTopFrameLayout.startAnimation(animation);
		// 主信息动画
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(500);
		mBodyFrameLayout.startAnimation(animation);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		Display display = getWindowManager().getDefaultDisplay();
		mAnimWidth = display.getWidth();
		mAnimHeight = display.getHeight();
		mAnimHeight -= getStatusBarHeight(this);
		mPlaneBig = getResources().getDimension(R.dimen.plane_big);
		mAnimWidth -= mPlaneBig;
		mAnimHeight -= mPlaneBig;

		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (mIsToOrder) {
			overridePendingTransition(R.anim.push_left_in,
					R.anim.push_right_out);
		} else {
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_left_out);
		}
	}

	/**
	 * 返回、退出按钮
	 * 
	 * @param view
	 */
	public void backButton(View view) {
		mBackButton = (Button) findViewById(R.id.backButton);
		mIsToOrder = false;
		mBackButton.setBackgroundResource(R.drawable.animation4_3);

		AnimationSet setAnimation = new AnimationSet(true);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.plane_rotate);
		animation.setStartOffset(700);
		setAnimation.addAnimation(animation);
		
		animation = new TranslateAnimation(0, mAnimWidth * -1, 0,
				mAnimHeight * -1);
		animation.setDuration(1000);
		
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				finish();
				mBackButton.setBackgroundResource(R.drawable.animation4_1);
			}
		});
		
		setAnimation.addAnimation(animation);
		
		mBackButton.startAnimation(setAnimation);
		
	}

	/**
	 * 获取状态栏高度
	 * 
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context) {
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, statusBarHeight = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			statusBarHeight = context.getResources().getDimensionPixelSize(x);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return statusBarHeight;
	}

	/**
	 * 手机按钮点击事件
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			mIsToOrder = false;
		}
		backButton(null);
		return false;
	}

	/**
	 * 跳转
	 * 
	 * @param context
	 * @param toClass
	 */
	public void toOrderActivity(Context context, Class<?> toClass) {
		mIsToOrder = true;
		Intent intent = new Intent(this, toClass);
		startActivity(intent);
	}
}
