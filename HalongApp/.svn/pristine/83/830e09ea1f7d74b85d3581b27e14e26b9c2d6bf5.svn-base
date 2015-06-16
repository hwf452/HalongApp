package com.halong.halongapp.adapter;

import java.util.ArrayList;
import java.util.List;

import com.halong.halongapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewPartnerAdapter extends BaseAdapter{

	private Context mContext;
	private List<String> mList ;
	
	public ListViewPartnerAdapter(Context context,List<String> list){
		this.mContext=context;
		this.mList=list;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_partner, null);
		}
		
		TextView textView= (TextView) convertView.findViewById(R.id.partnerTextView);
		textView.setText(mList.get(position));
		
		return convertView;
	}

}
