package com.intelligrape.apps.igdroid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		   setContentView(R.layout.dashboard);
	}
	
	public void contactUsClicked(View v){
		Intent intent = new Intent(this, ContactInfoActivity.class);		
		startActivity(intent);
	}

}
