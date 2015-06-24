package com.codetheroad.eds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codetheroad.eds.data.Destination;
import com.codetheroad.eds.data.ServerConnection;
import com.codetheroad.eds.data.Vehicle;
import com.google.android.gms.maps.model.LatLng;


public class CommunicationActivity extends Activity {
	public static EditText[] tipsArray;
	EditText[] hoursArray, gasArray;
	Button save, finish;
	Vehicle vehicle;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.communcation_layout);

		// Hook up buttons
		Button contactButton = (Button) findViewById(R.id.button1);
		contactButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent smsIntent = new Intent(Intent.ACTION_VIEW);
				smsIntent.setType("vnd.android-dir/mms-sms");
				smsIntent.putExtra("address", "4046106603");
				smsIntent.putExtra("sms_body", "Where are you?");
				startActivity(smsIntent);
			}
		});

		Button deliverButton = (Button) findViewById(R.id.button2);
		deliverButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				LatLng deliveryLocation = vehicle.getDestinations().get(0).getLocation();
				vehicle.deliver(deliveryLocation);
				populateFields();
			}
		});
	}

	public void onResume() {
		super.onResume();
		try {
			vehicle = ServerConnection.connect(this.getAssets()).getVehicle();
			populateFields();
		} catch (Throwable t) {
			// Since it's just JSON data, should absolutely never get here.
			t.printStackTrace();
		}
		//	connectVariables();
		populateFields();
	}

	private void populateFields() {
		// txtRequestedItems
		TextView txtRequestedItems = (TextView) findViewById(R.id.txtRequestedItems);
        Destination nextDestination = vehicle.getDestinations().get(0);
        String itemsRequested = nextDestination.getNeedsAsString();
		txtRequestedItems.setText(itemsRequested);

		// txtItemsBeingDelivered
		TextView txtItemsBeingDelivered = (TextView) findViewById(R.id.txtItemsBeingDelivered);
		String itemsBeingDelivered = vehicle.getItemsBeingDeliveredAsString();
		txtItemsBeingDelivered.setText(itemsBeingDelivered);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Options menu pop-up
		super.onCreateOptionsMenu(menu);
		MenuInflater mf = getMenuInflater();
		mf.inflate(R.layout.pref_pop, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Select activity to launch based on selection from options menu
		switch (item.getItemId()) {
		case R.id.about:
			Intent i = new Intent("com.codetheroad.eds.ABOUT");
			startActivity(i);
			break;
		case R.id.help:
			Intent i2 = new Intent("com.codetheroad.eds.TUTORIAL");
			startActivity(i2);
			break;
		case R.id.preferences:
			Intent i3 = new Intent("com.codetheroad.eds.PREFERENCES");
			startActivity(i3);
			break;
		}
		return false;
	}
}