package com.intelligrape.apps.igdroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class ContactDetailActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	
	        		
		TextView textview = new TextView(this);
		String  toShowText ="Contact Address \nIntelliGrape Software (P) Ltd \nSDF L-6, NSEZ \nNoida Phase 2\nIndia\n";				
		textview.setText(toShowText);
		setContentView(textview);
		
		
		
		/*TextView numberField = new TextView(this);
		String  dailMe ="+91-120-4207638"; //\nFax : +91-120-4207689";
		numberField.setText(dailMe);
		setContentView(numberField);
		
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:" + numberField.getText())); // set the Uri
		startActivity(intent);*/			
		
		
		
	}
	
	
}
