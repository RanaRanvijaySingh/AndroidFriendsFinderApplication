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

	private static FacebookService service = new FacebookService();

	private FacebookService() {

	}

	public static FacebookService getIntance() {
		return service;
	}

	public void createFacebookSession(MainActivity mainActivity) {
		Session.openActiveSession(mainActivity, true,
				new Session.StatusCallback() {
					@SuppressWarnings("deprecation")
					@Override
					public void call(Session session, SessionState state,
							Exception exception) {
						if (session.isOpened()) {
							Request.executeMeRequestAsync(session,
									new Request.GraphUserCallback() {
										@Override
										public void onCompleted(GraphUser user,
												Response response) {
											Log.v("", "session created");
											// getFriendsList();
										}

									});
						}
					}
				});

	}

	public void getFriendsList(final FriendListFragment context) {

		// String fqlQuery
		// ="select uid, name, pic_square from user where uid in (select uid2 from friend where uid1 = me())";
		// "SELECT current_location FROM user WHERE uid IN (SELECT uid2 FROM friend WHERE uid1 = me())";
		String fqlQuery = "select name,pic_square,current_location from user where uid in (select uid2 from friend where uid1 = me())";
		// String
		// fqlQuery="me?fields=id,name,first_name,last_name,email,picture.width(150).height(150),username,location,friends.fields(name,picture.width(150).height(150),username,location)";
		Bundle bundle = new Bundle();
		bundle.putString("q", fqlQuery);
		Session session = Session.getActiveSession();
		Request request = new Request(session, "/fql", bundle, HttpMethod.GET,
				new Request.Callback() {
					public void onCompleted(Response response) {
						context.onFriendsListResult(response);
					}
				});
		Log.i("", " ==============" + request.toString());
		Request.executeBatchAsync(request);

	}

}
