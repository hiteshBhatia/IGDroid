package com.intelligrape.apps.igdroid;

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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query);
		setUpViews();
	}

	private void setUpViews() {
		nameTextBox = (EditText) findViewById(R.id.editText1);
		emailTextBox = (EditText) findViewById(R.id.editText2);
		subjectTextBox = (EditText) findViewById(R.id.editText3);
		commentTextBox = (EditText) findViewById(R.id.editText4);
		spinner = createSimpleSpinner(R.id.spinner1, this,
				R.array.category_array);
	}

	// protected void cancel(){
	// System.out.println("-----Are you sure want to cancel");
	// }

	public void collectDataAndSendMail(View view) {
		Mail mail = new Mail(nameTextBox.getText().toString(), subjectTextBox
				.getText().toString(), spinner.getSelectedItem().toString(),
				commentTextBox.getText().toString(), emailTextBox.getText()
						.toString());
		mail.sendMail();
	}

}
