package com.webonise.friendsfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.Response;
import com.webonise.friendsfinder.adapter.FriendListAdapter;
import com.webonise.friendsfinder.helper.JsonParser;
import com.webonise.friendsfinder.webservice.FacebookService;

public class FriendListFragment extends Fragment {
	MainActivity mainActivity;
	Response mResponse;
	
	private static String TAG = "FriendListFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mainActivity = (MainActivity) this.getActivity();
		View view = inflater.inflate(R.layout.friend_list_fragment, container,
				false);
		
		//new RequestServiceTask().execute();
		
		FacebookService mService =FacebookService.getIntance();
		mService.getFriendsList(this);
		
		JsonParser jsonParser= new JsonParser();
		String stringArrayFriends[]=jsonParser.parseJsonObject(mResponse);
		
		
		ListView listView = (ListView) view.findViewById(R.id.frinds_list);
		FriendListAdapter adapter = new FriendListAdapter(mainActivity);
		listView.setAdapter(adapter);

		return view;
	}

	public void onFriendsListResult(Response response) {
		 mResponse = response;		
	}
	
}
