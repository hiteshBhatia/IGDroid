package dev.intelligrape.igdroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactMailActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textview = new TextView(this);
		textview.setText("This is the Tab 2");
		setContentView(R.layout.query);

	}
}

