package com.halong.halongapp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;

import com.halong.halongapp.R;

public class DevelopAdapter extends BaseAdapter{

	private Context mContext;
	private List<View> mList ;
	
	private boolean mIsList;
	
	public DevelopAdapter(Context context,boolean isList){
		this.mContext=context;
		this.mIsList=isList;
	}
	
	/**
	 * mList.size()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 20;
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
			if (mIsList) {
				convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_develop, null);
			}else {
				convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_develop, null);
			}
		}
		
		return convertView;
	}
	
	

}
