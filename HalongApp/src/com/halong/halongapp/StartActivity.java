package com.halong.halongapp;

import com.halong.halongapp.ui.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class StartActivity extends Activity {

	private long m_dwSplashTime = 3000;
	private boolean m_bPaused = false;
	private boolean m_bSplashActive = true;

	private AnimationDrawable mRocketAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		initAnim();

		Thread splashTimer = new Thread() {
			public void run() {
				try {

					long ms = 0;
					while (m_bSplashActive && ms < m_dwSplashTime) {
						sleep(100);
						if (!m_bPaused) {
							ms += 100;
						}
					}
					Intent intent = new Intent(StartActivity.this,
							MainActivity.class);
					startActivity(intent);
					// overridePendingTransition(R.anim.push_right_in,
					// R.anim.push_left_out);

				} catch (Exception e) {
					Log.e("splash", e.getMessage());
				} finally {
					finish();
				}
			}
		};
		splashTimer.start();
	}

	private void initAnim() {
		ImageView mAnimationImageView = (ImageView) findViewById(R.id.animationImageView);

		mAnimationImageView.setBackgroundResource(R.anim.anim_start);

		mRocketAnimation = (AnimationDrawable) mAnimationImageView
				.getBackground();

		mRocketAnimation.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
