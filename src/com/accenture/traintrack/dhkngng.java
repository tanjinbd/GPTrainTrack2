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

public class dhkngng extends Activity {
	static Context context;
	private Dialog dialog;

	// implements OnClickListener
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dhkngng);

		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);

		actionBar.setTitle("GP - Train Schedule");

		final Action shareAction = new IntentAction(this,
				MapOverlayMain.createIntent(this), R.drawable.home);
		actionBar.addAction(shareAction);
		final Action otherAction = new IntentAction(this,
				search.createIntent(this), R.drawable.ic_action_search);
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
		String alert1 = "Train No: 220";
		String alert2 = "Train Name: Local";
		String alert3 = "Left Dhaka at 07:10";
		String alert4 = "Next Station: Narayanganj";
		String alert5 = "Next Stop: Narayanganj at 3rd stn";
		String alert6 = "Delay: 00:05";
		builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
		
		builder.setIcon(android.R.drawable.ic_dialog_alert);

		builder.setPositiveButton("OK", null);

		displayNewDialog(builder);

	}
	
public void onClick3(View view) {
		
		
		Builder builder = new Builder(this);
		builder.setTitle("Realtime Location");
		String alert1 = "Train No: 222";
		String alert2 = "Train Name: Local";
		String alert3 = "Left Dhaka at 08:10";
		String alert4 = "Next Station: Narayanganj";
		String alert5 = "Next Stop: Narayanganj at 3rd stn";
		String alert6 = "Delay: 00:05";
		builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
		
		builder.setIcon(android.R.drawable.ic_dialog_alert);

		builder.setPositiveButton("OK", null);

		displayNewDialog(builder);

	}

public void onClick4(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 224";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 09:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick5(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 226";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 10:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick6(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 228";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 11:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick7(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 230";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 12:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick8(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 232";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 13:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick9(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 234";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 14:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick10(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 236";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 15:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick11(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 238";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 16:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

public void onClick12(View view) {
	
	
	Builder builder = new Builder(this);
	builder.setTitle("Realtime Location");
	String alert1 = "Train No: 240";
	String alert2 = "Train Name: Local";
	String alert3 = "Left Dhaka at 17:10";
	String alert4 = "Next Station: Narayanganj";
	String alert5 = "Next Stop: Narayanganj at 3rd stn";
	String alert6 = "Delay: 00:05";
	builder.setMessage(alert1 +"\n"+ alert2 +"\n"+ alert3+"\n"+ alert4+"\n"+ alert5+"\n"+ alert6);
	
	builder.setIcon(android.R.drawable.ic_dialog_alert);

	builder.setPositiveButton("OK", null);

	displayNewDialog(builder);

}

}