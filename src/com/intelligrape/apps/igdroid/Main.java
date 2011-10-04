package com.intelligrape.apps.igdroid;



import com.intelligrape.apps.igdroid.UI.BasicUIImplementation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends BasicUIImplementation {
	private Integer timer = 2000;
	final Main main = this;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		splashScreenToMainActivity(timer);		
	}
	
	private void splashScreenToMainActivity(final Integer timer) {		
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					sleep(timer);
				} catch (InterruptedException e) {
				} finally {
		
					moveToMainPage(main);					
				}
			}
		};
		splashTread.start();
		
	}
	
	public void logoImageClicked(View view){
		moveToMainPage(main);
	}
}