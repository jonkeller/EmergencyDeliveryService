package com.codetheroad.eds;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codetheroad.eds.data.Item;
import com.codetheroad.eds.data.ServerConnection;
import com.codetheroad.eds.data.Vehicle;

import java.util.Iterator;
import java.util.Map;

public class InventoryActivity extends Activity {

	TextView[] nameArray, codeArray;
	Vehicle vehicle;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_layout);
		//connectVariables();
	}

	@Override
	public void onResume() {
		super.onResume();
		try {
			vehicle = ServerConnection.connect(this.getAssets()).getVehicle();
			populateFields();
		} catch (Throwable t) {
			// Since it's just JSON data, should absolutely never get here.
			t.printStackTrace();
		}
	}

	private void populateFields() {
		// retrieve data from shared preferences and populated edit text fields
		//getSavedTextViewArray(subName, nameArray);
		//getSavedTextViewArray(subCode, codeArray);
		Map<Item.Type, Integer> inventory = vehicle.getItems();

		Iterator<Map.Entry<Item.Type, Integer>> it = inventory.entrySet().iterator();

		// This is shameful
		if (it.hasNext()) { populateField(R.id.subName1, R.id.subCode1, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName2, R.id.subCode2, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName3, R.id.subCode3, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName4, R.id.subCode4, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName5, R.id.subCode5, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName6, R.id.subCode6, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName7, R.id.subCode7, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName8, R.id.subCode8, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName9, R.id.subCode9, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName10, R.id.subCode10, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName11, R.id.subCode11, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName12, R.id.subCode12, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName13, R.id.subCode13, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName14, R.id.subCode14, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName15, R.id.subCode15, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName16, R.id.subCode16, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName17, R.id.subCode17, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName18, R.id.subCode18, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName19, R.id.subCode19, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName20, R.id.subCode20, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName21, R.id.subCode21, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName22, R.id.subCode22, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName23, R.id.subCode23, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName24, R.id.subCode24, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName25, R.id.subCode25, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName26, R.id.subCode26, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName27, R.id.subCode27, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName28, R.id.subCode28, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName29, R.id.subCode29, it.next()); }
		if (it.hasNext()) { populateField(R.id.subName30, R.id.subCode30, it.next()); }
	}

	private void populateField(int subName, int subCode, Map.Entry<Item.Type, Integer> entry) {
		Item.Type itemType = entry.getKey();
		int quantity = entry.getValue();
		((TextView)findViewById(subName)).setText(Item.typeToString(itemType));
		((TextView)findViewById(subCode)).setText(Integer.toString(quantity));
	}

	/*
	private void connectVariables() {
		// Connect XML layout with Java
		nameArray = new TextView[] { (TextView) findViewById(R.id.subName1),
				(TextView) findViewById(R.id.subName2),
				(TextView) findViewById(R.id.subName3),
				(TextView) findViewById(R.id.subName4),
				(TextView) findViewById(R.id.subName5),
				(TextView) findViewById(R.id.subName6),
				(TextView) findViewById(R.id.subName7),
				(TextView) findViewById(R.id.subName8),
				(TextView) findViewById(R.id.subName9),
				(TextView) findViewById(R.id.subName10),
				(TextView) findViewById(R.id.subName11),
				(TextView) findViewById(R.id.subName12),
				(TextView) findViewById(R.id.subName13),
				(TextView) findViewById(R.id.subName14),
				(TextView) findViewById(R.id.subName15),
				(TextView) findViewById(R.id.subName16),
				(TextView) findViewById(R.id.subName17),
				(TextView) findViewById(R.id.subName18),
				(TextView) findViewById(R.id.subName19),
				(TextView) findViewById(R.id.subName20),
				(TextView) findViewById(R.id.subName21),
				(TextView) findViewById(R.id.subName22),
				(TextView) findViewById(R.id.subName23),
				(TextView) findViewById(R.id.subName24),
				(TextView) findViewById(R.id.subName25),
				(TextView) findViewById(R.id.subName26),
				(TextView) findViewById(R.id.subName27),
				(TextView) findViewById(R.id.subName28),
				(TextView) findViewById(R.id.subName29),
				(TextView) findViewById(R.id.subName30), };

		codeArray = new TextView[] { (TextView) findViewById(R.id.subCode1),
				(TextView) findViewById(R.id.subCode2),
				(TextView) findViewById(R.id.subCode3),
				(TextView) findViewById(R.id.subCode4),
				(TextView) findViewById(R.id.subCode5),
				(TextView) findViewById(R.id.subCode6),
				(TextView) findViewById(R.id.subCode7),
				(TextView) findViewById(R.id.subCode8),
				(TextView) findViewById(R.id.subCode9),
				(TextView) findViewById(R.id.subCode10),
				(TextView) findViewById(R.id.subCode11),
				(TextView) findViewById(R.id.subCode12),
				(TextView) findViewById(R.id.subCode13),
				(TextView) findViewById(R.id.subCode14),
				(TextView) findViewById(R.id.subCode15),
				(TextView) findViewById(R.id.subCode16),
				(TextView) findViewById(R.id.subCode17),
				(TextView) findViewById(R.id.subCode18),
				(TextView) findViewById(R.id.subCode19),
				(TextView) findViewById(R.id.subCode20),
				(TextView) findViewById(R.id.subCode21),
				(TextView) findViewById(R.id.subCode22),
				(TextView) findViewById(R.id.subCode23),
				(TextView) findViewById(R.id.subCode24),
				(TextView) findViewById(R.id.subCode25),
				(TextView) findViewById(R.id.subCode26),
				(TextView) findViewById(R.id.subCode27),
				(TextView) findViewById(R.id.subCode28),
				(TextView) findViewById(R.id.subCode29),
				(TextView) findViewById(R.id.subCode30) };

	}
	*/

	// create an inflatable preferences menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater mf = getMenuInflater();
		mf.inflate(R.layout.pref_pop, menu);
		return true;
	}

	// open activities based on selection
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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