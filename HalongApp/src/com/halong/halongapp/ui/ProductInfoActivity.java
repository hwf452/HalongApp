package com.halong.halongapp.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.halong.halongapp.R;
import com.halong.halongapp.util.MyActivity;

public class ProductInfoActivity extends MyActivity {
	
	private LinearLayout mBackLinearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_info);
		
		mBackLinearLayout=(LinearLayout) findViewById(R.id.linearLayout);
		mBackLinearLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
