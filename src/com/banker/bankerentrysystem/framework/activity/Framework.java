package com.banker.bankerentrysystem.framework.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.banker.bankerentrysystem.R;
import com.banker.bankerentrysystem.framework.views.TopBarView;

public class Framework extends BaseActivity {
	
	private TopBarView topBarView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		requestWindowFeature(Window.FEATURE_NO_TITLE);//无标题		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏
		setContentView(R.layout.framework);
		initView();
	}
	
	private void initView() {
		topBarView = new TopBarView(this);
	}
	
	/** 往framework的中间区域添加不同页面的内容 **/
	protected void addCenterView(int layoutResourceId) {
		RelativeLayout _layout = (RelativeLayout) findViewById(R.id.framework_center);
		View _view = infl(layoutResourceId);
		RelativeLayout.LayoutParams _layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		_layout.addView(_view, _layoutParams);
	}
	
	/** 设置顶部条title的文本内容 **/
	protected void setTopTitle(String text) {
		topBarView.setTopTitle(text);
	}
	
	/** 设置顶部条title的文本内容 **/
	protected void setTopTitle(int stringResId) {
		topBarView.setTopTitle(stringResId);
	}
	
	/** 改变顶部条左边的图标 **/
	protected void changeTopLeft(int iconResId) {
		topBarView.changeTopLeft(iconResId);
	}
	
	/** 改变顶部条右边的图标 **/
	protected void changeTopRight(int iconResId) {
		topBarView.changeTopRight(iconResId);
	}
	
	/** 隐藏顶部条左边的图标 **/
	protected void hideTopLeft() {
		topBarView.hideTopLeft();
	}
	
	/** 隐藏顶部条右边的图标 **/
	protected void hideTopRight() {
		topBarView.hideTopRight();
	}
	
	/** 顶部左边图标事件 **/
	protected void setTopLeftListener(View.OnClickListener onClickListener) {
		topBarView.setTopLeftListener(onClickListener);
	}
	
	/** 顶部右边图标事件 **/
	protected void setTopRightListener(View.OnClickListener onClickListener) {
		topBarView.setTopRightListener(onClickListener);
	}
	
}
