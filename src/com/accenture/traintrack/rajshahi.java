package com.accenture.traintrack;

/*Developed by GPIT Ltd. // Coded by Tanjin Ahsan*/


import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class rajshahi extends Activity {
	static Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rajshahi);

		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);

		actionBar.setTitle("GP - Choose Destination");

		// actionBar.setHomeAction(new IntentAction(this,
		// MapOverlayMain.createIntent(this), R.drawable.home));
		actionBar.setDisplayHomeAsUpEnabled(true);

		final Action shareAction = new IntentAction(this,
				MapOverlayMain.createIntent(this), R.drawable.home);
		actionBar.addAction(shareAction);
		actionBar.clearHomeAction();
		// final Action otherAction = new IntentAction(this, new Intent(this,
		// routes.class), R.drawable.ic_action_search);
		// actionBar.addAction(otherAction);

		// Get application context for later use
		context = getApplicationContext();

		Spinner spinner1 = (Spinner) findViewById(R.id.rajshahi);
		spinner1.setOnItemSelectedListener(new SpinnerHandler());

	}

	private class SpinnerHandler implements OnItemSelectedListener {
		@Override
		public void onItemSelected(AdapterView<?> spinner, View selectedView,
				int selectedIndex, long id) {
			if (spinner.getItemAtPosition(selectedIndex).toString()
					.equals("Dhaka")) {
				Intent i = new Intent(getApplicationContext(), rajdhk.class);
				startActivity(i);
			} else if (spinner.getItemAtPosition(selectedIndex).toString()
					.equals("Nilphamari")) {
				Intent i = new Intent(getApplicationContext(), rajnp.class);
				startActivity(i);
			} else if (spinner.getItemAtPosition(selectedIndex).toString()
					.equals("Khulna")) {
				Intent i = new Intent(getApplicationContext(), rajkh.class);
				startActivity(i);
			} else if (spinner.getItemAtPosition(selectedIndex).toString()
					.equals("Chilahati")) {
				Intent i = new Intent(getApplicationContext(), rajch.class);
				startActivity(i);
			}
			// Toast for test
			// Toast.makeText(spinner.getContext(),
			// spinner.getItemAtPosition(selectedIndex).toString() +
			// " selected ", Toast.LENGTH_LONG).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> spinner) {
			// Tanjin Ahsan: For future magic, may be a counter or demo
		}
	}

	public static Intent createIntent(Context context) {
		Intent i = new Intent(context, search.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		return i;
	}

	// public void onClick2(View view) {
	// startActivity(new Intent("com.gpit.masbd.showthemap1"));
	// }
	//
	// Create a static method to show toasts (not presently used but included
	// as an example)

	public static void showToast(String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}

}