package com.intelligrape.apps.igdroid;

import com.intelligrape.apps.igdroid.basicIntents.IntentManager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ContactDetailActivity extends Activity {

	private java.lang.String phoneNumber;
	private String chooseIntent;
	private String[] recipient;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUpViews();
		setContentView(R.layout.contact_info);
	}

	private void setUpViews() {
		phoneNumber = getResources().getString(R.string.our_number_1);
		chooseIntent = getResources().getString(R.string.chooseIntent);
		recipient = getResources().getStringArray(R.array.recipient_array);
	}

	public void phoneNumberTapped(View v) {
		dialPhone();
	}

	public void emailUsTapped(View v) {
		sendEmail();
	}

	private void sendEmail() {
		IntentManager intentManager = IntentManager.getInstance();
		Intent emailIntent = intentManager.createEmailIntent(recipient,"subject","text");
		startActivity(Intent.createChooser(emailIntent, chooseIntent));
	}
	
	

	private void dialPhone() {
		Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
				+ phoneNumber));
		startActivity(dialIntent);
	}

}
