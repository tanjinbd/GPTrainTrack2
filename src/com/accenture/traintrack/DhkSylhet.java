package com.accenture.traintrack;

/*Developed by GPIT Ltd. // Coded by Tanjin Ahsan*/

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;



import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DhkSylhet extends MapActivity {
	
	private static double lat;
	private static double lon;
	private int latE6;
	private int lonE6;
	private MapController mapControl;
	private GeoPoint gp;
	private MapView mapView;
	
	private Button overlayButton, accessButton;
	private Button routeButton;
	private List<Overlay> mapOverlays;
	private Drawable drawable1, drawable2;
	private MyItemizedOverlay itemizedOverlay1, itemizedOverlay2;
	private boolean stationIsDisplayed = false;
	private boolean junctionIsDisplayed = false;
	
	// Define an array containing the food overlay items
	
	private OverlayItem [] POIItem = {
			new OverlayItem( new GeoPoint(25030972,91662631), "Chhatak", "Chhatak Rail Station"),
			new OverlayItem( new GeoPoint(24882496,91866042), "Sylhet", "Sylhet Old Railway"), 
			new OverlayItem( new GeoPoint(24882652,91868188), "Sylhet", "Sylhet New Railway"),
			new OverlayItem( new GeoPoint(24699529,91942219), "Fenchuganj", "Fenchuganj Railway"),
			
			new OverlayItem( new GeoPoint(24686350,91951145), "Maijgaon", "Maijgaon Rail Station"),
			new OverlayItem( new GeoPoint(24631357,91989512), "Vhatayra", "Vhatayra Railway"), 
			new OverlayItem( new GeoPoint(24587346,91978955), "Bharamchal", "Bharamchal Railway"),
			new OverlayItem( new GeoPoint(24559392,92016446), "Chokhanpon", "Chokhanpon Railway"),
			
			new OverlayItem( new GeoPoint(24463330,91987077), "Langla", "Langla Railway"),
			new OverlayItem( new GeoPoint(24439577,91954548), "Tilagaon", "Tilagaon Railway"), 
			new OverlayItem( new GeoPoint(24425635,91938902), "Manu", "Manu Railway"),
			new OverlayItem( new GeoPoint(24351935,91841244), "Bhanugach", "Bhanugach Railway"),
			
			new OverlayItem( new GeoPoint(24306630,91734703), "Sreemangal", "Sreemangal Railway"),
			new OverlayItem( new GeoPoint(24278250,91449749), "Shayestaganj", "Shayestaganj Railway"), 
			new OverlayItem( new GeoPoint(24253211,91381943), "Shahjibazar", "Shahjibazar Railway"),
			new OverlayItem( new GeoPoint(24180882,91356537), "Itakhola", "Itakhola Railway"),
			
			new OverlayItem( new GeoPoint(24100898,91356985), "Teliapara", "Teliapara Rail Station"),
			new OverlayItem( new GeoPoint(24069367,91344431), "Mantala", "Mantala Railway"), 
			new OverlayItem( new GeoPoint(24017181,91310140), "Harashpur", "Harashpur Railway"),
			new OverlayItem( new GeoPoint(23893245,91220527), "Ajampur", "Ajampur Railway"),
			//
			
			new OverlayItem( new GeoPoint(24100898,91356985), "Teliapara", "Teliapara Rail Station"),
			new OverlayItem( new GeoPoint(24069367,91344431), "Mantala", "Mantala Railway"), 
			new OverlayItem( new GeoPoint(24017181,91310140), "Harashpur", "Harashpur Railway"),
			new OverlayItem( new GeoPoint(23893245,91220527), "Ajampur", "Ajampur Railway"),
			
			new OverlayItem( new GeoPoint(23882494,91187053), "Coddah", "Coddah Rail Station"),
			new OverlayItem( new GeoPoint(23966655,91108196), "Brahmanbaria", "Brahmanbaria Railway"), 
			new OverlayItem( new GeoPoint(24010742,91037864), "Talshohor", "Talshohor Railway"),
			new OverlayItem( new GeoPoint(24038438,91001372), "Ashuganj", "Ashuganj Railway"),
			
			new OverlayItem( new GeoPoint(24050137,90977967), "Bhairab", "Bhairab Railway"),
			new OverlayItem( new GeoPoint(24024459,90950369), "Daulatkandi", "Daulatkandi Railway"), 
			new OverlayItem( new GeoPoint(24006113,90902304), "Srinidi", "Srinidi Railstation"),
			new OverlayItem( new GeoPoint(23992364,90865864), "Methikanda", "Methikanda Railstation"),
			
			new OverlayItem( new GeoPoint(23970249,90824493), "Hatubhanga", "Hatubhanga Railway"),
			new OverlayItem( new GeoPoint(23931548,90721091), "Narsingdi", "Narsingdi Railway"), 
			new OverlayItem( new GeoPoint(23930426,90673579), "Jinardi", "Jinardi Railstation"),
			new OverlayItem( new GeoPoint(23940938,90619678), "Ghorashal", "Ghorashal Railway"),
			
			new OverlayItem( new GeoPoint(23929014,90553588), "Arikhola", "Arikhola Railway"),
			new OverlayItem( new GeoPoint(23936676,90478064), "Pubail", "Pubail Railway"), 
			new OverlayItem( new GeoPoint(23852072,90408222), "Airport", "Airport Railway"),
			new OverlayItem( new GeoPoint(23815957,90410453), "Cantonment", "Cantonment Station"),
			
			new OverlayItem( new GeoPoint(23796011,90400497), "Banani", "Banani Railway"),
			new OverlayItem( new GeoPoint(23732147,90426062), "Kamlapur", "Kamlapur Station")
	};
	
	// Define an array containing the  access overlay items
	
	private OverlayItem [] accessItem = {
			new OverlayItem( new GeoPoint(24522985,92036179), "Kulaura", "Kulaura Junction"),
			new OverlayItem( new GeoPoint(23898379,90408050), "Tongi", "Tongi Junction")
	        
	};
	
	
	String TAG = "GPStest";
	// Set up the array of GeoPoints defining the route
	int numberRoutePoints;	
	GeoPoint routePoints [];   // Dimension will be set in class RouteLoader below
	int routeGrade [];               // Index for slope of route from point i to point i+1
	int numberRoutePoints1;	
	GeoPoint routePoints1 [];   // Dimension will be set in class RouteLoader below
	int routeGrade1 [];  
	RouteSegmentOverlay route;   // This will hold the route segments
	boolean routeIsDisplayed = false;


	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // Suppress title bar for more space
        setContentView(R.layout.dhksylhet);
        
        // Add map controller with zoom controls
        mapView = (MapView) findViewById(R.id.mv5);
        mapView.setSatellite(false);
        mapView.setTraffic(false);
        mapView.setBuiltInZoomControls(true);   // Set android:clickable=true in main.xml
        int maxZoom = mapView.getMaxZoomLevel();
        int initZoom = maxZoom-8;
        mapControl = mapView.getController();
        mapControl.setZoom(initZoom);
        // Convert lat/long in degrees into integers in microdegrees
        latE6 =  (int) (lat*1e6);
        lonE6 = (int) (lon*1e6);
        gp = new GeoPoint(latE6, lonE6);
        mapControl.animateTo(gp);    
        
    	// Button to control food overlay
    	overlayButton = (Button)findViewById(R.id.doOverlay);
    	overlayButton.setOnClickListener(new OnClickListener(){      
    	    public void onClick(View v) {	
    	    	setOverlay1();     
    	    }
    	});
    	
    	// Button to control access overlay
    	accessButton = (Button)findViewById(R.id.doAccess);
    	accessButton.setOnClickListener(new OnClickListener(){      
    	    public void onClick(View v) {	
    	    	setOverlay2();       
    	    }
    	});
    	
    	// Button to control route overlay
    	routeButton = (Button)findViewById(R.id.doRoute);
    	routeButton.setOnClickListener(new OnClickListener(){      
    	    public void onClick(View v) {	
    	    	if(! routeIsDisplayed){
    	    		routeIsDisplayed = true;
    	    		loadRouteData();   				
    	    	} else {
    	    		if(route != null) route.setRouteView(false);
    	    		route = null; // To prevent multiple route instances if key toggled rapidly (see line 235)
    	    		routeIsDisplayed = false;
    	    		mapView.postInvalidate(); 
    	    	}
    	    }
    	}); 
    	
	}
	
	
	
	
	// SetOverlay 1 for Station
	public void setOverlay1() {
		int poiLength = POIItem.length;
		// Create itemizedOverlay2 if it doesn't exist and display all three
		// items
		if (!stationIsDisplayed) {
			mapOverlays = mapView.getOverlays();
			drawable1 = this.getResources().getDrawable(
					R.drawable.knifefork_small);
			itemizedOverlay1 = new MyItemizedOverlay(drawable1);
			// Display all three items at once
			for (int i = 0; i < poiLength; i++) {
				itemizedOverlay1.addOverlay(POIItem[i]);
			}
			mapOverlays.add(itemizedOverlay1);
			stationIsDisplayed = !stationIsDisplayed;
			// Remove all item successively with button clicks
		} else {
			for (int i = 0; i < poiLength; i++) {
				itemizedOverlay1.removeItem(poiLength - 1 - i);
			}
			if ((itemizedOverlay1.size() < 1))
				stationIsDisplayed = false;

			// Remove single station code
			// itemizedOverlay1.removeItem(itemizedOverlay1.size()-1);
			// if((itemizedOverlay1.size() < 1)) stationIsDisplayed = false;
		}
		// Added symbols will be displayed when map is redrawn so force redraw
		// now
		mapView.postInvalidate();
	}

	public void setOverlay2() {
		int accessLength = accessItem.length;
		// Create itemizedOverlay2 if it doesn't exist
		if (itemizedOverlay2 == null) {
			mapOverlays = mapView.getOverlays();
			drawable2 = this.getResources().getDrawable(
					R.drawable.accessibility);
			itemizedOverlay2 = new MyItemizedOverlay(drawable2);
		}
		// //

		if (!junctionIsDisplayed) {
			mapOverlays = mapView.getOverlays();
			drawable2 = this.getResources().getDrawable(
					R.drawable.accessibility);
			itemizedOverlay2 = new MyItemizedOverlay(drawable2);
			// Display all three items at once
			for (int i = 0; i < accessLength; i++) {
				itemizedOverlay2.addOverlay(accessItem[i]);
			}
			mapOverlays.add(itemizedOverlay2);
			junctionIsDisplayed = !junctionIsDisplayed;
			// Remove all item successively with button clicks
		}

		// Add items with each click

		// if (itemizedOverlay2.size() < accessLength) {
		// itemizedOverlay2.addOverlay(accessItem[itemizedOverlay2.size()]);
		// mapOverlays.add(itemizedOverlay2);
		// // Remove all items with one click
		// }
		else {
			for (int i = 0; i < accessLength; i++) {
				itemizedOverlay2.removeItem(accessLength - 1 - i);
			}

			if ((itemizedOverlay2.size() < 1))
				junctionIsDisplayed = false;
		}
		// Added symbols will be displayed when map is redrawn so force redraw
		// now
		mapView.postInvalidate();
	}
	
	
	// Method to insert latitude and longitude in degrees
	public static void putLatLong(double latitude, double longitude){
		lat = latitude;
		lon =longitude;
	}
	
	// This sets the s key on the phone to toggle between satellite and map view
	// and the t key to toggle between traffic and no traffic view (traffic view
	// relevant only in urban areas where it is reported).
	
	public boolean onKeyDown(int keyCode, KeyEvent e){
		if(keyCode == KeyEvent.KEYCODE_S){
			mapView.setSatellite(!mapView.isSatellite());
			return true;
		} else if(keyCode == KeyEvent.KEYCODE_T){
			mapView.setTraffic(!mapView.isTraffic());
			mapControl.animateTo(gp);  // To ensure change displays immediately
		}
		return(super.onKeyDown(keyCode, e));
	}
	
	
	// Required method since class extends MapActivity
	@Override
	protected boolean isRouteDisplayed() {
		return false;  // Don't display a route
	}
	
	
    // Method to read route data from server as XML
    
    public void loadRouteData(){
    	try {
    		String url = "http://demo.starhostbd.com/something.xml";
    		String data = "";
    		
    		new RouteLoader().execute(new URL(url+data));
    	//	new RouteLoader1().execute(new URL(url+data));
    		
        } catch (MalformedURLException e) {
            Log.i("NETWORK", "Failed to generate valid URL");
        }
    }
	
	// Overlay a route.  This method is only executed after loadRouteData() completes
    // on background thread.
    
    public void overlayRoute() {
    	if(route != null) return;  // To prevent multiple route instances if key toggled rapidly (see also line 116)
    	// Set up the overlay controller
    	route = new RouteSegmentOverlay(routePoints, routeGrade); // My class defining route overlay
    	mapOverlays = mapView.getOverlays();
    	mapOverlays.add(route);
    	
    	// Added symbols will be displayed when map is redrawn so force redraw now
        mapView.postInvalidate(); 
    }
    
    
   
	
	private class RouteLoader extends AsyncTask<URL, String, String> {

		 @Override
	        protected String doInBackground(URL... params) {
	            // This pattern takes more than one param but we'll just use the first
	            try {
	                URL text = params[0];

	                XmlPullParserFactory parserCreator;

	                parserCreator = XmlPullParserFactory.newInstance();

	                XmlPullParser parser = parserCreator.newPullParser();

	                //parser.setInput(text.openStream(), null);
	                
	                InputStream in = getAssets().open("2sylhet.xml");
	                
	                parser.setInput(in, null);

	                publishProgress("Parsing XML...");

	                int parserEvent = parser.getEventType();
	                int pointCounter = -1;
	                int wptCounter = -1;
	                int totalWaypoints = -1;
	                double lat = -1;
	                double lon = -1;
	                String wptDescription = "";
	                int grade = -1;
	                
	                // Parse the XML returned on the network
	                while (parserEvent != XmlPullParser.END_DOCUMENT) {
	                    switch (parserEvent) {
	                    case XmlPullParser.START_TAG:
	                        String tag = parser.getName();
	                        if(tag.compareTo("trk")==0){
	                        	numberRoutePoints = 458;
	                        	totalWaypoints = 1;
	                        	routePoints = new GeoPoint[numberRoutePoints]; 
	                        	routeGrade = new int[numberRoutePoints];
	                        	Log.i(TAG, "   Total points = "+numberRoutePoints
	                        			+" Total waypoints = "+totalWaypoints);
	                        }
	                        if(tag.compareTo("trkpt")==0){
	                        	pointCounter ++;
	                        	
	                        	lat = Double.parseDouble(parser.getAttributeValue(null,"lat"));
	                        	lon = Double.parseDouble(parser.getAttributeValue(null,"lon"));
	                        	lon=lon*1000000;
	                        	lat=lat*1000000;
								
	                        	int lat1 = (int) Math.round(lat);
	                        	int lon1 = (int) Math.round(lon);
	                        	//
	                        	grade = Integer.parseInt(parser.getAttributeValue(null,"grade"));
	                        	routePoints[pointCounter] = new GeoPoint(lat1, lon1);
	                        	routeGrade[pointCounter] = grade;
	                        	Log.i(TAG,"   trackpoint="+pointCounter+" latitude="+lat1+" longitude="+lon1
	                        			+" grade="+grade);
	                        }  
	                        break;
	                    }

	                    parserEvent = parser.next();
	                }

	            } catch (Exception e) {
	                Log.i("RouteLoader", "Failed in parsing XML", e);
	                return "Finished with failure.";
	            }

	            return "Done...";
	        }

	        protected void onCancelled() {
	            Log.i("RouteLoader", "GetRoute task Cancelled");
	        }

	        // Now that route data are loaded, execute the method to overlay the route on the map
	        protected void onPostExecute(String result) {
	        	Log.i(TAG, "Route data transfer complete");
	        	overlayRoute();
	        }

	        protected void onPreExecute() {
	            Log.i(TAG,"Ready to load URL");
	        }

	        protected void onProgressUpdate(String... values) {
	            super.onProgressUpdate(values);
	        }

	}
	
	
	

}
