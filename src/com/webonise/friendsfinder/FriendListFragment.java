package com.webonise.friendsfinder;

import java.util.ArrayList;
import java.util.List;

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
import com.webonise.friendsfinder.webservice.FacebookService;

public class FriendListFragment extends Fragment {
	MainActivity mainActivity;
	String stringArrayFriends[];
	ListView listView;
	List<FriendModel> friendsList;
	private static String TAG = "FriendListFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mainActivity = (MainActivity) this.getActivity();
		View view = inflater.inflate(R.layout.friend_list_fragment, container,
				false);
		listView = (ListView) view.findViewById(R.id.frinds_list);

		// new RequestServiceTask().execute();

		FacebookService mService = FacebookService.getIntance();
		mService.getFriendsList(this);

		return view;
	}

	public void onFriendsListResult(Response response) {
		Response mResponse = response;
		friendsList=new ArrayList<FriendModel>();
		JsonParser jsonParser = new JsonParser();
		//friendsList = new ArrayList<String>();
		friendsList = jsonParser.parseJsonObject(mResponse);
		//Log.v("list", friendsList.get(0).getName());
		callForAdapter();

	}

	private void callForAdapter() {
		
//		for (int i = 0; i < friendsList.size(); i++)
//			Log.e(null, friendsList.get(i).getName());

		FriendListAdapter adapter = new FriendListAdapter(mainActivity,friendsList);
		listView.setAdapter(adapter);
	}

}
