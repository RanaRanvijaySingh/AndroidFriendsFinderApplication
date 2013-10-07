package com.webonise.friendsfinder.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.webonise.friendsfinder.R;
import com.webonise.friendsfinder.model.FriendModel;

public class FriendListAdapter extends BaseAdapter {

	Context mContext;
	private List<FriendModel> friendsList;

	public FriendListAdapter(Context mContext, List<FriendModel> friendsList) {
		this.mContext = mContext;
		this.friendsList = new ArrayList<FriendModel>();
		this.friendsList = friendsList;
//		for (int i = 0; i < this.friendsList.size(); i++)
//			Log.e(null, friendsList.get(i).getName());

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return friendsList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(mContext);
		convertView = inflater.inflate(R.layout.friend_list_element, null);

		TextView textView = (TextView) convertView.findViewById(R.id.friend);
		textView.setText(friendsList.get(position).getName());

		return convertView;
	}
}
