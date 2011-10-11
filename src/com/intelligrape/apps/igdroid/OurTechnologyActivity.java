
package com.intelligrape.apps.igdroid;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

import com.intelligrape.apps.igdroid.Basic.BasicReuseableComponents;

public class OurTechnologyActivity extends BasicReuseableComponents implements
		ViewFactory, OnClickListener {
	final OurTechnologyActivity ourTechnologyActivity = this;
	private TextSwitcher textSwitcher;
	private int mCounter = 0;
	private String[] techArray;
	private int totalSize = 48;
	private String term;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.our_technology);
		setUpVariables();
		setUpTextSwitcher();
	}

	private void setUpVariables() {
		techArray = getResources().getStringArray(R.array.tech_array);
	}

	public void homeButtonClicked(View v) {	
		finish();
	}

	private void setUpTextSwitcher() {
		textSwitcher = createTextSwitcher(this, R.id.textSwitcher1);
		Button nextButton = (Button) findViewById(R.id.next_button);
		nextButton.setOnClickListener(this);
		updateCounter();
	}

	private void updateCounter() {
		term = techArray[mCounter];
		textSwitcher.setText(term);
	}

	@Override
	public View makeView() {
		TextView t = new TextView(this);
		t.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
		t.setTextSize(36);
		return t;
	}

	public void groovyImageClicked(View v) {
		String url = getResources().getString(R.string.groovy_org);
		startBrowserWithUrl(url);
	}

	public void grailsImageClicked(View v) {
		String url = getResources().getString(R.string.grails_org);
		startBrowserWithUrl(url);
	}
	
	public void prevButtonClicked(View v) {
		if (mCounter > 0) {
			int negativeOne = -1;
			updateCounterBy(negativeOne);			
		}
	}

	@Override
	public void onClick(View arg0) {
		updateCounterBy(1);

	}

	private void updateCounterBy(int number) {
		mCounter = mCounter + number;
		mCounter = mCounter % totalSize;
		updateCounter();
	}
}
