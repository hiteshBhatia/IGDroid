package com.intelligrape.apps.igdroid.basicIntents;

import android.content.Intent;

public class IntentManager {
	private static IntentManager instance;

	private IntentManager() {
	}

	public static synchronized IntentManager getInstance() {
		if (instance == null) {
			instance = new IntentManager();
		}
		return instance;
	}

	public Intent createEmailIntent(String[] recipient, String subject,
			String text) {
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("text/plain");
		emailIntent.putExtra(Intent.EXTRA_EMAIL, recipient);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, text);
		return emailIntent;
	}
}
