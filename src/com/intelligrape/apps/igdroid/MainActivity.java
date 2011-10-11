package com.intelligrape.apps.igdroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.intelligrape.apps.igdroid.Basic.BasicReuseableComponents;
import com.intelligrape.apps.igdroid.constants.IGConstants;
import com.intelligrape.apps.igdroid.service.DBService;
import com.intelligrape.apps.igdroid.src.CustomXmlPullParser;

public class MainActivity extends BasicReuseableComponents {
	final MainActivity main = this;
	boolean hideButtons = false;
	DBService dbService = DBService.getInstance();

	Context context = this;
	private ProgressBar progBar;
	private TextView loadingText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setupViews();
		createDB(context);
		splashScreenToMainActivity();
	}

	@Override
	protected void onResume() {
		hideLoadingViews();
		super.onResume();
	}

	private void setupViews() {
		progBar = (ProgressBar) findViewById(R.id.progressBar1);
		loadingText = (TextView) findViewById(R.id.loadingSign);
	}

	private void splashScreenToMainActivity() {
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					boolean isOnline = isNetworkAvailable();
					if (isOnline) {
						parseRssFeedAndStoreToDB();
					} else {
						sleep(IGConstants.SLEEP_TIMER);
					}
				} catch (Exception e) {
				} finally {
					hideButtons = true;
					moveToMainPage(main);
				}
			}
		};
		splashTread.start();

	}

	protected void hideLoadingViews() {
		if (hideButtons) {
			progBar.setVisibility(View.GONE);
			loadingText.setVisibility(View.GONE);
		}

	}

	protected void parseRssFeedAndStoreToDB() {
		try {
			CustomXmlPullParser customXmlPullParser = CustomXmlPullParser
					.getInstance();
			customXmlPullParser.getAllXML(IGConstants.FEEDS_URL);
			customXmlPullParser.createDatabaseEntry(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void createDB(Context context2) {
		SQLiteDatabase db = dbService.getWritableDBObject(context2);
		db.close();
	}

	public void logoImageClicked(View view) {
		moveToMainPage(main);
	}

}