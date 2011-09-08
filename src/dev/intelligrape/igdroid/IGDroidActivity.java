package dev.intelligrape.igdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IGDroidActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void enterButtonClicked(View v) {
		Intent intent = new Intent(this, ContactInfoActivity.class);		
		startActivity(intent);
	}
}