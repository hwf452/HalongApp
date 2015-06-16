package com.halong.halongapp.adapter;

import java.util.ArrayList;
import java.util.List;

import com.halong.halongapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewNewsAdapter extends BaseAdapter{

	private Context mContext;
	private List<View> mList ;
	
	public ListViewNewsAdapter(Context context){
		this.mContext=context;
	}
	
	/**
	 * mList.size()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_news, null);
		}
		
		return convertView;
	}

}
