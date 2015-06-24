package com.codetheroad.eds;

import android.content.Intent;
import android.net.Uri;
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
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends Activity {
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
	private static final String MapLink =
			"http://undefined.tile.openweathermap.org/map/rain/%d/%d/%d.png";
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
				.snippet("George K.  - Medical"));
		Marker event2 = map.addMarker(new MarkerOptions()
				.position(Event2)
				.title("Library")
				.snippet("Safe Zone")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.library64)));
		Marker event3 = map.addMarker(new MarkerOptions()
				.position(Event3)
				.title("Hospital")
				.snippet("Safe Zone")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital64)));
		Marker event4 = map.addMarker(new MarkerOptions()
				.position(Event4)
				.title("Alert")
				.snippet("Cat Von Dee - Climate"));
		Marker event5 = map.addMarker(new MarkerOptions()
				.position(Event5)
				.title("Alert")
				.snippet("Mitch J. - Medical"));
		Marker event6 = map.addMarker(new MarkerOptions()
				.position(Event6)
				.title("Alert")
				.snippet("Jerry P. - Hygiene"));
		Marker event7 = map.addMarker(new MarkerOptions()
				.position(Event7)
				.title("Alert")
				.snippet("Luke W. - Climate"));
		Marker event8 = map.addMarker(new MarkerOptions()
				.position(Event8)
				.title("Alert")
				.snippet("Yodi - Medical"));
		Marker event9 = map.addMarker(new MarkerOptions()
				.position(Event9)
				.title("Alert")
				.snippet("Greyson B. - Hygiene"));
		Marker event10 = map.addMarker(new MarkerOptions()
				.position(Event10)
				.title("Alert")
				.snippet("Kyle H. - Emergency"));
		Marker event11 = map.addMarker(new MarkerOptions()
				.position(Event11)
				.title("Alert")
				.snippet("Pat K. - Climate"));
		Marker event12 = map.addMarker(new MarkerOptions()
				.position(Event12)
				.title("Alert")
				.snippet("Tracy Z. - Medical"));
		Marker event13 = map.addMarker(new MarkerOptions()
				.position(Event13)
				.title("Alert")
				.snippet("Trey O. - Hygiene"));
		Marker event14 = map.addMarker(new MarkerOptions()
				.position(Event14)
				.title("Alert")
				.snippet("Frank S. - Climate"));
		Marker event15 = map.addMarker(new MarkerOptions()
				.position(Event15)
				.title("Alert")
				.snippet("Item Requested"));
		Marker event16 = map.addMarker(new MarkerOptions()
				.position(Event16)
				.title("Alert")
				.snippet("Harry T.  - Hygiene"));

// Find the ListView resource.
		mainListView = (ListView) findViewById( R.id.listView );

		// Create and populate a List of planet names.
		String[] planets = new String[] { "George K.  - Medical", "Harry T.  - Hygiene", "Sally W.  - Emergency", "Cat Von Dee - Climate",
				"Mitch J. - Medical", "Jerry P. - Hygiene", "Luke W. - Climate", "Yodi - Medical"};
		ArrayList<String> planetList = new ArrayList<String>();
		planetList.addAll( Arrays.asList(planets) );

		// Create ArrayAdapter using the planet list.
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);

		// Add more planets. If you passed a String[] instead of a List<String>
		// into the ArrayAdapter constructor, you must not add more items.
		// Otherwise an exception will occur.
		listAdapter.add( "Greyson B. - Hygiene" );
		listAdapter.add( "Kyle H. - Emergency" );
		listAdapter.add("Pat K. - Climate");
		listAdapter.add("Tracy Z. - Medical");
		listAdapter.add("Trey O. - Hygiene");

		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter( listAdapter );
		mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
									long id) {

				String item = ((TextView) view).getText().toString();

				Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=33.89569276,-84.4877032(label)"));
				startActivity(intent);
			}
		});

		setUpMap();
	}
//	private void setUpMapIfNeeded() {
//		// Do a null check to confirm that we have not already instantiated the map.
//		if (mMap == null) {
//			// Try to obtain the map from the SupportMapFragment.
//			mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
//					.getMap();
//			// Check if we were successful in obtaining the map.
//			if (mMap != null) {
//				setUpMap();
//			}
//		}
//	}

	private void setUpMap() {
		//map.setMapType(GoogleMap.MAP_TYPE_NONE);
		// Move the camera instantly to hamburg with a zoom of 15.
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(Atlanta, 15));

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		TileProvider tileProvider = new UrlTileProvider(256, 256) {
			@Override
			public synchronized URL getTileUrl(int x, int y, int zoom) {



				String s = String.format( MapLink, zoom, x, y);
				URL url = null;
				try {
					url = new URL(s);
				} catch (MalformedURLException e) {
					throw new AssertionError(e);
				}
				return url;
			}
		};

		map.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));
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