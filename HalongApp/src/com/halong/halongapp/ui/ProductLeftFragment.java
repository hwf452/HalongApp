package com.halong.halongapp.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.halong.halongapp.R;
import com.halong.halongapp.adapter.ListProductTypeAdapter;
import com.halong.halongapp.util.MyFragment;

public class ProductLeftFragment extends MyFragment {

	private View mView;

	private ListView mAllListView;
	private List<String> mTitleStringList;
	private List<Integer> mColorIntegerList;

	private SLMenuListOnItemClickListener mCallback;

	/**
	 * 回调
	 */
	@Override
	public void onAttach(Activity activity) {
		try {
			mCallback = (SLMenuListOnItemClickListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnResolveTelsCompletedListener");
		}
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mView = inflater.inflate(R.layout.fragment_sliding_product_left, null);
		initView();
		initData();
		initlistener();

		return mView;
	}

	/**
	 * 绑定监听
	 */
	private void initlistener() {
		// TODO Auto-generated method stub
		mAllListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					final int position, long id) {
				// TODO Auto-generated method stub

				ImageView imageView = (ImageView) view
						.findViewById(R.id.fiveImageView);
				imageView.setBackgroundResource(R.anim.anim_five);
				final AnimationDrawable animationDrawablen = (AnimationDrawable) imageView
						.getBackground();
				

				RelativeLayout relativeLayout = (RelativeLayout) view
						.findViewById(R.id.typeRelativeLayout);
				Animation animation = new TranslateAnimation(0, 200, 0, 0);
				animation.setDuration(800);
				animation.setFillAfter(false);
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						mAllListView.setEnabled(false);
						animationDrawablen.start();
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						mAllListView.setEnabled(true);
						animationDrawablen.stop();
						if (mCallback != null) {
							mCallback.selectItem(position,
									mTitleStringList.get(position));
						}
					}
				});
				
				relativeLayout.startAnimation(animation);
			}
		});
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		// TODO Auto-generated method stub
		mTitleStringList = new ArrayList<String>();
		mTitleStringList.add("手机客户端软件开发");
		mTitleStringList.add("企业应用软件开发");
		mTitleStringList.add("通讯行业系统集成");
		mTitleStringList.add("品牌企业网站系统开发");
		mTitleStringList.add("电商系统开发");
		mTitleStringList.add("二维码应用");
		mTitleStringList.add("云服务器");
		mTitleStringList.add("360°全景");

		mColorIntegerList = new ArrayList<Integer>();
		mColorIntegerList.add(R.drawable.background_004);
		mColorIntegerList.add(R.drawable.background_005);
		mColorIntegerList.add(R.drawable.background_006);
		mColorIntegerList.add(R.drawable.background_007);
		mColorIntegerList.add(R.drawable.background_008);
		mColorIntegerList.add(R.drawable.background_009);
		mColorIntegerList.add(R.drawable.background_010);
		mColorIntegerList.add(R.drawable.background_011);

		mAllListView.setAdapter(new ListProductTypeAdapter(getActivity()
				.getApplicationContext(), mTitleStringList, mColorIntegerList));
	}

	private void initView() {
		// TODO Auto-generated method stub
		mAllListView = (ListView) mView.findViewById(R.id.allListView);
	}

	/**
	 * 左侧菜单 点击回调接口
	 * 
	 * @author FX_SKY
	 * 
	 */
	public interface SLMenuListOnItemClickListener {

		public void selectItem(int position, String title);
	}
}
