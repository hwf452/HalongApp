package com.halong.halongapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;

import com.halong.halongapp.R;
import com.halong.halongapp.adapter.DevelopAdapter;
import com.halong.halongapp.util.MyFragment;

public class DevelopGridFragment extends MyFragment {

	private View mView;
	private CheckBox mLeftCheckBox, mRightCheckBox;
	private GridView mDevelopGridView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		mView = inflater.inflate(R.layout.fragment_develop_grid, null);
		mDevelopGridView = (GridView) mView.findViewById(R.id.developGridView);
		mLeftCheckBox = (CheckBox) mView.findViewById(R.id.leftCheckBox);
		mRightCheckBox = (CheckBox) mView.findViewById(R.id.rightCheckBox);

		initListener();
		setAdapterOfProduct();

		
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
		mDevelopGridView.setOnItemClickListener(new OnItemClickListener() {

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
		} else {
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
		mDevelopGridView.setAdapter(new DevelopAdapter(getActivity()
				.getApplicationContext(), false));
	}

	/**
	 * 设置技术沙龙
	 */
	public void setAdapterOfTechonology() {
		// TODO Auto-generated method stub
		initTechnologyData();
		mDevelopGridView.setAdapter(new DevelopAdapter(getActivity()
				.getApplicationContext(), false));
	}
	
	/**
	 * 初始化技术沙龙数据
	 */
	private void initTechnologyData() {
		// TODO Auto-generated method stub
		Log.v("lihua", "initTechnologyData");
	}

	/**
	 * 初始化产学研基地数据数据
	 */
	private void initProductData() {
		// TODO Auto-generated method stub
		Log.v("lihua", "initProductData");
	}
}
