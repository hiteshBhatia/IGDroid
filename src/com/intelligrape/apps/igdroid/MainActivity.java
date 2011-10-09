package com.intelligrape.apps.igdroid;



import android.os.Bundle;
import android.view.View;

import com.intelligrape.apps.igdroid.Basic.BasicReuseableComponents;

public class MainActivity extends BasicReuseableComponents {
	private Integer timer = 2000;
	final MainActivity main = this;
	

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