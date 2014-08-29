package com.banker.bankerentrysystem.customer_amount.activity;

import android.os.Bundle;

import com.banker.bankerentrysystem.R;
import com.banker.bankerentrysystem.framework.activity.Framework;

public class CustomerAmountActivity extends Framework {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addCenterView(R.layout.activity_cutsomer_amount);
		init();
	}

	private void init() {
		initView();
	}
	
	private void initView() {
		setTopTitle(R.string.appModule_customerAmount);
//		changeTopLeft(iconResId)
//		changeTopRight(iconResId)
	}
}
      