package com.intelligrape.apps.igdroid;


import com.intelligrape.apps.igdroid.UI.BasicUIImplementation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends BasicUIImplementation {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		   setContentView(R.layout.dashboard);		   
	}
		
	public void contactUsClicked(View v){
		moveToContactUsPage(this);
	}

	public void ourTechnologyClicked(View v){
		startActivity(new Intent(this,OurTechnologyActivity.class));	
	}
	
	public void howWeWorkClicked(View v){
		startActivity(new Intent(this,HowWeWorkActivity.class));	
	}
	
	
	
	public void aboutUsClicked(View v){
		startActivity(new Intent(this,AboutUsActivity.class));	
	}
	

	

}
