package com.banker.bankerentrysystem.main;

import org.apache.http.Header;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.banker.bankerentrysystem.R;
import com.banker.bankerentrysystem.customer_amount.activity.CustomerAmountActivity;
import com.banker.bankerentrysystem.framework.activity.Framework;
import com.banker.bankerentrysystem.framework.bean.BannerItem;
import com.banker.bankerentrysystem.framework.utils.URLUtils;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.OnSliderClickListener;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class HomeActivity extends Framework implements OnClickListener, OnSliderClickListener {
	private SliderLayout mSlider;
	private BannerItem item;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addCenterView(R.layout.activity_home);
		initView();
		initBanner();
		initDataFromWeb();
	}
	


	private void initBanner() {
		mSlider = (SliderLayout) findViewById(R.id.sliderlayout);
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
	
	private void initDataFromWeb() {
		AsyncHttpClient client = new AsyncHttpClient();
		client.post(URLUtils.URL_Banner, new AsyncHttpResponseHandler() {
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2,
					Throwable arg3) {
				showToast("网络连接错误");
			}
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				item = new Gson().fromJson(new String(arg2), BannerItem.class);
				for (int i = 0; i < item.lists.size(); i++) {
					TextSliderView textSliderView = new TextSliderView(
							HomeActivity.this);
					textSliderView.image(item.lists.get(i).img)
					.setOnSliderClickListener(HomeActivity.this);
					mSlider.addSlider(textSliderView);
				}
				mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
				mSlider.setDuration(4000);
			}
		});
	}


	@Override
	public void onSliderClick(BaseSliderView slider) {
			showToast("广告");
	}
	
	

}
