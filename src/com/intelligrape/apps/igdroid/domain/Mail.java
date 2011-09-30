package com.intelligrape.apps.igdroid.domain;

import android.util.Log;

import com.intelligrape.apps.igdroid.R;
import com.intelligrape.apps.igdroid.constants.IGConstants;
import com.intelligrape.apps.igdroid.mailSender.GMailSender;

public class Mail {
	String name;
	String subject;
	String category;
	String comment;
	String email;

	public Mail(String name, String subject, String category, String comment,
			String email) {
		this.name = name;
		this.subject = subject;
		this.category = category;
		this.comment = comment;
		this.email = email;
	}

	public void sendMail() {
		try {
			String appsEmail = IGConstants.appsEmailAddress;
			String appsPwd = IGConstants.appsPwd;
			GMailSender sender = new GMailSender(appsEmail, "f@ge3kn3rd");
			sender.sendMail(this.subject, getBody(), appsEmail, appsEmail);
		} catch (Exception e) {
			Log.e("SendMail", e.getMessage(), e);
		}
	}

	private String getBody() {
		String body = "Dear Intelligrape";
		body = body.concat("\nAbout ").concat(this.category);
		body = body.concat("\n\n").concat(this.comment);
		body = body.concat("\n_______________");
		body = body.concat("\n").concat(this.name).concat("\n")
				.concat(this.email);
		return body;
	}
}
