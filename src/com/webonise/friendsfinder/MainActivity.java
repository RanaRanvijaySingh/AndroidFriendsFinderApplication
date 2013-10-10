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
<<<<<<< HEAD

		setContentView(R.layout.map_fragment);
		FacebookService mService = FacebookService.getIntance();
		mService.createFacebookSession(this);
		Intent intent = new Intent(this, MapFragment.class);
		startActivity(intent);

=======
		setContentView(R.layout.activity_main);

		// start Facebook Login
		Session.openActiveSession(this, true, new Session.StatusCallback() {

			// callback when session changes state
			@Override
			public void call(Session session, SessionState state,
					Exception exception) {
				if (session.isOpened()) {

					// make request to the /me API
					Request.executeMeRequestAsync(session,
							new Request.GraphUserCallback() {

								// callback after Graph API response with user
								// object
								@Override
								public void onCompleted(GraphUser user,
										Response response) {
									if (user != null) {
										TextView textViewWelcome = (TextView) findViewById(R.id.welcome);
										textViewWelcome.setText("Hello "
												+ user.getName() + "!");
										//this is now modified
									}
								}
							});
				}
			}
		});
>>>>>>> e7ea35d54fd06173389dfad89da9b58cca44ead0
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