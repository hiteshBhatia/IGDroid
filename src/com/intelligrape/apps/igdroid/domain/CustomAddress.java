package com.intelligrape.apps.igdroid.domain;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;

public class CustomAddress implements LocationListener {
	double latitude;
	double longitude;
	Boolean gpsDisabled = false;

	public CustomAddress(LocationManager locationManager) {		
		Location location = locationManager.getLastKnownLocation(getProvider(locationManager));
		if(location !=  null){
		this.latitude = location.getLatitude();
		this.longitude = location.getLongitude();
		}
	}

	private String getProvider(LocationManager locationManager) {
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, true);	
		return provider;
	}

	public GeoPoint getGeoPoint(){
		GeoPoint geoPoint =  new GeoPoint((int)(this.latitude * 1e6), (int) (this.longitude * 1e6));
		return geoPoint;
		
	}
	
	public CustomAddress() {}

	@Override
	public void onLocationChanged(Location location) {
		this.latitude = location.getLatitude();
		this.longitude = location.getLatitude();
	}
	
	

	@Override
	public void onProviderDisabled(String arg0) {}

	@Override
	public void onProviderEnabled(String arg0) {}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {}

}
