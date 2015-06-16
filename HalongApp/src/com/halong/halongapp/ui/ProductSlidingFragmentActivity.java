package com.halong.halongapp.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.halong.halongapp.R;
import com.halong.halongapp.adapter.ListProductAdapter;
import com.halong.halongapp.ui.ProductLeftFragment.SLMenuListOnItemClickListener;
import com.halong.halongapp.widget.ClearEditText;
import com.halong.halongapp.widget.SlidingFragmentActivity;
import com.halong.halongapp.widget.SlidingMenu;

public class ProductSlidingFragmentActivity extends SlidingFragmentActivity implements SLMenuListOnItemClickListener {

	private ProductLeftFragment mLeftFragment;

	private Button mMenuButton;

	private ListView mProductListView;
	private List<String> mList;

	/**
	 * 搜索edittext
	 */
	private ClearEditText mClearEditText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_product_service);

		initView();
		initSlidingMenu();
		initData();
		initListener();
	}

	private void initListener() {
		// TODO Auto-generated method stub
		mClearEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				updateListView(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		mProductListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						ProductInfoActivity.class);
				startActivity(intent);
			}
		});
		
		mMenuButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				toggle();
			}
		});
	}

	private void initSlidingMenu() {
		// TODO Auto-generated method stub

		setBehindContentView(R.layout.fragment_sliding_product_left_edition);
		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		t.replace(R.id.leftFrameLayout, mLeftFragment);
		t.commit();

		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setMode(SlidingMenu.RIGHT);

		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

	}

	/**
	 * 获取搜索的listview
	 * 
	 * @param str
	 *            搜索条件
	 */
	private void updateListView(String str) {
		List<String> seekList = new ArrayList<String>();
		if (TextUtils.isEmpty(str)) {
			seekList = mList;
		} else {
			seekList.clear();
			for (String string : mList) {
				if (string.indexOf(str) != -1) {
					seekList.add(string);
				}
			}
		}
		bindListView(seekList);
	}

	/**
	 * 绑定ListView数据
	 * 
	 * @param list
	 */
	private void bindListView(List<String> list) {
		// TODO Auto-generated method stub
		mProductListView.setAdapter(new ListProductAdapter(this, list));
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		// TODO Auto-generated method stub
		mList = new ArrayList<String>();

		mList.add("婚纱写真达人");
		mList.add("密封系统");
		mList.add("3G应用");
		mList.add("网站建设解决方案");
		mList.add("企业管理系统");
		mList.add("京师宝典");
		mList.add("IPAD展销宝");
		mList.add("社云通");
		mList.add("地产IPAD售楼系统");
		mList.add("AR技术虚拟3D&现实融合");

		bindListView(mList);
		
		mProductListView.setLayoutAnimation(getListAnim());
	}
	
	/**
	 * 获取动画LayoutAnimationController
	 * @return
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

	private void initView() {
		// TODO Auto-generated method stub
		mLeftFragment = new ProductLeftFragment();

		mProductListView = (ListView) findViewById(R.id.productListView);
		mClearEditText = (ClearEditText) findViewById(R.id.clearEditText);
		mMenuButton = (Button) findViewById(R.id.menuButton);
	}

	/**
	 * 菜单listview被点击
	 */
	@Override
	public void selectItem(int position, String title) {
		// TODO Auto-generated method stub
		toggle();
		Log.v("lihua", title);
	}
	
}
