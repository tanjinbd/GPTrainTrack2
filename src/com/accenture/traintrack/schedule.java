package com.accenture.traintrack;

/*Developed by GPIT Ltd. // Coded by Tanjin Ahsan*/


import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class schedule extends Activity {
	static Context context;

	// implements OnClickListener
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule);

		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);

		actionBar.setTitle("GP - Train Schedule");

		final Action shareAction = new IntentAction(this, MapOverlayMain.createIntent(this), R.drawable.home);
		actionBar.addAction(shareAction);
		final Action otherAction = new IntentAction(this, search.createIntent(this), R.drawable.ic_action_search);
		actionBar.addAction(otherAction);

		// Get application context for later use
		context = getApplicationContext();

		// // Add ClickListener for the button
		// View firstButton = findViewById(R.id.mapshow_button);
		// firstButton.setOnClickListener(this);
		//
		// View secondButton = findViewById(R.id.mapshow_button_dinaj);
		// secondButton.setOnClickListener(this);
		//
		// View thirdButton = findViewById(R.id.mapshow_button_mymen);
		// thirdButton.setOnClickListener(this);
		//
		// View forthButton = findViewById(R.id.mapshow_button_khulna);
		// forthButton.setOnClickListener(this);
		//
		// View fifthButton = findViewById(R.id.mapshow_button_sylhet);
		// fifthButton.setOnClickListener(this);
	}

	// @Override
	// public void onClick(View v) {
	// double lat = 23.700;
	// double lon = 90.383;
	//
	// // 23.7000° N, 90.3833° E
	// switch (v.getId()) {
	// case R.id.mapshow_button:
	// Intent i = new Intent(this, DhkChittagong.class);
	// DhkChittagong.putLatLong(lat, lon);
	// startActivity(i);
	// break;
	// case R.id.mapshow_button_mymen:
	// Intent i1 = new Intent(this, DhkMymn.class);
	// DhkMymn.putLatLong(lat, lon);
	// startActivity(i1);
	// break;
	// case R.id.mapshow_button_dinaj:
	// Intent i2 = new Intent(this, DhkDnjpr.class);
	// DhkDnjpr.putLatLong(lat, lon);
	// startActivity(i2);
	// break;
	//
	// case R.id.mapshow_button_khulna:
	// Intent i3 = new Intent(this, DhkKhulna.class);
	// DhkKhulna.putLatLong(lat, lon);
	// startActivity(i3);
	// break;
	// case R.id.mapshow_button_sylhet:
	// Intent i4 = new Intent(this, DhkSylhet.class);
	// DhkSylhet.putLatLong(lat, lon);
	// startActivity(i4);
	// break;
	// }
	// }

	// public void onClick2(View view) {
	// startActivity(new Intent("com.gpit.masbd.showthemap1"));
	// }
	//
	// Create a static method to show toasts (not presently used but included
	// as an example)

	

}