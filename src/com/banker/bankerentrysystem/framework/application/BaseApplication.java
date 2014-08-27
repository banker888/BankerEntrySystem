package com.banker.bankerentrysystem.framework.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class BaseApplication extends Application {
	
	/** 全局上下文 **/
	public static Context appContext;
//	public static Handler appHandler;
	
	/** 屏幕高 **/
	public static int screenHeight;
	/** 屏幕宽 **/
	public static int screenWidth;
	
	public static float screenDensity;
	public static int screenDensityDpi;

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	/** 整个应用的入口 **/
	@Override
	public void onCreate() {
		super.onCreate();
		appContext = getApplicationContext();
		initDisplayMetrics();
	}
	
	/** 实使化屏幕的相关参数 **/
	private void initDisplayMetrics() {
		DisplayMetrics _displayMetrics = new DisplayMetrics();
		
		WindowManager _windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		_windowManager.getDefaultDisplay().getMetrics(_displayMetrics);
		
		//是否竖屏
		boolean _isPortrait = _displayMetrics.widthPixels < _displayMetrics.heightPixels;
		if(_isPortrait) {
			//如果是竖屏的话那么screenWidth = 屏幕的宽度,screenHeight = 屏幕高度
			screenWidth = _displayMetrics.widthPixels;
			screenHeight = _displayMetrics.heightPixels;
		}else {
			//如果是竖屏的话那么screenWidth = 屏幕的高度,screenHeight = 屏幕宽度
			screenWidth = _displayMetrics.heightPixels;
			screenHeight = _displayMetrics.widthPixels;
		}
		
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		
		
		super.onTerminate();
	}

}
