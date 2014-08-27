package com.banker.bankerentrysystem.main;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.banker.bankerentrysystem.R;
import com.banker.bankerentrysystem.framework.activity.Framework;

public class HomeActivity extends Framework implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addCenterView(R.layout.activity_home);
		initView();
	}
	
	private void initView() {
		setTopTitle(R.string.EntrySystem);
		changeTopLeft(R.drawable.btn_top_info);
		changeTopRight(R.drawable.btn_top_setting);
		setTopLeftListener(this);
		setTopRightListener(this);
	}

	private int count = 0;
	@Override
	public void onClick(View view) {
		count++;
		showToast("..." + count + "...");
	}

}
