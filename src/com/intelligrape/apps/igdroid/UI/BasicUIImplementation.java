package com.intelligrape.apps.igdroid.UI;

import com.intelligrape.apps.igdroid.ContactDetailActivity;
import com.intelligrape.apps.igdroid.ContactInfoActivity;
import com.intelligrape.apps.igdroid.ContactMailActivity;
import com.intelligrape.apps.igdroid.CustomOnItemSelectedListener;
import com.intelligrape.apps.igdroid.DashboardActivity;
import com.intelligrape.apps.igdroid.Main;
import com.intelligrape.apps.igdroid.R;
import com.intelligrape.apps.igdroid.basicIntents.IntentManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.ViewFlipper;

public class BasicUIImplementation extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
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
	
	protected void moveToContactUsPage(Activity activity) {
		Intent intent = new Intent(activity, ContactDetailActivity.class);		
		startActivity(intent);
	}
	
	protected Builder createBuilderForAlertDialog(String alertTitle) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(alertTitle).setCancelable(false);
		return builder;
	}
	
	protected void moveToMainPage(final Activity activity){
		startActivity(new Intent(activity,DashboardActivity.class));		
	}
	
	protected TextSwitcher createTextSwitcher(Activity activity, int textswitcherId) {
		TextSwitcher textSwitcher;
		textSwitcher = (TextSwitcher) findViewById(textswitcherId);
		textSwitcher.setFactory((ViewFactory) activity);
		Animation in = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
		Animation out = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
		textSwitcher.setInAnimation(in);
		textSwitcher.setOutAnimation(out);
		return textSwitcher;
	}
	
	public void startBrowserWithUrl(String url) {
		Intent browserIntent = IntentManager.getInstance().createBrowserIntent(url);
		startActivity(browserIntent);
	}
	
	
	

}
