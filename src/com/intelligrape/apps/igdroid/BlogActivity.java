package com.intelligrape.apps.igdroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.intelligrape.apps.igdroid.basicIntents.IntentManager;
import com.intelligrape.apps.igdroid.service.DBService;

public class BlogActivity extends ListActivity {
	Map<String, String> blogsMapFromDB = new HashMap<String, String>();
	ArrayList<String> blogsKeySet = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		readFromDatabase();		
		addToListArrayFromMap();		
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.our_blogs,
				R.id.blogs_textView, blogsKeySet));
	}

	private void addToListArrayFromMap() {
		for (String str : blogsMapFromDB.keySet()) {
			blogsKeySet.add(str);
		}		
	}

	private void readFromDatabase() {
		blogsMapFromDB = DBService.getInstance().readMapFromDatabase(this);
	}

	

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Object object = this.getListAdapter().getItem(position);
		String keyword = object.toString();
		createBrowserForUrl(keyword);

	}

	private void createBrowserForUrl(String keyword) {
		String url = blogsMapFromDB.get(keyword);
		Intent browserIntent = IntentManager.getInstance()
				.createViewIntent(url);
		startActivity(browserIntent);
	}

}
