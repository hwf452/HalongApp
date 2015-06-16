package com.halong.halongapp.adapter;

import java.util.List;

import com.halong.halongapp.R;

import android.R.integer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListProductTypeAdapter extends BaseAdapter {

	private Context mContext;
	private List<String> mTitleStringList ;
	private List<Integer> mColorIntegerList;
	
	public ListProductTypeAdapter(Context context,List<String> titleStringList,List<Integer> colorIntegerList){
		this.mContext=context;
		this.mTitleStringList=titleStringList;
		this.mColorIntegerList=colorIntegerList;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		Log.v("lihua", this.toString());
		return mTitleStringList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_product_left, null);
		}
		TextView textView = (TextView) convertView.findViewById(R.id.typeTextView);
		textView.setText(mTitleStringList.get(position));
		RelativeLayout relativeLayout = (RelativeLayout) convertView.findViewById(R.id.colorRelativeLayout);
		relativeLayout.setBackgroundResource(mColorIntegerList.get(position));
		
		return convertView;
	}

}
