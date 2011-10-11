package com.intelligrape.apps.igdroid.service;

import java.util.HashMap;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.intelligrape.apps.igdroid.constants.DBConstants;
import com.intelligrape.apps.igdroid.src.BlogsDBHelper;

public class DBService {
	private static DBService instance;

	private DBService() {
	}

	public static synchronized DBService getInstance() {
		if (instance == null) {
			instance = new DBService();
		}
		return instance;
	}
	
	public SQLiteDatabase getWritableDBObject(Context context2) {
		BlogsDBHelper dbHelper = new BlogsDBHelper(context2);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		return db;
	}
	
	public void createDBRecordForTableBlogs(ContentValues cv, SQLiteDatabase db, String key,String value) {
		cv.put(DBConstants.TITLE, key);
		cv.put(DBConstants.URL,value);
		db.insert(DBConstants.TABLE_NAME, DBConstants._ID, cv);
	}
	
	public Map<String, String> readMapFromDatabase(Context context) {
		Map<String, String> map = new HashMap<String, String>();
		SQLiteDatabase db = getWritableDBObject(context);
		String sqlQuery = DBConstants.sqlQuery;
		Cursor result = db.rawQuery(sqlQuery, null);
		result.moveToFirst();
		while (!result.isAfterLast()) {
			String title = result.getString(0);
			String author = result.getString(1);
			map.put(title, author);
			result.moveToNext();
		}
		result.close();
		db.close();
		return map;
	}

}
