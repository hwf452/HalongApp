package com.halong.halongapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.halong.halongapp.R;

public class ActionAdapter extends BaseAdapter {

	private Context mContext;
	private int[] mGridViewItemArray= new int[]{R.drawable.picture008,R.drawable.picture009,R.drawable.picture010,R.drawable.picture011,R.drawable.picture012,R.drawable.picture013,R.drawable.picture014,R.drawable.picture015,R.drawable.picture016} ;
	
	public ActionAdapter (Context context){
		this.mContext=context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mGridViewItemArray.length;
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_main_action, null);
		}
		int height=parent.getHeight();
		height=(int) (height/3-mContext.getResources().getDimension(R.dimen.gridview_Spacing)-mContext.getResources().getDimension(R.dimen.gridview_padding));
		convertView.setMinimumHeight(height );
		convertView.setBackgroundResource(mGridViewItemArray[position]);
		return convertView;
	}

}
