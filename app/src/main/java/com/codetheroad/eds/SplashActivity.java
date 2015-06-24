package com.codetheroad.eds;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashActivity extends SharedPref {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		Thread timer = new Thread() {
			public void run() {
				try {
					// 2 second splash on start of program
					sleep(2000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				} finally {
					// populate shared preferences with necessary starting
					// values, or if values become empty repopulate
					populatedSharedPref();
					// if its the 1st time the program has started, open the
					// preferences menu
					if (getSavedData(firstCheck, SplashActivity.this) == null) {
						Intent firstPref = new Intent(
								"com.codetheroad.eds.TUTORIAL");
						startActivity(firstPref);
					} else {
						// else go to the main activity
						Intent firstPref = new Intent(
								"com.codetheroad.eds.MAINTABS");
						startActivity(firstPref);
					}
				}
			}
		};
		// start thread
		timer.start();//
	}

	@Override
	protected void onPause() {
		super.onPause();
		// close activity
		finish();
	}
}
