package com.intelligrape.apps.igdroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;

import com.intelligrape.apps.igdroid.UI.BasicUIImplementation;
import com.intelligrape.apps.igdroid.domain.Mail;

public class ContactMailActivity extends BasicUIImplementation {

	private EditText nameTextBox;
	private EditText emailTextBox;
	private EditText subjectTextBox;
	private EditText commentTextBox;
	private Spinner spinner;
	private AlertDialog alertDialog;
	private ContactMailActivity contactMailActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query);
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

	public void collectDataAndSendMail(View view) {
		Mail mail = new Mail(nameTextBox.getText().toString(), 
							 subjectTextBox.getText().toString(), 
							 spinner.getSelectedItem().toString(),
							 commentTextBox.getText().toString(), 
							 emailTextBox.getText().toString());
		
		mail.sendMail();
		String alertTitle = getResources().getString(R.string.mail_alert_title);
		createAlert(this, alertTitle).show();
	}

	private AlertDialog createAlert(final Activity activity, String alertTitle) {
		Builder builder = createBuilderForAlertDialog(alertTitle);
		String positiveButtonTitle = getResources().getString(
				R.string.pos_button_title);
		builder.setPositiveButton(positiveButtonTitle,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						moveToContactUsPage(activity);
					}
				});
		AlertDialog alert = builder.create();
		return alert;
	}

}
