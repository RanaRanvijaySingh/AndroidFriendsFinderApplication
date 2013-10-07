package com.webonise.friendsfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

import com.facebook.Session;
import com.webonise.friendsfinder.webservice.FacebookService;

public class MainActivity extends FragmentActivity {

	private static final String TAG = "MainActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setTabContent();
		// start Facebook Login
		FacebookService mService =FacebookService.getIntance();
		mService.createFacebookSession(this);
	}

	private void setTabContent() {
		FragmentTabHost mTabHost;
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.tabFrameLayout);

		mTabHost.addTab(mTabHost.newTabSpec("map").setIndicator("Map"),
				MapFragment.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("friends").setIndicator("Friends"),
				FriendListFragment.class, null);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}
}