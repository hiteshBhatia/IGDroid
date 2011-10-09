package com.intelligrape.apps.igdroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.intelligrape.apps.igdroid.Basic.BasicReuseableComponents;
import com.intelligrape.apps.igdroid.basicIntents.IntentManager;

public class ContactDetailActivity extends BasicReuseableComponents {

	private java.lang.String phoneNumber;
	
	
	IntentManager intentManager = IntentManager.getInstance();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUpViews();
		setContentView(R.layout.contact_info);
	}

	private void setUpViews() {
		phoneNumber = getResources().getString(R.string.our_number_1);		
	
	}

	public void phoneNumberTapped(View v) {
		dialPhone();
	}

	public void emailUsTapped(View v) {
		sendEmail();
	}

	private void sendEmail() {
		startActivity(new Intent(this, ContactMailActivity.class));
	}

	public void backButtonClicked(View v) {
		finish();
	}

	private void dialPhone() {
		Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
				+ phoneNumber));
		startActivity(dialIntent);
	}

	public void locateUsClicked(View v) {
		startActivity(new Intent(this, LocateUsActivity.class));
	}

	public void findUsOnWebClicked(View v) {
		String url = getResources().getString(R.string.intelligrape_web);
		startBrowserWithUrl(url);
	}
}
