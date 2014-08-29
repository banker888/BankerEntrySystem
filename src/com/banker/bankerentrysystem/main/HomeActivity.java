package com.banker.bankerentrysystem.main;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.banker.bankerentrysystem.R;
import com.banker.bankerentrysystem.customer_amount.activity.CustomerAmountActivity;
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
		setTopTitleBannedClick();
		hideTopDownArrow();
		changeTopLeft(R.drawable.btn_top_info);
		changeTopRight(R.drawable.btn_top_setting);
		setTopLeftListener(this);
		setTopRightListener(this); 
		
		((RelativeLayout)findViewById(R.id.kehushu)).setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		
		switch (view .getId()) {
		//顶部条左边图标
		case R.id.imgB_topLeft:{
			showToast(R.string.info);
			break;
		}
		//顶部条右边图标
		case R.id.imgB_topRight:{
			showToast(R.string.setting);
			break;
		}
		//客户数
		case R.id.kehushu:
			startActivity(CustomerAmountActivity.class);
			break;

		default:
			break;
		}
	}

}
