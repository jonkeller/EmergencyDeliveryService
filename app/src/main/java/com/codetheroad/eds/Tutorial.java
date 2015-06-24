package com.codetheroad.eds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tutorial extends SharedPref {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial);

		Button done = (Button) findViewById(R.id.DoneTutorial);
		done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (getSavedData(firstCheck, Tutorial.this) == null) {
					Intent firstPref = new Intent(
							"com.codetheroad.eds.PREFERENCES");
					startActivity(firstPref);
				} else {
					// else go to the main activity
					Intent firstPref = new Intent(
							"com.codetheroad.eds.MAINTABS");
					startActivity(firstPref);
				}

			}

		});
	}

}
