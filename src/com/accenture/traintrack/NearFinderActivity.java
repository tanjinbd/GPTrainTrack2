/*Developed by GPIT Ltd. // Coded by Tanjin Ahsan*/

package com.accenture.traintrack;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NearFinderActivity extends MapActivity implements LocationListener {
	/** Called when the activity is first created. */

	private MapController mapController;
	private MapView mapView;
	private LocationManager locationManager;
	private GeoPoint currentPoint;
	private Location currentLocation = null;
	private NearOverlay currPos;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nearmain);
		mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(false);
		mapView.setStreetView(true);
		mapController = mapView.getController();
		mapController.setZoom(13);
		getLastLocation();
		drawCurrPositionOverlay();
		drawStations();
		animateToCurrentLocation();

		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);

		actionBar.setTitle("GP - Near Station");

		final Action shareAction = new IntentAction(this,
				MapOverlayMain.createIntent(this), R.drawable.home);
		actionBar.addAction(shareAction);
		final Action otherAction = new IntentAction(this,
				search.createIntent(this), R.drawable.ic_action_search);
		actionBar.addAction(otherAction);

		Toast.makeText(
				this,
				"Click on a station to know the distance from your current location",
				Toast.LENGTH_LONG).show();
	}

	public void getLastLocation() {
		String provider = getBestProvider();
		currentLocation = locationManager.getLastKnownLocation(provider);

		if (currentLocation != null) {
			setCurrentLocation(currentLocation);
		} else {
			Toast.makeText(this, "Location not yet acquired", Toast.LENGTH_LONG)
					.show();
		}
		((TextView) findViewById(R.id.providerText)).setText("Provider :"
				+ getBestProvider());

	}

	public void animateToCurrentLocation() {
		if (currentPoint != null) {
			mapController.animateTo(currentPoint);
		}
	}

	public void centerToCurrentLocation(View view) {
		animateToCurrentLocation();
	}

	public String getBestProvider() {
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);
		criteria.setAccuracy(Criteria.NO_REQUIREMENT);
		String bestProvider = locationManager.getBestProvider(criteria, true);
		return bestProvider;
	}

	public void setCurrentLocation(Location location) {

		int currLatitude = (int) (location.getLatitude() * 1E6);
		int currLongitude = (int) (location.getLongitude() * 1E6);
		currentPoint = new GeoPoint(currLatitude, currLongitude);

		currentLocation = new Location("");
		currentLocation.setLatitude(currentPoint.getLatitudeE6() / 1e6);
		currentLocation.setLongitude(currentPoint.getLongitudeE6() / 1e6);

		((TextView) findViewById(R.id.latitudeText)).setText("Latitude : "
				+ String.valueOf((int) (currentLocation.getLatitude() * 1E6)));
		((TextView) findViewById(R.id.longitudeText)).setText("Longitude : "
				+ String.valueOf((int) (currentLocation.getLongitude() * 1E6)));
		((TextView) findViewById(R.id.accuracyText)).setText("Accuracy : "
				+ String.valueOf(location.getAccuracy()) + " m");
		drawCurrPositionOverlay();

	}

	public void drawCurrPositionOverlay() {
		List<Overlay> overlays = mapView.getOverlays();
		overlays.remove(currPos);
		Drawable marker = getResources().getDrawable(R.drawable.mall2);
		currPos = new NearOverlay(marker, mapView);
		if (currentPoint != null) {
			OverlayItem overlayitem = new OverlayItem(currentPoint, "Me",
					"Your Current Location");
			currPos.addOverlay(overlayitem);
			overlays.add(currPos);
			currPos.setCurrentLocation(currentLocation);
		}
	}

	public void drawStations() {
		Drawable marker = getResources().getDrawable(R.drawable.malls);
		NearOverlay mallsPos = new NearOverlay(marker, mapView);
		GeoPoint[] mallCoords = new GeoPoint[41];

		// Load Some POI Coordinates for Bangladesh Railway
		mallCoords[0] = new GeoPoint(23732147, 90426062);// Kamlapur Station
		mallCoords[1] = new GeoPoint(23701740, 90428804);// Gandaria Station
		mallCoords[2] = new GeoPoint(23815957, 90410453);// Cantonment Station
		mallCoords[3] = new GeoPoint(23852072, 90408222);// Airport Station
		mallCoords[4] = new GeoPoint(23650481, 90474314);// Fatulla Station

		mallCoords[5] = new GeoPoint(23796011, 90400497);// Banani Station
		mallCoords[6] = new GeoPoint(23898379, 90408050);// Tongi Junction
		mallCoords[7] = new GeoPoint(23936676, 90478064);// Pubail Station
		mallCoords[8] = new GeoPoint(23929014, 90553588);// Arikhola Station
		mallCoords[9] = new GeoPoint(23940938, 90619678);// Ghorashal Station

		mallCoords[10] = new GeoPoint(23930426, 90673579);// Jinardi Station
		mallCoords[11] = new GeoPoint(23931548, 90721091);// Narsingdi Junction
		mallCoords[12] = new GeoPoint(23970249, 90824493);// Hatubhanga Station
		mallCoords[13] = new GeoPoint(23992364, 90865864);// Methikanda Station
		mallCoords[14] = new GeoPoint(24006113, 90902304);// Srinidi Station

		mallCoords[15] = new GeoPoint(24024459, 90950369);// Daulatkandi Station
		mallCoords[16] = new GeoPoint(24050137, 90977967);// Bhairab Junction
		mallCoords[17] = new GeoPoint(24038438, 91001372);// Ashuganj Station
		mallCoords[18] = new GeoPoint(24010742, 91037864);// Talshohor Station
		mallCoords[19] = new GeoPoint(23966655, 91108196);// Brahmanbaria
															// Station

		mallCoords[20] = new GeoPoint(23882494, 91187053);// Coddah Station
		mallCoords[21] = new GeoPoint(23893245, 91220527);// Ajampur Station
		mallCoords[22] = new GeoPoint(24017181, 91310140);// Harashpur Station
		mallCoords[23] = new GeoPoint(24069367, 91344431);// Mantala Station
		mallCoords[24] = new GeoPoint(24100898, 91356985);// Teliapara Station

		mallCoords[25] = new GeoPoint(24180882, 91356537);// Itakhola Station
		mallCoords[26] = new GeoPoint(24253211, 91381943);// Shahjibazar Station
		mallCoords[27] = new GeoPoint(24278250, 91449749);// Shayestaganj
															// Station
		mallCoords[28] = new GeoPoint(24306630, 91734703);// Sreemangal Station
		mallCoords[29] = new GeoPoint(24351935, 91841244);// Bhanugach Station

		mallCoords[30] = new GeoPoint(24425635, 91938902);// Manu Station
		mallCoords[31] = new GeoPoint(24463330, 91987077);// Langla Station
		mallCoords[32] = new GeoPoint(24439577, 91954548);// Tilagaon Station
		mallCoords[33] = new GeoPoint(24522985, 92036179);// Kulaura Station
		mallCoords[34] = new GeoPoint(24559392, 92016446);// Chokhanpon Station

		mallCoords[35] = new GeoPoint(24587346, 91978955);// Bharamchal Station
		mallCoords[36] = new GeoPoint(24631357, 91989512);// Vhatayra Station
		mallCoords[37] = new GeoPoint(24686350, 91951145);// Maijgaon Station
		mallCoords[38] = new GeoPoint(24699529, 91942219);// Fenchuganj Station
		mallCoords[39] = new GeoPoint(24882652, 91868188);// Sylhet New Station

		mallCoords[40] = new GeoPoint(24882496, 91866042);// Sylhet old Station
		List<Overlay> overlays = mapView.getOverlays();
		OverlayItem overlayItem = new OverlayItem(mallCoords[0],
				"Kamlapur Station",
				"Kamlapur, Dhaka - Phone: 9358634, 8315857, 9331822; Mob: 01711691612");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[1], "Gandaria Station",
				"Pipe Road, Dhaka 1204, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[2], "Cantonment Station",
				"Tongi Diversion Road, Dhaka, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[3], "Cantonment Station",
				"Airport Railway Station; Dhaka-Mymensingh Hwy, Dhaka 1230, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[4], "Fatulla Station",
				"Fatulla Railway Station - Fatulla, Bangladesh");
		mallsPos.addOverlay(overlayItem);

		// /////

		overlayItem = new OverlayItem(mallCoords[5], "Banani Station",
				"Banani Road, Dhaka, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[6], "Tongi Station",
				"Tongi Diversion Road, Dhaka, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[7], "Pubail Station",
				"Pubail Railway Station; Dhaka-Mymensingh Hwy, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[8], "Arikhula Station",
				"Arikhula Railway Station - Arikhula, Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[9], "Ghorashal Station",
				"Ghorashal, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[10], "Jinardi Station",
				"Jinardi Road, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[11], "Narsingdi Station",
				"Narsingdi Railway Station; Dhaka-Mymensingh Hwy, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[12], "Hatubhanga Station",
				"Hatubhanga Railway Station - Hatubhanga, Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[13], "Methikanda Station",
				"Methikanda, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[14], "Srinidi Station",
				"Srinidi, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[15], "Daulatkandi Station",
				"Daulatkandi Railway Station, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[16], "Bhairab Station",
				"Bhairab Railway Station - Bhairab, Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[17], "Ashuganj Station",
				"Ashuganj, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[18], "Talshohor Station",
				"Talshohor, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[19], "Brahmanbaria Station",
				"Brahmanbaria Railway Station, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[20], "Coddah Station",
				"Coddah Railway Station - Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[21], "Ajampur Station",
				"Ashuganj, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[22], "Harashpur Station",
				"Harashpur, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[23], "Mantala Station",
				"Mantala Railway Station, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[24], "Teliapara Station",
				"Teliapara Railway Station - Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[25], "Itakhola Station",
				"Itakhola, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[26], "Shahjibazar Station",
				"Shahjibazar, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[27], "Shayestaganj Station",
				"Shayestaganj Railway Station, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[28], "Sreemangal Station",
				"Sreemangal Railway Station - Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[29], "Bhanugach Station",
				"Bhanugach, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[30], "Manu Station",
				"Manu, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[31], "Langla Station",
				"Langla Railway Station, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[32], "Tilagaon Station",
				"Tilagaon Railway Station - Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[33], "Kulaura Station",
				"Kulaura, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[34], "Chokhanpon Station",
				"Chokhanpon, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[35], "Bharamchal Station",
				"Bharamchal Railway Station, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[36], "Vhatayra Station",
				"Vhatayra Railway Station - Bangladesh");
		mallsPos.addOverlay(overlayItem);

		overlayItem = new OverlayItem(mallCoords[37], "Maijgaon  Station",
				"Maijgaon, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[38], "Fenchuganj Station",
				"Fenchuganj, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[39], "Sylhet New Station",
				"Sylhet New Railway Station, Bangladesh");
		mallsPos.addOverlay(overlayItem);
		overlayItem = new OverlayItem(mallCoords[40], "Sylhet Old Station",
				"Sylhet Old Railway Station - Bangladesh");
		mallsPos.addOverlay(overlayItem);

		// /////

		overlays.add(mallsPos);

		mallsPos.setCurrentLocation(currentLocation);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLocationChanged(Location newLocation) {
		// TODO Auto-generated method stub
		setCurrentLocation(newLocation);
	}

	@Override
	protected void onResume() {
		super.onResume();
		locationManager
				.requestLocationUpdates(getBestProvider(), 1000, 1, this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

		Toast.makeText(this, "Provider Disabled", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Provider Enabled", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Staus Changed", Toast.LENGTH_SHORT).show();

	}
}