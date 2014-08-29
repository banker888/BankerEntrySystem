package com.banker.bankerentrysystem.framework.bean;

import java.util.ArrayList;

public class BannerItem {
	
	public String stautus;
	public String msg;
	public String total;
	
	public class List{
		public String title;
		public String url;
		public String id;
		public String img;
	}
	
	public ArrayList<List> lists = new ArrayList<List>();
	
}
