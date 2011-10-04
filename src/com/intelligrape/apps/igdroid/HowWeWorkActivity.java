package com.intelligrape.apps.igdroid;

import com.intelligrape.apps.igdroid.UI.BasicUIImplementation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class HowWeWorkActivity extends BasicUIImplementation {
    boolean isRunning = true ;
	private ViewFlipper vf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.how_we_work);
		setupViews();
	}

	private void setupViews() {
		vf = (ViewFlipper)findViewById(R.id.viewFlipper1);
		
	}

	public void homeButtonClicked(View view) {
		finish();
	}

	public void pauseButtonClicked(View view) {
		if(isRunning){
			vf.stopFlipping();
			isRunning = false;
		}
	}
	
	public void playButtonClicked(View view) {
		if(!isRunning){
			vf.startFlipping();
			isRunning = true;
		}
	}
	
}