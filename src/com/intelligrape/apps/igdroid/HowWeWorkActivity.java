package com.intelligrape.apps.igdroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import com.intelligrape.apps.igdroid.Basic.BasicReuseableComponents;

public class HowWeWorkActivity extends BasicReuseableComponents {
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