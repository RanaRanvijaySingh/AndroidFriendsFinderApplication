package com.webonise.friendsfinder.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.internal.p;
import com.webonise.friendsfinder.R;
import com.webonise.friendsfinder.helper.UrlImageHandler;
import com.webonise.friendsfinder.model.FriendModel;
import com.webonise.friendsfinder.task.ImageLoaderTask;

public class FriendListAdapter extends BaseAdapter {

	Context mContext;
	Bitmap profilePic;
	
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

		TextView name = (TextView) convertView.findViewById(R.id.friend);
		name.setText(friendsList.get(position).getName());
		
		TextView location = (TextView) convertView.findViewById(R.id.location);
		location.setText(friendsList.get(position).getLocation());
		
		TextView state = (TextView) convertView.findViewById(R.id.state);
		state.setText(" , "+ friendsList.get(position).getState());
		
		
		ImageLoaderTask iLoaderTask=new ImageLoaderTask(this,friendsList.get(position));
		iLoaderTask.execute();
		ImageView profilImageView=(ImageView)convertView.findViewById(R.id.profile_pic);
		profilImageView.setImageBitmap(profilePic);

		return convertView;
	}

	public void setProfilePic(Bitmap result) {
		profilePic=result;
		
	}
}
