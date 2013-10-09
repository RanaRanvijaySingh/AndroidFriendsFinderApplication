package com.webonise.friendsfinder;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.facebook.Response;
import com.webonise.friendsfinder.adapter.FriendListAdapter;
import com.webonise.friendsfinder.model.FriendModel;
import com.webonise.friendsfinder.parser.JsonParser;
import com.webonise.friendsfinder.webservice.FacebookService;

@SuppressLint("ValidFragment")
public class FriendListFragment extends Fragment {
	MainActivity mainActivity;
	String stringArrayFriends[];
	ListView listView;
	List<FriendModel> friendsList;
	private static String TAG = "FriendListFragment";

	@SuppressLint("ValidFragment")
	public FriendListFragment(MainActivity mainActivity) {
		this.mainActivity=mainActivity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.friend_list_fragment, container,
				false);
		listView = (ListView) view.findViewById(R.id.frinds_list);

		// new RequestServiceTask().execute();

		FacebookService mService = FacebookService.getIntance();
		mService.getFriendsList(this);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				FriendModel friend = new FriendModel();
				friend = friendsList.get(position);
				Log.v("clicked", friend.getName());
				Log.v("clicked", friend.getLocation());
				Log.v("clicked", friend.getState());
				Log.v("clicked", "" + friend.getLatitude());
				Log.v("clicked", "" + friend.getLongitude());

				mainActivity.getLocationInMap(friend.getLongitude(),
						friend.getLatitude(), friend.getName(),
						friend.getImageUrl());
			}
		});
		return view;
	}

	public void onFriendsListResult(Response response) {
		Response mResponse = response;
		friendsList = new ArrayList<FriendModel>();
		JsonParser jsonParser = new JsonParser();
		// friendsList = new ArrayList<String>();
		friendsList = jsonParser.parseJsonObject(mResponse);
		// Log.v("list", friendsList.get(0).getName());
		callForAdapter();

	}

	private void callForAdapter() {

		FriendListAdapter adapter = new FriendListAdapter(mainActivity,
				friendsList);
		listView.setAdapter(adapter);
	}

}
