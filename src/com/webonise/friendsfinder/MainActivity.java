package com.webonise.friendsfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.facebook.Session;
import com.webonise.friendsfinder.webservice.FacebookService;

public class MainActivity extends FragmentActivity {

	private static final String TAG = "MainActivity";
	public static final int MAP=0;
	public static final int FRIENDS=1;
	MapFragment mapFragment;
	FriendListFragment fListFragment;
	FragmentManager fragmentManager=getSupportFragmentManager();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentTransaction transaction=fragmentManager.beginTransaction();
		fListFragment= new FriendListFragment(this);
		mapFragment= new MapFragment(this);
		transaction.add(R.id.fragments, mapFragment);
		transaction.commit();
		
	
//		FacebookService mService =FacebookService.getIntance();
//		mService.createFacebookSession(this);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}

	public void getLocationInMap(double longitude, double latitude, String name,String imageUrl) {

//		mTabHost.setCurrentTab(0);
//		MapFragment mapFragment= new MapFragment();
//		mapFragment.setMarker(latitude, longitude, name,imageUrl);
//		Log.v(null,"switched");
		
		
	}
	public void getFragment(int intFragment)
	{
		
	}
}