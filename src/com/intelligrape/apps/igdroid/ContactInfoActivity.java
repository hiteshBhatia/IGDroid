package com.intelligrape.apps.igdroid;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
// Todo :  Can be deleted
public class ContactInfoActivity extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.contact_info);

	    Resources res = getResources(); 
	    TabHost tabHost = getTabHost(); 
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent; 
	    
	    intent = new Intent().setClass(this, ContactDetailActivity.class);	    
	    spec = tabHost.newTabSpec("contactInfo").setIndicator("Info", res.getDrawable(R.drawable.icon)).setContent(intent);
	    tabHost.addTab(spec);
	    
	    intent = new Intent().setClass(this, ContactMailActivity.class);
	    spec = tabHost.newTabSpec("query").setIndicator("Query",res.getDrawable(R.drawable.icon)).setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
	}

}
