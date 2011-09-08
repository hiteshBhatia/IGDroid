package dev.intelligrape.igdroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactDetailActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textview = new TextView(this);
		String  toShowText ="Contact Address : \nIntelliGrape Software (P) Ltd \nSDF L-6, NSEZ \nNoida Phase 2\nIndia" +
				"\nPhone : +91-120-4207638 \nFax : +91-120-4207689";
		textview.setText(toShowText);
		setContentView(textview);
		
	}
}
