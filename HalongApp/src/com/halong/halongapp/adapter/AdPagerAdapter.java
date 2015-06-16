package com.halong.halongapp.adapter;

import java.util.List;

import com.halong.halongapp.ui.RecommendInfoActivity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AdPagerAdapter extends PagerAdapter {

	private List<View> mList;

	public AdPagerAdapter(List<View> list) {
		this.mList = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return (arg0 == arg1);
	}

	@Override
	public Object instantiateItem(final View arg0, int arg1) {
		((ViewPager) arg0).addView(mList.get(arg1));
		ImageView imageView =(ImageView) mList.get(arg1);
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(arg0.getContext(),RecommendInfoActivity.class);
				arg0.getContext().startActivity(intent);
			}
		});
		return mList.get(arg1);
	}

	// 销毁position位置的界面
	@Override
	public void destroyItem(View view, int position, Object arg2) {
		((ViewPager) view).removeView(mList.get(position));
	}
}
