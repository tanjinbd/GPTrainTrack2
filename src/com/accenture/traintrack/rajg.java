package com.accenture.traintrack;

/*Developed by GPIT Ltd. // Coded by Tanjin Ahsan*/


import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;

import android.app.Activity;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class rajg extends Activity {
	static Context context;
	private Dialog dialog;

	// implements OnClickListener
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rajg);

		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);

		actionBar.setTitle("GP - Train Schedule");

		final Action shareAction = new IntentAction(this, MapOverlayMain.createIntent(this), R.drawable.home);
		actionBar.addAction(shareAction);
		final Action otherAction = new IntentAction(this, search.createIntent(this), R.drawable.ic_action_search);
		actionBar.addAction(otherAction);

		// Get application context for later use
		context = getApplicationContext();

	}
	
	private void displayNewDialog(Builder builder) {
		dismissDialog();
		dialog = builder.create();
		dialog.show();
	}

	private void dismissDialog() {
		if (dialog != null) {
			dialog.dismiss();
		}
	}
	
	public void onClick2(View view) {
		
		
		Builder builder = new Builder(this);
		builder.setTitle("Realtime Location");
		String alert1 = "Train No: 756";
		String alert2 = "Train Name: Madhumati Express";
		String alert3 = "Left Rajshahi at 07:10";
		String alert4 = "Next Station: Goalanda Ghat";
		String alert5 = "Next Stop: Goalanda Ghat at 22nd stn";
		String alert6 = "Delay: 00:12";
		builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
		
		builder.setIcon(android.R.drawable.ic_dialog_alert);

		builder.setPositiveButton("OK", null);

		displayNewDialog(builder);

	}

	
}