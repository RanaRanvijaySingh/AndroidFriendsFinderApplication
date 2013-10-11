package com.webonise.friendsfinder.task;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.webonise.friendsfinder.adapter.FriendListAdapter;
import com.webonise.friendsfinder.helper.UrlImageHandler;
import com.webonise.friendsfinder.model.FriendModel;

public class ImageLoaderTask extends AsyncTask<Void, Void, Bitmap> {

	UrlImageHandler urlImage = null;
	FriendListAdapter mContext;
	FriendModel friendModel;

	public ImageLoaderTask(FriendListAdapter context, FriendModel friendModel) {
		friendModel = new FriendModel();
		this.friendModel = friendModel;
		urlImage = UrlImageHandler.getInstance();
		mContext = context;
	}

	@Override
	protected Bitmap doInBackground(Void... params) {
		Bitmap profilePic = urlImage.getUrlImage(friendModel.getImageUrl());
		return profilePic;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		super.onPostExecute(result);
		//mContext.setProfilePic(result);
	}
}
