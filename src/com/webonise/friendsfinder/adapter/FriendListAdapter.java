package com.webonise.friendsfinder.adapter;

import java.util.List;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.webonise.friendsfinder.FriendListFragment;
import com.webonise.friendsfinder.R;
import com.webonise.friendsfinder.model.FriendModel;

public class FriendListAdapter extends BaseAdapter {

	FriendListFragment mContext;
	Bitmap profilePic;
	ImageLoader imageLoader;

	private List<FriendModel> friendsList;

	public FriendListAdapter(FriendListFragment mContext,
			List<FriendModel> friendsList) {
		this.mContext = mContext;
		this.friendsList = friendsList;
		imageLoader = ImageLoader.getInstance();
		ImageLoaderConfiguration ilc = ImageLoaderConfiguration
				.createDefault(mContext);
		imageLoader.init(ilc);
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
		TextView location = (TextView) convertView.findViewById(R.id.location);
		TextView state = (TextView) convertView.findViewById(R.id.state);
		ImageView profilImageView = (ImageView) convertView
				.findViewById(R.id.profile_pic);

		name.setText(friendsList.get(position).getName());
		location.setText(friendsList.get(position).getLocation());
		state.setText(" , " + friendsList.get(position).getState());
		imageLoader.displayImage(friendsList.get(position).getImageUrl(),
				profilImageView);

		// uImageHandler=UrlImageHandler.getInstance();
		// Bitmap imageView =
		// uImageHandler.getUrlImage(friendsList.get(position).getImageUrl());
		// ImageView profilImageView = (ImageView)
		// convertView.findViewById(R.id.profile_pic);
		// profilImageView.setImageBitmap(imageView);

		return convertView;
	}
}
