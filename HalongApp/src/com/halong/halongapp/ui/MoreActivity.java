package com.halong.halongapp.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.halong.halongapp.R;
import com.halong.halongapp.util.MyActivity;

public class MoreActivity extends MyActivity implements OnClickListener {
	private RelativeLayout mFeedbackRelativeLayout,mCheckUpdateRelativeLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more);
		initView();
		initListener();
		myStartAnimation();
	}

	private void initListener() {
		// TODO Auto-generated method stub
		mFeedbackRelativeLayout.setOnClickListener(this);
		mCheckUpdateRelativeLayout.setOnClickListener(this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		mFeedbackRelativeLayout = (RelativeLayout) findViewById(R.id.feedbackRelativeLayout);
		mCheckUpdateRelativeLayout = (RelativeLayout) findViewById(R.id.checkUpdateRelativeLayout);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.feedbackRelativeLayout:
			toOrderActivity(this, MoreFeedbackActivity.class);
			break;
		case R.id.checkUpdateRelativeLayout:
			Toast.makeText(getApplicationContext(), "检查更新中", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
}
