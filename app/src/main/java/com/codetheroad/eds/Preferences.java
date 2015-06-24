package com.codetheroad.eds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Preferences extends SharedPref {

	EditText hourlyWageBox, roadWageBox, deliveryFeeBox;
	CheckBox diffRate;
	Button saveExitPref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preferences);
		connectVariables();
		populateFields();

	}

	private void connectVariables() {
		// Prevent software keyboard from automatically opening in ScrollView
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		// connect xml layout with java
		hourlyWageBox = (EditText) findViewById(R.id.MainWage);
		roadWageBox = (EditText) findViewById(R.id.RoadWage);
		deliveryFeeBox = (EditText) findViewById(R.id.DeliveryFee);
		saveExitPref = (Button) findViewById(R.id.ExitPref);
		saveExitPref.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Retrieve first run value for if statement to change how
				// activity runs based on where activity is being started from
				String firstRunCheck = getSavedData(firstCheck,
						Preferences.this);
				// Save to Shared Preferences
				saveToSP(firstCheck, "1", Preferences.this);
				saveToSP(hourlyWage, hourlyWageBox.getText().toString(),
						Preferences.this);
				saveToSP(roadWage, roadWageBox.getText().toString(),
						Preferences.this);
				saveToSP(deliveryFee, deliveryFeeBox.getText().toString(),
						Preferences.this);
				// Tell user data was saved
				Toast.makeText(getApplicationContext(), "Saved",
						Toast.LENGTH_SHORT).show();
				// check of this is first run (firstRunCheck == null), if so
				// launch main TabActiviy
				if (firstRunCheck == null) {
					Intent openStartingPoint = new Intent(
							"com.codetheroad.eds.MAINTABS");
					startActivity(openStartingPoint);
					//
				}
			}
		});
	}

	private void populateFields() {
		// retrieve and set fields to previous save based on user input
		String getHw = getSavedData(hourlyWage, Preferences.this);
		String getRw = getSavedData(roadWage, Preferences.this);
		String getDf = getSavedData(deliveryFee, Preferences.this);
		hourlyWageBox.setText(getHw);
		roadWageBox.setText(getRw);
		deliveryFeeBox.setText(getDf);
	}
}
