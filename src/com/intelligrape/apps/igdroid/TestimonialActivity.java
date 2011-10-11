package com.intelligrape.apps.igdroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class TestimonialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us_testimonial);
	}

	
	public void backButtonClicked(View v) {
		finish();
		
	}
}
