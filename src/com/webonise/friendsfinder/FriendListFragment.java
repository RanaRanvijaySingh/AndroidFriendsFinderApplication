package com.webonise.friendsfinder;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.Response;
import com.webonise.friendsfinder.adapter.FriendListAdapter;
import com.webonise.friendsfinder.model.FriendModel;
import com.webonise.friendsfinder.parser.JsonParser;
import com.webonise.friendsfinder.task.RequestServiceTask;

@SuppressLint("ValidFragment")
public class FriendListFragment extends Fragment {

	private static final String TAG = GetField.class.getName();

	MainActivity mainActivity;
	String stringArrayFriends[];
	List<FriendModel> friendsList;
	ListView listView;

	@SuppressLint("ValidFragment")
	public FriendListFragment(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.friend_list_fragment, container,
				false);
		listView = (ListView) view.findViewById(R.id.frinds_list);

		// new RequestServiceTask().execute(); //not using

		// FacebookService mService = FacebookService.getIntance();
		// mService.getFriendsList(this);

		// listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		// {
		// @Override
		// public void onItemClick(AdapterView<?> arg0, View arg1,
		// int position, long arg3) {
		//
		// FriendModel friend = new FriendModel();
		// friend = friendsList.get(position);
		// Log.v("clicked", friend.getName());
		// Log.v("clicked", friend.getLocation());
		// Log.v("clicked", friend.getState());
		// Log.v("clicked", "" + friend.getLatitude());
		// Log.v("clicked", "" + friend.getLongitude());
		//
		// mainActivity.getLocationInMap(friend.getLongitude(),
		// friend.getLatitude(), friend.getName(),
		// friend.getImageUrl());
		// }
		// });
		Log.v(TAG, "in the friends list fragment");
		return view;
	}

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
