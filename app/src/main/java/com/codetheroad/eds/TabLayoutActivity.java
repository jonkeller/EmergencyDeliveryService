package com.codetheroad.eds;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class TabLayoutActivity extends TabActivity {

	public static TabHost tabHostObj;
	public TabSpec communicationSpec;
	public Intent communicationIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_tab_layout);
		// set TabHost object to the one the activity is using
		tabHostObj = getTabHost();

		// make a new tab called maps
		TabSpec mapsSpec = tabHostObj.newTabSpec("Maps");
		// set this tab to an icon in resources
		mapsSpec.setIndicator("",
				getResources().getDrawable(R.drawable.icon_maps_tab));
		// set which activity this tab opens
		Intent mapsIntent = new Intent(this, MapsActivity.class);
		mapsSpec.setContent(mapsIntent);

		// The wage activity has two versions based on whether the user has
		// checked check box in the preferences activity. This if statement sets
		// the appropriate activity based on the users choice
		if (Boolean.valueOf(getSavedData("Wage_Check_Box",
				TabLayoutActivity.this))) {
			communicationSpec = tabHostObj.newTabSpec("Communication");
			communicationSpec.setIndicator("",
					getResources().getDrawable(R.drawable.icon_wage_tab));
			communicationIntent = new Intent(this, WageCheckedActivity.class);
		} else {
			communicationSpec = tabHostObj.newTabSpec("Wage");
			communicationSpec.setIndicator("",
					getResources().getDrawable(R.drawable.icon_wage_tab));
			communicationIntent = new Intent(this, CommunicationActivity.class);

		}
		communicationSpec.setContent(communicationIntent);

		TabSpec homeSpec = tabHostObj.newTabSpec("Home");
		homeSpec.setIndicator("",
				getResources().getDrawable(R.drawable.icon_home_tab));
		Intent homeIntent = new Intent(this, HomeActivity.class);
		homeSpec.setContent(homeIntent);

		TabSpec inventorySpec = tabHostObj.newTabSpec("Inventory");
		inventorySpec.setIndicator("",
				getResources().getDrawable(R.drawable.icon_inventory_tab));
		Intent inventoryIntent = new Intent(this, InventoryActivity.class);
		inventorySpec.setContent(inventoryIntent);

		TabSpec loggingSpec = tabHostObj.newTabSpec("Logging");
		loggingSpec.setIndicator("",
				getResources().getDrawable(R.drawable.icon_logging_tab));
		Intent loggingIntent = new Intent(this, LoggingActivity.class);
		loggingSpec.setContent(loggingIntent);

		// Adding all TabSpecObj to TabHost
		tabHostObj.addTab(mapsSpec);
		tabHostObj.addTab(communicationSpec);
		tabHostObj.addTab(homeSpec);
		tabHostObj.addTab(inventorySpec);
		tabHostObj.addTab(loggingSpec);

		// Set default tab to Home
		tabHostObj.setCurrentTab(2);

		// Set Tabs background color
		for (int i = 0; i < 5; i++) {
			tabHostObj.getTabWidget().getChildAt(i)
					.setBackgroundColor(Color.parseColor("#CCB485"));
		}

		// tab change listener used to check if maps tab is pressed, if so open
		// google maps
		tabHostObj.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				if ("Maps".equals(tabId)) {
					// start google maps app
					startActivity(getPackageManager()
							.getLaunchIntentForPackage(
									"com.google.android.apps.maps"));
					// set tab selection to home tab
					tabHostObj.setCurrentTab(2);
				}
			}
		});
	}

	// even though TabActivity extends Activity, when I extend it in shared
	// preferences it the program crashes, so here is the redundant method so
	// that this class can extend TabActivity on its own
	public static String getSavedData(String key, Context context) {
		SharedPreferences data = PreferenceManager
				.getDefaultSharedPreferences(context);
		return data.getString(key, null);
	}
}