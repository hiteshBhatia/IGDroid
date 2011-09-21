package com.intelligrape.apps.igdroid.UI;

import com.intelligrape.apps.igdroid.ContactMailActivity;
import com.intelligrape.apps.igdroid.CustomOnItemSelectedListener;
import com.intelligrape.apps.igdroid.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BasicUIImplementation extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
	}
	
	protected Spinner createSimpleSpinner(int spinner1,ContactMailActivity contactMailActivity, int array) {
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, array,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		return spinner;		
	}

}
