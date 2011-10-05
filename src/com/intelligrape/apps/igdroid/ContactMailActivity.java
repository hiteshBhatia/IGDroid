package com.intelligrape.apps.igdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;

import com.intelligrape.apps.igdroid.UI.BasicUIImplementation;
import com.intelligrape.apps.igdroid.constants.IGConstants;
import com.intelligrape.apps.igdroid.domain.Mail;

public class ContactMailActivity extends BasicUIImplementation implements
		Runnable {

	private EditText nameTextBox;
	private EditText emailTextBox;
	private EditText subjectTextBox;
	private EditText commentTextBox;
	private Spinner spinner;
	private AlertDialog alertDialog;
	private ContactMailActivity contactMailActivity;
	String positiveButtonTitle = IGConstants.POS_BUTTON_TITLE;
	String negativeButtonTitle = IGConstants.NEG_BUTTON_TITLE;
	boolean sendMail = true;
	boolean mailSent = false;
	private ProgressDialog progressDialog;
	private String name;
	private String subject;
	private String category;
	private String comment;
	private String email;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_info_query);
		setUpViews();
	}

	private void setUpViews() {
		contactMailActivity = this;
		nameTextBox = (EditText) findViewById(R.id.editText1);
		emailTextBox = (EditText) findViewById(R.id.editText2);
		subjectTextBox = (EditText) findViewById(R.id.editText3);
		commentTextBox = (EditText) findViewById(R.id.editText4);
		spinner = createSimpleSpinner(R.id.spinner1, this,
				R.array.category_array);
	}

	public void backButtonClicked(View v) {
		String alertTitle = getResources().getString(
				R.string.contact_info_alert_warn);
		createWarningAlert(this, alertTitle).show();
	}

	private Dialog createWarningAlert(ContactMailActivity contactMailActivity2,
			String alertTitle) {
		Builder builder = createBuilderForAlertDialog(alertTitle);
		builder.setPositiveButton(positiveButtonTitle,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						finish();
					}
				});
		builder.setNegativeButton(negativeButtonTitle,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		return alert;
	}

	public void collectDataAndSendMail(View view) {
		populateFields();
		boolean validated = validateFields();
		if (validated) {
			progressDialog = ProgressDialog.show(this, "Sending Mail","Please Wait", true, false);
			Thread thread = new Thread(this);
			thread.start();
		} else {
			showErrorAlert();
		}
	}

	private void populateFields() {
		name = nameTextBox.getText().toString();
		subject = subjectTextBox.getText().toString();
		category = spinner.getSelectedItem().toString();
		comment = commentTextBox.getText().toString();
		email = emailTextBox.getText().toString();
	}

	private void showErrorAlert() {
		createErrorAlert(this, getResources().getString(R.string.error_alert)).show();
	}

	private Dialog createErrorAlert(ContactMailActivity contactMailActivity2,String string) {
		Builder builder = createBuilderForAlertDialog(string);
		builder.setPositiveButton(positiveButtonTitle,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		return alert;
	}

	private boolean createAndSendMail() {
		boolean success = true;
		Mail mail = new Mail(name, subject, category, comment, email);
		success = mail.sendMail();
		return success;
	}

	private boolean validateFields() {
		boolean validated = true;
		//String.isEmpty Not Available in Froyo.
		if (isEmpty(name) || isEmpty(subject) || isEmpty(category) || isEmpty(email)) {
			validated = false;
		}
		return validated;
	}

	private boolean isEmpty(String str) {
		return str.length() == 0; 
	}

	private AlertDialog createAlert(final Activity activity, String alertTitle) {
		Builder builder = createBuilderForAlertDialog(alertTitle);
		builder.setPositiveButton(positiveButtonTitle,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						finish();
					}
				});
		AlertDialog alert = builder.create();
		return alert;
	}

	@Override
	public void run() {
		mailSent = createAndSendMail();
		handler.sendEmptyMessage(0);
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			progressDialog.dismiss();
			String alertTitle = getResources().getString(R.string.mail_alert_fail);
			if (mailSent) {
				alertTitle = getResources().getString(R.string.mail_alert_title);
			}
			createAlert(contactMailActivity, alertTitle).show();

		}
	};
}
