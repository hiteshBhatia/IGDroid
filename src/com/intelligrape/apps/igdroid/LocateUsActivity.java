package com.intelligrape.apps.igdroid;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.intelligrape.apps.igdroid.constants.IGConstants;
import com.intelligrape.apps.igdroid.domain.CustomAddress;
import com.intelligrape.apps.igdroid.src.CustomOverlay;

public class LocateUsActivity extends MapActivity {

	protected static final int ZOOMLEVEL = 16;
	private MapView mapView;
	private CustomAddress locationListener;
	private LocationManager locationManager;
	List<Overlay> mapOverlays;
	Drawable drawable;
	CustomOverlay itemizedOverlay;
	private CustomOverlay custonItemizedOverlay;
	private GeoPoint point;
	private GeoPoint youGeoPoint;
	private CustomAddress youLocation;
	private Button youButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_info_mapview);
		setupLocationManager();
		setupView();
		// setupViews();
	}

	void setupView() {
		youButton = (Button) findViewById(R.id.youButton);
		mapView = setupMap(R.id.map);
		addOverlayToMap();
		addIntelligrapeToMap();
		addYouToMap();
		moveControllerToPoint(point);
	}

	private void addYouToMap() {
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			youLocation = new CustomAddress(locationManager);
			youGeoPoint = youLocation.getGeoPoint();
			addGeoPointToMapOverlays(youGeoPoint);
		} else {
			buildAlertMessageNoGps();
		}

	}

	private void addGeoPointToMapOverlays(GeoPoint gp) {
		OverlayItem overlayitem = new OverlayItem(gp, "", "");
		custonItemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(custonItemizedOverlay);
	}

	private void addIntelligrapeToMap() {
		point = new GeoPoint(IGConstants.INTELLIGRAPE_LATITUDE_Ie6,
				IGConstants.INTELLIGRAPE_LONGITUDE_1e6);
		addGeoPointToMapOverlays(point);
	}

	private MapView setupMap(int id) {
		MapView mapView = (MapView) findViewById(id);
		mapView.setBuiltInZoomControls(true);
		return mapView;
	}

	private void addOverlayToMap() {
		mapOverlays = mapView.getOverlays();
		drawable = this.getResources().getDrawable(R.drawable.ic_pushpin);
		custonItemizedOverlay = new CustomOverlay(drawable);

	}

	private void moveControllerToPoint(GeoPoint geoPoint) {
		final MapController mapController = mapView.getController();
		mapController.animateTo(geoPoint, new Runnable() {
			@Override
			public void run() {
				mapController.setZoom(ZOOMLEVEL);
			}
		});
	}

	public void backButtonClicked(View v) {
		finish();
	}

	public void intelligrapeButtonClicked(View v) {
		moveControllerToPoint(point);
	}

	public void youButtonClicked(View v) {
		moveControllerToPoint(youGeoPoint);
	}

	private void buildAlertMessageNoGps() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Your GPS seems to be disabled").setNegativeButton(
				"Okay", new DialogInterface.OnClickListener() {
					public void onClick(final DialogInterface dialog, int id) {
						youButton.setEnabled(false);
						dialog.cancel();
					}
				});
		final AlertDialog alert = builder.create();
		alert.show();
	}

	private void setupLocationManager() {
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationListener = new CustomAddress();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				60, 5, locationListener);
	}

	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(locationListener);
	}

	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				60000, 5, locationListener);

		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			if(youLocation == null){
				addYouToMap();
			}
			youButton.setEnabled(true);
		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	protected boolean isLocationDisplayed() {
		return true;
	}

}
