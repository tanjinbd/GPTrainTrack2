package com.accenture.traintrack;

/*Developed by GPIT Ltd. // Coded by Tanjin Ahsan*/

import java.util.ArrayList;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {
	
	private ArrayList<OverlayItem> myOverlays ;

	public MyItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		myOverlays = new ArrayList<OverlayItem>();
		populate();
	}
	
	public void addOverlay(OverlayItem overlay){
		myOverlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return myOverlays.get(i);
	}
	
	// Removes overlay item i
	public void removeItem(int i){
		if(i >= 0) myOverlays.remove(i);
		populate();
	}
	
	// Handle tap events on overlay icons
	@Override
	protected boolean onTap(int i){
		
		
		GeoPoint  gpoint = myOverlays.get(i).getPoint();
		double lat = gpoint.getLatitudeE6()/1e6;
		double lon = gpoint.getLongitudeE6()/1e6;
		String toast = myOverlays.get(i).getTitle();
		toast += "\n"+myOverlays.get(i).getSnippet();
	//	toast += 	"\nSymbol coordinates: Lat = "+lat+" Lon = "+lon+" (microdegrees)";
		Toast.makeText(routes.context, toast, Toast.LENGTH_LONG).show();
		return(true);
	}

	// Returns present number of items in list
	@Override
	public int size() {
		return myOverlays.size();
	}
}
