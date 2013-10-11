package com.webonise.friendsfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.facebook.Session;
import com.webonise.friendsfinder.webservice.FacebookService;

public class MainActivity extends FragmentActivity {

	private static final String TAG = "MainActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.map_fragment);
		FacebookService mService = FacebookService.getIntance();
		mService.createFacebookSession(this);
		Intent intent = new Intent(this, MapFragment.class);
		startActivity(intent);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}
}