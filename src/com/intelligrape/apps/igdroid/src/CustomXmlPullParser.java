package com.intelligrape.apps.igdroid.src;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.intelligrape.apps.igdroid.constants.DBConstants;
import com.intelligrape.apps.igdroid.constants.IGConstants;
import com.intelligrape.apps.igdroid.service.DBService;

public class CustomXmlPullParser {
	boolean isParsingItem = false;
	boolean isParsingTitle = false;
	boolean isParsingLink = false;
	private static String key;
	private static String value;
	boolean lookingForTitle = false;
	boolean lookingForLink = false;
	static Map<String, String> blogsMap = new HashMap<String, String>();

	 private static CustomXmlPullParser instance;
	
	 private CustomXmlPullParser() {
	 }
	
	 public static synchronized CustomXmlPullParser getInstance() {
	 if (instance == null) {
	 instance = new CustomXmlPullParser();
	 }
	 return instance;
	 }

	public void getAllXML(String url) throws XmlPullParserException,
			IOException, URISyntaxException {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		xpp.setInput(new InputStreamReader(getUrlData(url)));
		int eventType = xpp.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_TAG) {
				shouldStartLooking(xpp.getName());
			} else if (eventType == XmlPullParser.END_TAG) {
				shouldStopLooking(xpp.getName());
			} else if (eventType == XmlPullParser.TEXT) {
				parseRequiredText(xpp.getText());
			}
			eventType = xpp.next();
		}		
	}

	public void createDatabaseEntry(Context context) {
		DBService dbService = DBService.getInstance();
		SQLiteDatabase db = dbService.getWritableDBObject(context);		
		dropOldAndCreateNewTable(db);		
		ContentValues cv = new ContentValues();		
		for (String str : blogsMap.keySet()) {
			dbService.createDBRecordForTableBlogs(cv, db, str, blogsMap.get(str));	
		}
		db.close();
	}

	private void dropOldAndCreateNewTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + DBConstants.TABLE_NAME);
		db.execSQL(DBConstants.DICTIONARY_TABLE_CREATE);
	}

	private void parseRequiredText(String text) {
		if (isParsingItem) {
			if (isParsingTitle && !isParsingLink) {
				key = text;
			}
			if (!isParsingTitle && isParsingLink) {
				value = text;
			}
		}
	}

	private  void shouldStartLooking(String name) {
		if (name.equals(IGConstants.ITEM)) {
			isParsingItem = true;
		} else if (name.equals(IGConstants.TITLE)) {
			isParsingTitle = true;
		} else if (name.equals(IGConstants.LINK)) {
			isParsingLink = true;
		}
	}

	private  void shouldStopLooking(String name) {
		if (name.equals(IGConstants.ITEM)) {
			addKeyValueToMap();
			clearKeyAndValue();
			isParsingItem = false;
		} else if (name.equals(IGConstants.TITLE)) {
			isParsingTitle = false;
		} else if (name.equals(IGConstants.LINK)) {
			isParsingLink = false;
		}
	}

	private static void clearKeyAndValue() {
		key = null;
		value = null;
	}

	private static void addKeyValueToMap() {
		if (key.length() != 0 && value.length() != 0) {
			blogsMap.put(key, value);
		}
	}

	public static InputStream getUrlData(String url) throws URISyntaxException,
			ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet method = new HttpGet(new URI(url));
		HttpResponse res = client.execute(method);
		return res.getEntity().getContent();
	}

}
