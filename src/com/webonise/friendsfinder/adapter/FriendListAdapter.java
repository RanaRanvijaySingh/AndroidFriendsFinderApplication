package com.webonise.friendsfinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.webonise.friendsfinder.R;

public class FriendListAdapter extends BaseAdapter {

	Context mContext;
	private static final String stringFriendsList[] = { "Friend1", "Friend2",
		"Friend3", "Friend4", "Friend5", "Friend6", "Friend7","Friend8","Friend9","Friend10" };

	public FriendListAdapter(Context mContext) {
		this.mContext= mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return stringFriendsList.length;
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
		LayoutInflater inflater=LayoutInflater.from(mContext);
		convertView=inflater.inflate(R.layout.friend_list_element, null);
		
		TextView textView=(TextView)convertView.findViewById(R.id.friend);
		textView.setText(stringFriendsList[position]);
		
		return convertView;
	}
}
