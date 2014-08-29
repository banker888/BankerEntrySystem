package com.banker.bankerentrysystem.framework.views;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.banker.bankerentrysystem.R;

public class TopBarView {
	private Activity activity;
	private RelativeLayout relativeLayout;
	private ImageButton imgB_topLeft;
	private ImageButton imgB_topRight;
	private ImageButton imgB_downArrow;
	private TextView txtV_topTitle;
	private LinearLayout lay_centerDown;
	
	public TopBarView(Activity activity) {
		this.activity = activity;
		relativeLayout = (RelativeLayout) activity.findViewById(R.id.framework_topBar);
		initView();
	}

	private void initView() {
		imgB_topLeft = (ImageButton) relativeLayout.findViewById(R.id.imgB_topLeft);
		imgB_topRight = (ImageButton) relativeLayout.findViewById(R.id.imgB_topRight);
		imgB_downArrow = (ImageButton) relativeLayout.findViewById(R.id.imgB_downArrow);
		txtV_topTitle = (TextView) relativeLayout.findViewById(R.id.txtV_topTitle);
		lay_centerDown = (LinearLayout) relativeLayout.findViewById(R.id.lay_centerDown);
	}
	
	/** 设置顶部条title的文本内容 **/
	public void setTopTitle(String text) {
		txtV_topTitle.setText(text);
	}  
	
	/** 设置顶部条title的文本内容 **/
	public void setTopTitle(int stringResId) {
		String text = activity.getResources().getString(stringResId).toString();
		txtV_topTitle.setText(text);
	}
	
	/** 改变顶部条左边的图标 **/
	public void changeTopLeft(int iconResId) {
		imgB_topLeft.setBackgroundResource(iconResId);
	}
	
	/** 改变顶部条右边的图标 **/
	public void changeTopRight(int iconResId) {
		imgB_topRight.setBackgroundResource(iconResId);
	}
	
	/** 隐藏顶部条左边的图标 **/
	public void hideTopLeft() {
		imgB_topLeft.setVisibility(View.GONE);
	}
	
	/** 隐藏顶部条右边的图标 **/
	public void hideTopRight() {
		imgB_topRight.setVisibility(View.GONE);
	}
	
	/** 隐藏顶部的下拉三角箭头 **/
	public void hideTopDownArrow() {
		imgB_downArrow.setVisibility(View.GONE);
	}
	
	/** 顶部左边图标事件 **/
	public void setTopLeftListener(View.OnClickListener onClickListener) {
		imgB_topLeft.setOnClickListener(onClickListener);
	}
	
	/** 顶部右边图标事件 **/
	public void setTopRightListener(View.OnClickListener onClickListener) {
		imgB_topRight.setOnClickListener(onClickListener);
	}
	
	/** 顶部title的下拉事件 **/
	public void setTopTitleListener(View.OnClickListener onClickListener) {
		lay_centerDown.setOnClickListener(onClickListener);
	}
	
	/** 禁止顶部的Title被点击 **/
	public void setTopTitleBannedClick() {
		lay_centerDown.setClickable(false);
	}
}
