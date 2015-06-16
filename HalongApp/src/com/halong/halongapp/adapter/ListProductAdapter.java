package com.halong.halongapp.adapter;

import java.util.List;

import com.halong.halongapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListProductAdapter extends BaseAdapter {

	private Context mContext;
	private List<String> mList ;
	
	public ListProductAdapter(Context context,List<String> list){
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_product_service, null);
		}
		TextView textView = (TextView) convertView.findViewById(R.id.productTitleTextView);
		textView.setText(mList.get(position));
		
		return convertView;
	}

}
