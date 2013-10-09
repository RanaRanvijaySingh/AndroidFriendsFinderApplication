package com.webonise.friendsfinder.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.facebook.Response;
import com.facebook.model.GraphObject;
import com.webonise.friendsfinder.model.FriendModel;

public class JsonParser {

	private static final String TAG = "JsonParser";

	public List<FriendModel> parseJsonObject(Response response) {

		List<FriendModel> friendModelList = new ArrayList<FriendModel>();
		GraphObject graphObject = response.getGraphObject();
		JSONObject jsonObject = graphObject.getInnerJSONObject();
		// JSONObject jsonObject = new JSONObject();
		try {
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				FriendModel friendModel = new FriendModel();
				friendModel.setName(jsonArray.getJSONObject(i)
						.getString("name"));
				friendModel.setImageUrl(jsonArray.getJSONObject(i).getString(
						"pic_square"));
				try {
					JSONObject currentLocation = jsonArray.getJSONObject(i)
							.getJSONObject("current_location");
					friendModel.setState(currentLocation.getString("state"));
					friendModel.setLongitude(currentLocation
							.getDouble("longitude"));
					friendModel.setLatitude(currentLocation
							.getDouble("latitude"));
					friendModel.setLocation(currentLocation.getString("city"));
				} catch (Exception currentLocation) {
				}
				friendModelList.add(friendModel);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return friendModelList;
	}

}
