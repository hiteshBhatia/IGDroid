package com.intelligrape.apps.igdroid.domain;

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
		// Do Soething
	}
}
