package com.halong.halongapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.halong.halongapp.R;
import com.halong.halongapp.util.MyFragmentActivity;

public class DevelopFragmentActivity extends MyFragmentActivity {
	
	private DevelopListFragment mListFragment;
	private DevelopGridFragment mGridFragment;

	private FragmentManager mFragmentManager;

	private CheckBox  mIsListCheckBox;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_develop);
		
		initFragment();
		initView();
		initListener();
	}

	/**
	 * 初始化mFragmentManager
	 */
	private void initFragment() {
		// TODO Auto-generated method stub
		mFragmentManager = this.getSupportFragmentManager();
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		// TODO Auto-generated method stub
		mIsListCheckBox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked) {
							replace(mGridFragment);

						} else {
							replace(mListFragment);
						}
					}
				});
	}

	/**
	 * 初始化绑定view，fragment
	 */
	private void initView() {
		// TODO Auto-generated method stub
		mIsListCheckBox = (CheckBox) findViewById(R.id.isListCheckBox);

		mListFragment = new DevelopListFragment();
		mGridFragment = new DevelopGridFragment();
		
		replace(mListFragment);
	}
	
	/**
	 * 替换fragment
	 * @param Fragment 所要显示的fragment
	 */
	private void replace(Fragment Fragment){
		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.replaceFrmeLayout, Fragment);
		fragmentTransaction.commit();
	}
}
