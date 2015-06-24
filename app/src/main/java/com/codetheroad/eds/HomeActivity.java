package com.codetheroad.eds;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends SharedPref {
	static final LatLng Atlanta = new LatLng(33.8660485,-84.416913);
	static final LatLng Event1 = new LatLng(33.9339546,-84.64890548);
	static final LatLng Event2 = new LatLng(33.88506299,-84.40306652);
	static final LatLng Event3 = new LatLng(33.90341149,-84.63043663);
	static final LatLng Event4 = new LatLng(33.86544326,-84.43061938);
	static final LatLng Event5 = new LatLng(33.99616945,-84.55696643);
	static final LatLng Event6 = new LatLng(33.86386961,-84.50127896);
	static final LatLng Event7 = new LatLng(33.06811381,-84.48476484);
	static final LatLng Event8 = new LatLng(33.07075946,-84.46473602);
	static final LatLng Event9 = new LatLng(33.82644794, -84.55055915);
	static final LatLng Event10 = new LatLng(33.05227635,-84.43634233);
	static final LatLng Event11 = new LatLng(33.95583195,-84.55928679);
	static final LatLng Event12 = new LatLng(33.88649901,-84.62402609);
	static final LatLng Event13 = new LatLng(33.95826448,-84.53039956);
	static final LatLng Event14 = new LatLng(33.05630753,-84.5503126);
	static final LatLng Event15 = new LatLng(33.03118528,-84.66236267);
	static final LatLng Event16 = new LatLng(33.89569276,-84.4877032);
	private GoogleMap map;
	public static TextView[] homeUpdateArray;
	private ListView mainListView ;
	private ArrayAdapter<String> listAdapter ;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);
	//	connectVariables();
		//populateFields();
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.fragment))
				.getMap();
		Marker atlanta = map.addMarker(new MarkerOptions().position(Atlanta)
				.title("Our Location"));
		Marker event1 = map.addMarker(new MarkerOptions()
				.position(Event1)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event2 = map.addMarker(new MarkerOptions()
				.position(Event2)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event3 = map.addMarker(new MarkerOptions()
				.position(Event3)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event4 = map.addMarker(new MarkerOptions()
				.position(Event4)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event5 = map.addMarker(new MarkerOptions()
				.position(Event5)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event6 = map.addMarker(new MarkerOptions()
				.position(Event6)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event7 = map.addMarker(new MarkerOptions()
				.position(Event7)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event8 = map.addMarker(new MarkerOptions()
				.position(Event8)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event9 = map.addMarker(new MarkerOptions()
				.position(Event9)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event10 = map.addMarker(new MarkerOptions()
				.position(Event10)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event11 = map.addMarker(new MarkerOptions()
				.position(Event11)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event12 = map.addMarker(new MarkerOptions()
				.position(Event12)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event13 = map.addMarker(new MarkerOptions()
				.position(Event13)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event14 = map.addMarker(new MarkerOptions()
				.position(Event14)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event15 = map.addMarker(new MarkerOptions()
				.position(Event15)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event16 = map.addMarker(new MarkerOptions()
				.position(Event16)
				.title("Alert")
				.snippet("Item Requested"));

// Find the ListView resource.
		mainListView = (ListView) findViewById( R.id.listView );

		// Create and populate a List of planet names.
		String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
				"Jupiter", "Saturn", "Uranus", "Neptune"};
		ArrayList<String> planetList = new ArrayList<String>();
		planetList.addAll( Arrays.asList(planets) );

		// Create ArrayAdapter using the planet list.
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);

		// Add more planets. If you passed a String[] instead of a List<String>
		// into the ArrayAdapter constructor, you must not add more items.
		// Otherwise an exception will occur.
		listAdapter.add( "Ceres" );
		listAdapter.add( "Pluto" );
		listAdapter.add( "Haumea" );
		listAdapter.add( "Makemake" );
		listAdapter.add( "Eris" );

		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter( listAdapter );
		mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
									long id) {

				String item = ((TextView) view).getText().toString();

				Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

			}
		});
		// Move the camera instantly to hamburg with a zoom of 15.
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(Atlanta, 15));

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	}


//	private void populateFields() {
//		// retrieve data from shared preferences and populated edit text fields
//		homeUpdateArray[0]
//				.setText(String.format("%.2f", Double.parseDouble(getSavedData(
//						homeHourlyNoGas, HomeActivity.this))));
//		homeUpdateArray[1].setText(String.format("%.2f", Double
//				.parseDouble(getSavedData(homeHourlyWage, HomeActivity.this))));
//		homeUpdateArray[2].setText(String.format("%.2f", Double
//				.parseDouble(getSavedData(homeTotalTips, HomeActivity.this))));
//		homeUpdateArray[3].setText(String.format("%.2f", Double
//				.parseDouble(getSavedData(homeTotalHours, HomeActivity.this))));
//		homeUpdateArray[4]
//				.setText(String.format("%.2f", Double.parseDouble(getSavedData(
//						homeTotalIncome, HomeActivity.this))));
//	}
//
//	private void connectVariables() {
//		// Connect XML layout with Java
//		homeUpdateArray = new TextView[] { (TextView) findViewById(R.id.Home1),
//				(TextView) findViewById(R.id.Home2),
//				(TextView) findViewById(R.id.Home3),
//				(TextView) findViewById(R.id.Home4),
//				(TextView) findViewById(R.id.Home5) };
//		Button historyButton = (Button) findViewById(R.id.HistoryButton);
//		Button calcButton = (Button) findViewById(R.id.CalcButton);
//		historyButton.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// open history activity when history button is checked
//				Intent i = new Intent("com.davidtunnell.deliverypal.HISTORY");
//				startActivity(i);
//			}
//		});
//		calcButton.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// open default calculator when calculator button is checked
//				Intent calcIntent = new Intent();
//				calcIntent.setClassName("com.android.calculator2",
//						"com.android.calculator2.Calculator");
//				startActivity(calcIntent);
//			}
//		});
//	}

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