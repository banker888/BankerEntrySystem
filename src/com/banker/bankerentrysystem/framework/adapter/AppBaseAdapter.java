package com.banker.bankerentrysystem.framework.adapter;

import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class AppBaseAdapter<T> extends BaseAdapter {
	
	protected Context mContext;
	/** 数据 **/
	private List<T> mDatasList;
	
	public AppBaseAdapter(Context context) {
		mContext = context;
	}
	
	/** 初使化数据 **/
	public void initDatas(List<T> datasList) {
		this.mDatasList = datasList;
	}
	
	/** 追加数据，更新ListView **/
	public void addData(List<T> datasList) {
		if(null != datasList) {
			if(null == mDatasList) {
				mDatasList = datasList;
			}else {
				mDatasList.addAll(mDatasList.size(), datasList);
				notifyDataSetChanged();
			}
		}
	}

	/** 要显示的条目数 **/
	@Override
	public int getCount() {
		return mDatasList.size();
	}
	/** 当前位置上item里的所有数据 **/
	@Override
	public Object getItem(int position) {
		return mDatasList.get(position);
	}
	/** 获得当前条目的id **/
	@Override
	public long getItemId(int position) {
		return position;
	}

}
