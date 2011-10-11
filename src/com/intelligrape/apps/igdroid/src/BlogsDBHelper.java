package com.intelligrape.apps.igdroid.src;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.intelligrape.apps.igdroid.constants.DBConstants;
import com.intelligrape.apps.igdroid.constants.IGConstants;
import com.intelligrape.apps.igdroid.service.DBService;

public class BlogsDBHelper extends SQLiteOpenHelper {
	static final String DATABASE_NAME = "igdroid.db";
	private static final int DATABASE_VERSION = 1;
	

	private void populateWithDefaultEntries(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		putDefaultValues(cv,db);
	}

	private void putDefaultValues(ContentValues cv,SQLiteDatabase db) {
		DBService dbService = DBService.getInstance();
		for (String key : IGConstants.BLOGS_MAP.keySet()){
			dbService.createDBRecordForTableBlogs(cv, db, key,IGConstants.BLOGS_MAP.get(key));			
		}		
	}

	

	public BlogsDBHelper(Context context) {		
		super(context, DATABASE_NAME, null, DATABASE_VERSION);		
	}

	public BlogsDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DBConstants.DROP_TABLE_BLOGS);
		onCreate(db);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DBConstants.DICTIONARY_TABLE_CREATE);
		populateWithDefaultEntries(db);
		
	}

}
