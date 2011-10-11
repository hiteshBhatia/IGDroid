package com.intelligrape.apps.igdroid.constants;

import android.provider.BaseColumns;

public interface DBConstants extends BaseColumns {
	static final String TABLE_NAME = "blogs";
	static final String TITLE = "title";
	static final String URL = "url";
	
	static final String DICTIONARY_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME
			+ " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TITLE
			+ " TEXT, " + URL + " TEXT);";

	static final String sqlQuery = "SELECT " + TITLE + "," + URL + " FROM "
			+ TABLE_NAME + ";)";
	
	static final String DROP_TABLE_BLOGS = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
