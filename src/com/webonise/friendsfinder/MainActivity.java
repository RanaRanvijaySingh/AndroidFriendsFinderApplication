package com.webonise.friendsfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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

	// public void getLocationInMap(double longitude, double latitude,
	// String name, String imageUrl) {
	//
	// // mTabHost.setCurrentTab(0);
	// // MapFragment mapFragment= new MapFragment();
	// // mapFragment.setMarker(latitude, longitude, name,imageUrl);
	// // Log.v(null,"switched");
	//
	// }

	public void getFragment(int intFragment) {
		Log.v(null, "Clicked");
		if (intFragment == 0) {
			// FragmentTransaction transaction = fragmentManager
			// .beginTransaction();
			// transaction.replace(R.id.fragments, mapFragment);
			// transaction.commit();
		} else {
			// FragmentTransaction transaction = fragmentManager
			// .beginTransaction();
			// transaction.replace(R.id.fragments, fListFragment);
			// transaction.commit();
		}
	}
}