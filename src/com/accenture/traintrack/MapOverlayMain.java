package com.accenture.traintrack;

/*Developed by GPIT Ltd. // Coded by Tanjin Ahsan*/

//import com.gpit.bd.railway.R;
import com.accenture.traintrack.MapOverlayMain.ImageAdapter;

//import com.markupartist.android.actionbar.example.HomeActivity;
//import com.markupartist.android.actionbar.example.OtherActivity;
//import com.markupartist.android.actionbar.example.R;
import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
//import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
//import android.view.View;
import android.view.Window;
import android.view.WindowManager;
//import android.widget.Toast;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MapOverlayMain extends Activity implements OnClickListener,
		SensorEventListener {

	static Context context;
	private static final int ALERT_DIALOG1 = 1;

	private SensorManager sensorManager;
	// private boolean color = false;
	private View view;
	private long lastUpdate;

	// ---the images to display---
	Integer[] imageIDs = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
			R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7 };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		lastUpdate = System.currentTimeMillis();

		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
		// You can also assign the title programmatically by passing a
		// CharSequence or resource id.
		// actionBar.setTitle(R.string.some_title);
		actionBar.setTitle("GP Train Tracker");
		
		final Action otherAction = new IntentAction(this, search.createIntent(this), R.drawable.ic_action_search);
		actionBar.addAction(otherAction);
		actionBar.clearHomeAction();
		
		// Get application context for later use
		context = getApplicationContext();

		// Add ClickListener for the button
	/*	View firstButton = findViewById(R.id.mapshow_button);
		firstButton.setOnClickListener(this);
*/
		// Add ClickListener for the button
		/*View secondButton = findViewById(R.id.imageButton3);
		secondButton.setOnClickListener(this);
*/
		

	}

	@Override
	public void onClick(View v) {
		double lat = 23.700;
		double lon = 90.383;

		// 23.7000° N, 90.3833° E
		switch (v.getId()) {
		/*case R.id.mapshow_button:
			Intent i = new Intent(this, routes.class);
			// DhkChittagong.putLatLong(lat, lon);
			startActivity(i);
			break;*/
		/*case R.id.imageButton3:
			// <activity android:name=".ui.stopmap.StopMapActivity"
			// android:label="Map" />
			Intent ia = new Intent(this, NearFinderActivity.class);
			// DhkChittagong.putLatLong(lat, lon);
			startActivity(ia);
			break;
		*/
		case R.id.mapshow_button_mymen:
			Intent i1 = new Intent(this, DhkMymn.class);
			DhkMymn.putLatLong(lat, lon);
			startActivity(i1);
			break;
		case R.id.mapshow_button_dinaj:
			Intent i2 = new Intent(this, DhkDnjpr.class);
			DhkDnjpr.putLatLong(lat, lon);
			startActivity(i2);
			break;

		case R.id.mapshow_button_khulna:
			Intent i3 = new Intent(this, DhkKhulna.class);
			DhkKhulna.putLatLong(lat, lon);
			startActivity(i3);
			break;
		case R.id.mapshow_button_sylhet:
			Intent i4 = new Intent(this, DhkSylhet.class);
			DhkSylhet.putLatLong(lat, lon);
			startActivity(i4);
			break;
		}
	}

	public void onClick2(View view) {
		Intent ib = new Intent(this, search.class);
		// DhkChittagong.putLatLong(lat, lon);
		startActivity(ib);

	}
	
	public void onClick3(View view) {
		PackageManager pm = getPackageManager();
		Intent intent = pm
				.getLaunchIntentForPackage("com.google.android.apps.maps");
		startActivity(intent);

	}

	// public void onClick3(View view) {
	//
	// startActivity(new Intent("com.gpit.mapsbd.SearchNear"));
	//
	// }

	/*public void onClick4(View view) {

		// PackageManager pm = getPackageManager();
		// Intent intent = pm
		// .getLaunchIntentForPackage("com.google.android.maps.mytracks");
		// startActivity(intent);

		Intent i5 = new Intent(this, MainActivity.class);
		// DhkSylhet.putLatLong(lat, lon);
		startActivity(i5);

	}
*/
	public void onClick6(View view) {

		String url = "http://www.grameenphone.com/";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);

	}

	public class ImageAdapter extends BaseAdapter {
		Context context;
		int itemBackground;

		public ImageAdapter(Context c) {
			context = c;
			// ---setting the style---
			TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
			itemBackground = a.getResourceId(
					R.styleable.Gallery1_android_galleryItemBackground, 0);
			a.recycle();
		}

		// ---returns the number of images---
		public int getCount() {
			return imageIDs.length;
		}

		// ---returns the item---
		public Object getItem(int position) {
			return position;
		}

		// ---returns the ID of an item---
		public long getItemId(int position) {
			return position;
		}

		// ---returns an ImageView view---
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(context);
				imageView.setImageResource(imageIDs[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
			} else {
				imageView = (ImageView) convertView;
			}
			imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

		// Nothing to do here

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			getAccelerometer(event);
		}

	}

	private void getAccelerometer(SensorEvent event) {
		float[] values = event.values;
		// Movement
		float x = values[0];
		float y = values[1];
		float z = values[2];

		float accelationSquareRoot = (x * x + y * y + z * z)
				/ (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
		long actualTime = System.currentTimeMillis();
		if (accelationSquareRoot >= 2) //
		{
			if (actualTime - lastUpdate < 200) {
				return;
			}
			lastUpdate = actualTime;
			showDialog(ALERT_DIALOG1);
			// Toast.makeText(this,
			// "Developed by GPIT - UI Design and Android Software Engineering: Tanjin Ahsan",
			// Toast.LENGTH_LONG)
			// .show();

		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
		AlertDialog.Builder builder;
		switch (id) {
		case ALERT_DIALOG1:
			builder = new AlertDialog.Builder(this);
			builder.setMessage(
					"Developed by ACCENTURE for Grameenphone Ltd.")
					// .setMessage("Grameenphone IT Ltd. is the leading fastest growing IT Company registered with the Registrar of the Joint Stock Companies and Firms of Bangladesh under the Companies Act 1994. It is a 100% subsidiary company of Grameenphone Ltd. which is the largest mobile operator company in Bangladesh with more than 30 million subscribers. <br> <br> Developed by GPIT - UI Design and Android Software Engineering: Tanjin Ahsan")
					// .setTitle("About GPIT Railway Application")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// Do something here
								}
							});
			dialog = builder.create();
			break;

		default:
			dialog = null;
		}
		return dialog;

	}
	
	 public static Intent createIntent(Context context) {
	        Intent i = new Intent(context, MapOverlayMain.class);
	        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        return i;
	    }


	@Override
	protected void onResume() {
		super.onResume();
		// register this class as a listener for the orientation and
		// accelerometer sensors
		sensorManager.registerListener(this,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		// unregister listener
		super.onPause();
		sensorManager.unregisterListener(this);
	}

}