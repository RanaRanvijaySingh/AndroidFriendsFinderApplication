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

public class MainActivity extends FragmentActivity implements OnClickListener {

	private static final String TAG = "MainActivity";
	public static final int MAP = 0;
	public static final int FRIENDS = 1;
	MapFragment mapFragment;
	FriendListFragment fListFragment;
	FragmentManager fragmentManager = getSupportFragmentManager();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FacebookService mService = FacebookService.getIntance();
		mService.createFacebookSession(this);

		initializeComponents();

		FragmentTransaction transaction = fragmentManager.beginTransaction();
		fListFragment = new FriendListFragment(this);
		mapFragment = new MapFragment(this);
		transaction.add(R.id.fragments, mapFragment);
		transaction.commit();

	}

	private void initializeComponents() {
		Button buttonMap = (Button) findViewById(R.id.button_map);
		Button buttonFriends = (Button) findViewById(R.id.button_friends);
		buttonMap.setOnClickListener(this);
		buttonFriends.setOnClickListener(this);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}

	public void getLocationInMap(double longitude, double latitude,
			String name, String imageUrl) {

		// mTabHost.setCurrentTab(0);
		// MapFragment mapFragment= new MapFragment();
		// mapFragment.setMarker(latitude, longitude, name,imageUrl);
		// Log.v(null,"switched");

	}

	public void getFragment(int intFragment) {
		Log.v(null, "Clicked");
		if (intFragment == 0) {
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.fragments, mapFragment);
			transaction.commit();
		} else {
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.fragments, fListFragment);
			transaction.commit();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_map:
			getFragment(MAP);
			break;
		case R.id.button_friends:
			getFragment(FRIENDS);
			break;
		}
	}
}