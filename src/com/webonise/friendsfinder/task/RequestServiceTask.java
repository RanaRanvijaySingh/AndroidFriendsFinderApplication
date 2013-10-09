package com.webonise.friendsfinder.task;

import com.facebook.Response;
import com.webonise.friendsfinder.webservice.FacebookService;

import android.os.AsyncTask;

public class RequestServiceTask extends AsyncTask<Void, Void, Response> {

	@Override
	protected void onPostExecute(Response result) {
		super.onPostExecute(result);
	}

	@Override
	protected Response doInBackground(Void... params) {
		Response response = null;
		FacebookService mService = FacebookService.getIntance();
	//	response=mService.getFriendsList();
		return response;
	}
}
