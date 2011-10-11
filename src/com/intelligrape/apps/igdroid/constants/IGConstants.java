package com.intelligrape.apps.igdroid.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IGConstants {
	public static final String APPS_EMAIL_ADD = "intelligrape.android@gmail.com";
  	public static final String APPS_PWD = "Intelli012345" ;
  	public static final int ANIM_DURATION = 2000 ;
  	public static final int ANIM_DURATION_SW = 1000 ;
  	public static final String RECIPIENT = "dmittal@intelligrape.com";
	public static final String POS_BUTTON_TITLE = "Okay";
	public static final String NEG_BUTTON_TITLE= "Cancel";
	public static final int INTELLIGRAPE_LONGITUDE_1e6 = 77404969;
	public static final int INTELLIGRAPE_LATITUDE_Ie6 = 28543432;
	public static final double INTELLIGRAPE_LONGITUDE = 77.404969;
	public static final double INTELLIGRAPE_LATITUDE= 28.543432;
	public static final String FEEDS_URL = "http://www.intelligrape.com/blog/feed/";
	public static final Object TITLE = "title";
	public static final Object ITEM = "item";
	public static final Object LINK = "link";
	public static final long SLEEP_TIMER = 1000;
	public static Map<String, String> BLOGS_MAP = createMap();
    
	private static Map<String,String> createMap() {
    	Map<String,String> blogsMap = new HashMap<String,String>();
    	blogsMap.put("Grails : load proxy domain objects","http://www.intelligrape.com/blog/2010/07/26/grails-load-proxy-domain-objects/" );
    	blogsMap.put("Playing with call() using Groovy Metaprogramming","http://www.intelligrape.com/blog/2011/09/15/playing-with-call-using-groovy-metaprogramming/" );
    	blogsMap.put("Groovy Maps: Reverse Sort","http://www.intelligrape.com/blog/2009/04/15/groovy-maps-reverse-sort/" );
    	blogsMap.put("Why use Grails?","http://www.intelligrape.com/blog/2011/01/16/why-use-grails/" );
        return Collections.unmodifiableMap(blogsMap);
    }

	
}
