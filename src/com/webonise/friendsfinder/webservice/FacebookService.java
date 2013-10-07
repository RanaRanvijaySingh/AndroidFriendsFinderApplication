package com.webonise.friendsfinder.webservice;

import android.os.Bundle;
import android.util.Log;

import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.webonise.friendsfinder.FriendListFragment;
import com.webonise.friendsfinder.MainActivity;

public class FacebookService {

	private static FacebookService service=new FacebookService();
	private FacebookService()
	{
	
	}
	public static FacebookService getIntance()
	{
		return service;
	}


	public void createFacebookSession(MainActivity mActivity) {
		
		Session.openActiveSession(mActivity, true,
				new Session.StatusCallback() {

					// callback when session changes state
					@SuppressWarnings("deprecation")
					@Override
					public void call(Session session, SessionState state,
							Exception exception) {
						if (session.isOpened()) {

							// make request to the /me API
							Request.executeMeRequestAsync(session,
									new Request.GraphUserCallback() {

										// callback after Graph API response
										// with user
										// object
										@Override
										public void onCompleted(GraphUser user,
												Response response) {
											Log.v("","creating session");
											//getFriendsList();
										}

									});
						}
					}
				});

	}

	public void getFriendsList(final FriendListFragment context) {
		
		// String fqlQuery =
		// "select uid, name, pic_square from user where uid in (select uid2 from friend where uid1 = me())";

		// String fqlQuery =
		// "SELECT current_location FROM user WHERE uid IN (SELECT uid2 FROM friend WHERE uid1 = me())";
		String fqlQuery = "select name from user where uid in (select uid2 from friend where uid1 = me())";
		// String fqlQuery
		// ="me?fields=id,name,first_name,last_name,email,picture.width(150).height(150),username,location,friends.fields(name,picture.width(150).height(150),username,location)";
		Bundle bundle = new Bundle();
		bundle.putString("q", fqlQuery);
		
		Session session = Session.getActiveSession();
		Request request = new Request(session, "/fql", bundle, HttpMethod.GET,
				new Request.Callback() {
			
					public void onCompleted(Response response) {
					
						Log.i(null, "Got results: " + response.toString());
						context.onFriendsListResult(response);
					}
				});
		Request.executeBatchAsync(request);
		
	
	}
	
}
