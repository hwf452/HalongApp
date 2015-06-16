package com.halong.halongapp.ui;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.halong.halongapp.R;
import com.halong.halongapp.adapter.ListViewPartnerAdapter;
import com.halong.halongapp.util.MyActivity;

public class PartnerActivity extends MyActivity {
	private ListView mPartnerListView ;
	private List<String> mPartnerList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_partner);
		initView();
		initData();
		initListView();
		myStartAnimation();
	}

	private void initListView() {
		// TODO Auto-generated method stub
		mPartnerListView.setAdapter(new ListViewPartnerAdapter(this, mPartnerList));
		
	}

	private void initData() {
		// TODO Auto-generated method stub
		mPartnerList = new ArrayList<String>();
		
		mPartnerList.add("广东省质量技术监督局");
		mPartnerList.add("广东科学技术职业学院");
		mPartnerList.add("新网互联");
		mPartnerList.add("北京理工大学珠海分院");
		mPartnerList.add("珠海格力地产");
		mPartnerList.add("共青团珠海市委员会");
		mPartnerList.add("珠海市关爱协会");
		mPartnerList.add("珠海市商业连锁协会");
		mPartnerList.add("珠海市综合培训中心");
	}

	private void initView() {
		// TODO Auto-generated method stub
		mPartnerListView = (ListView) findViewById(R.id.partnerListView);
	}
}
