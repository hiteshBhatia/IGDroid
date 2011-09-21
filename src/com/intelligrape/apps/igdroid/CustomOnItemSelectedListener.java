package com.intelligrape.apps.igdroid;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
	String selectedValue = "";
	@Override
	public void onItemSelected(AdapterView<?> array, View arg1, int pos,long arg3) {
		selectedValue = array.getItemAtPosition(pos).toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	String getSelectedValue(){		
		return selectedValue;		
	}
}
