package com.banker.bankerentrysystem.framework.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.banker.bankerentrysystem.framework.application.BaseApplication;

public class BaseActivity extends Activity {
	
	protected Toast mToast = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	protected BaseApplication getBaseApplication() {
		return (BaseApplication)getApplication();
	}
	
	protected Context getContext(){
		return getApplicationContext();
	}
	
	/** 启动另一个Activity **/
	protected void  startActivity(Class<?> activityClass) {
		Intent _intent = new Intent( this, activityClass);
		startActivity(_intent);
	}
	
	/** 加载布局文件 **/
	protected View infl(int layoutResourceId) {
		return LayoutInflater.from(getApplicationContext()).inflate(layoutResourceId, null);
	}
	
	/** 显示Toast **/
	protected void showToast(String text) {
		if(null != mToast) {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}else {
			mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
		}
		mToast.show();
	}
	
	/** 显示Toast **/
	protected void showToast(int stringResId) {
		String text = useStringTypeResource(stringResId);
		if(null != mToast) {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}else {
			mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
		}
		mToast.show();
	}
	
	/** 使用String资源文件 **/
	protected String useStringTypeResource(int stringResId) {
		return getResources().getString(stringResId).toString();
	}
	
}
