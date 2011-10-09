package com.intelligrape.apps.igdroid.domain;

import android.util.Log;

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

	public boolean sendMail() {
		boolean success = true;
		try {			
				GMailSender sender = new GMailSender(IGConstants.APPS_EMAIL_ADD, IGConstants.APPS_PWD);
				success = sender.sendMail(this.subject, getBody(), IGConstants.APPS_EMAIL_ADD, IGConstants.RECIPIENT);
				System.out.print("**********"+success);
		} catch (Exception e) {
			Log.e("SendMail", e.getMessage(), e);
			success = false;
		}
		return success;		
	}


	private String getBody() {
		String body = "Dear Intelligrape";
		body = body.concat("\nSubject ").concat(this.subject);
		body = body.concat("\nCategory ").concat(this.category);
		body = body.concat("\n\n").concat(this.comment);
		body = body.concat("\n_______________");
		body = body.concat("\n").concat(this.name).concat("\n")
				.concat(this.email);
		return body;
	}
}
