package com.halong.halongapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;

import com.halong.halongapp.R;
import com.halong.halongapp.adapter.DevelopAdapter;
import com.halong.halongapp.util.MyFragment;

public class DevelopListFragment extends MyFragment {

	private CheckBox mLeftCheckBox, mRightCheckBox;

	private ListView mDevelopListView;
	private View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		mView = inflater.inflate(R.layout.fragment_develop_list, null);
		mDevelopListView = (ListView) mView.findViewById(R.id.developListView);
		mLeftCheckBox = (CheckBox) mView.findViewById(R.id.leftCheckBox);
		mRightCheckBox = (CheckBox) mView.findViewById(R.id.rightCheckBox);

		setAdapterOfProduct();
		initListener();
		
		mLeftCheckBox.setChecked(true);
		return mView;
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		// TODO Auto-generated method stub
		mLeftCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					checkBoxUpdate(mLeftCheckBox, isChecked);
					mRightCheckBox.setChecked(false);
					setAdapterOfProduct();
				} else {
					checkBoxUpdate(mLeftCheckBox, isChecked);
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
							checkBoxUpdate(mRightCheckBox, isChecked);
							mLeftCheckBox.setChecked(false);
							setAdapterOfTechonology();
						} else {
							checkBoxUpdate(mRightCheckBox, isChecked);
						}
					}
				});
		mDevelopListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),DevelopInfoActivity.class);
				startActivity(intent);
			}
		});
	}
	
	/**
	 * 获取动画LayoutAnimationController
	 * @return LayoutAnimationController动画set控制器
	 */
	private LayoutAnimationController getListAnim() {
		AnimationSet set = new AnimationSet(true);
		Animation animation ;
		//Animation.RELATIVE_TO_SELF相对于自身，-1.0f自身百分比
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(300);
		set.addAnimation(animation);
		LayoutAnimationController controller = new LayoutAnimationController(
				set, 0.5f);
		return controller;
	}

	/**
	 * 更新checkBox的样式
	 * 
	 * @param checkBox
	 *            被点击的checkBox
	 * @param isChecked
	 *            该checkBox状态
	 */
	protected void checkBoxUpdate(CheckBox checkBox, boolean isChecked) {
		// TODO Auto-generated method stub
		if (isChecked) {
			checkBox.setTextColor(getResources().getColor(R.color.while1));
			checkBox.setClickable(false);
		}else {
			checkBox.setTextColor(getResources().getColor(R.color.royal_blue));
			checkBox.setClickable(true);
		}
	}

	/**
	 * 设置产学研基地
	 */
	public void setAdapterOfProduct() {
		// TODO Auto-generated method stub
		initProductData();
		mDevelopListView.setAdapter(new DevelopAdapter(getActivity()
				.getApplicationContext(), true));
		mDevelopListView.setLayoutAnimation(getListAnim());
	}

	/**
	 * 设置技术沙龙
	 */
	public void setAdapterOfTechonology() {
		// TODO Auto-generated method stub
		initTechnologyData();
		mDevelopListView.setAdapter(new DevelopAdapter(getActivity()
				.getApplicationContext(), true));
		mDevelopListView.setLayoutAnimation(getListAnim());
	}

	private void initTechnologyData() {
		// TODO Auto-generated method stub
		Log.v("lihua", "initTechnologyData");
	}

	private void initProductData() {
		// TODO Auto-generated method stub
		Log.v("lihua", "initProductData");
	}
}
