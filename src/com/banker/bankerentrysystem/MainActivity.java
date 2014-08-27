package com.banker.bankerentrysystem;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.banker.bankerentrysystem.framework.activity.BaseActivity;

public class MainActivity extends BaseActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		((Button)findViewById(R.id.btn)).setOnClickListener(this);
		
	}

	private int count = 0;
	@Override
	public void onClick(View arg0) {
		count ++;
		showToast(String.valueOf(count).toString());
	}

}
