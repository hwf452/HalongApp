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

public class InviteFragmentActivity extends MyFragmentActivity {
	private Fragment mSocietyFragment, mSchoolFragment;

	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;

	private CheckBox mLeftCheckBox, mRightCheckBox;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_invite);
		initFragment();
		initView();
		initListener();
		initStart();
	}

	private void initStart() {
		// TODO Auto-generated method stub
		mLeftCheckBox.setChecked(true);
	}

	private void initFragment() {
		// TODO Auto-generated method stub
		mFragmentManager = this.getSupportFragmentManager();
	}

	private void initListener() {
		// TODO Auto-generated method stub
		mLeftCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					checkBoxUpdate(mLeftCheckBox, isChecked, mSocietyFragment);
					mRightCheckBox.setChecked(false);
				} else {
					checkBoxUpdate(mLeftCheckBox, isChecked, mSchoolFragment);
				}

			}
		});
		mRightCheckBox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub

						if (isChecked) {
							checkBoxUpdate(mRightCheckBox, isChecked,
									mSchoolFragment);
							mLeftCheckBox.setChecked(false);
						} else {
							checkBoxUpdate(mRightCheckBox, isChecked,
									mSocietyFragment);
						}
					}
				});
	}

	/**
	 * 改变checkBox字体颜色，是否可改变check，替换framelayout
	 * 
	 * @param checkBox
	 *            要变化的checkBox
	 * @param isChecked
	 *            checkBox是否选择
	 * @param fragment
	 *            跳转的fragment
	 */
	protected void checkBoxUpdate(CheckBox checkBox, boolean isChecked,
			Fragment fragment) {
		// TODO Auto-generated method stub
		if (isChecked) {
			checkBox.setTextColor(getResources().getColor(R.color.while1));
			checkBox.setClickable(false);
		} else {
			checkBox.setTextColor(getResources().getColor(R.color.royal_blue));
			checkBox.setClickable(true);
		}
		replace(fragment);
	}

	private void initView() {
		// TODO Auto-generated method stub
		mLeftCheckBox = (CheckBox) findViewById(R.id.leftCheckBox);
		mRightCheckBox = (CheckBox) findViewById(R.id.rightCheckBox);
		mSchoolFragment = new InviteSchoolFragment();
		mSocietyFragment = new InviteSocietyFragment();

	}

	/**
	 * 替换framelayout
	 * 
	 * @param Fragment
	 */
	private void replace(Fragment Fragment) {
		mFragmentTransaction = mFragmentManager.beginTransaction();
		mFragmentTransaction.replace(R.id.inviteFrameLayout, Fragment);
		mFragmentTransaction.commit();
	}
}
