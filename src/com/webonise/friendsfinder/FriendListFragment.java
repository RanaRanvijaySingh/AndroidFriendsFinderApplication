package com.webonise.friendsfinder;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.Response;
import com.webonise.friendsfinder.adapter.FriendListAdapter;
import com.webonise.friendsfinder.model.FriendModel;
import com.webonise.friendsfinder.parser.JsonParser;
import com.webonise.friendsfinder.task.RequestServiceTask;

@SuppressLint({ "ValidFragment", "ResourceAsColor" })
public class FriendListFragment extends FragmentActivity implements
		OnClickListener {

	private static final String TAG = GetField.class.getName();

	MainActivity mainActivity;
	String stringArrayFriends[];
	List<FriendModel> friendsList;
	ListView listView;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.friend_list_fragment);
		initializeComponents();
		listView = (ListView) findViewById(R.id.frinds_list);
		Log.v(TAG, " ");
	}

	@SuppressLint("ResourceAsColor")
	private void initializeComponents() {
		Button buttonFriends = (Button) findViewById(R.id.button_friends);
		Button buttonMap = (Button) findViewById(R.id.button_map);
		buttonFriends.setClickable(false);
		buttonMap.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Log.v(null, "friends clicked");
		Intent intent = new Intent(this, MapFragment.class);
		startActivity(intent);
	}

	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	//
	// View view = inflater.inflate(R.layout.friend_list_fragment, container,
	// false);
	// listView = (ListView) view.findViewById(R.id.frinds_list);
	//
	// // new RequestServiceTask().execute(); //not using
	//
	// // FacebookService mService = FacebookService.getIntance();
	// // mService.getFriendsList(this);
	//
	// // listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
	// // {
	// // @Override
	// // public void onItemClick(AdapterView<?> arg0, View arg1,
	// // int position, long arg3) {
	// //
	// // FriendModel friend = new FriendModel();
	// // friend = friendsList.get(position);
	// // Log.v("clicked", friend.getName());
	// // Log.v("clicked", friend.getLocation());
	// // Log.v("clicked", friend.getState());
	// // Log.v("clicked", "" + friend.getLatitude());
	// // Log.v("clicked", "" + friend.getLongitude());
	// //
	// // mainActivity.getLocationInMap(friend.getLongitude(),
	// // friend.getLatitude(), friend.getName(),
	// // friend.getImageUrl());
	// // }
	// // });
	// Log.v(TAG, "in the friends list fragment");
	// return view;
	// }

	public void onFriendsListResult(Response response) {
		Response mResponse = response;
		friendsList = new ArrayList<FriendModel>();
		JsonParser jsonParser = new JsonParser();
		// friendsList = new ArrayList<String>();
		// friendsList = jsonParser.parseJsonObject(mResponse);
		Log.v("list", friendsList.get(0).getName());
		callForAdapter();

	}

	private void callForAdapter() {

		FriendListAdapter adapter = new FriendListAdapter(mainActivity,
				friendsList);
		listView.setAdapter(adapter);
	}
}
