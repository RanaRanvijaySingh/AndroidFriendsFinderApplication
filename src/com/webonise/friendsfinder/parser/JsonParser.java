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

	private static final String TAG="JsonParser";
	public List<FriendModel> parseJsonObject(Response response) {

		List<FriendModel> friendModelList = new ArrayList<FriendModel>();

		// String stringArray[] = null;
		//
		// Log.v("json", response.getGraphObjectAs(new GraphObject));
		GraphObject graphObject = response.getGraphObject();
		JSONObject jsonObject = graphObject.getInnerJSONObject();

		try {
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			// stringArray = new String[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				// stringArray[i] = new String();
				// stringArray[i] =
				// jsonArray.getJSONObject(i).getString("name");

				FriendModel friendModel = new FriendModel();
				friendModel.setName(jsonArray.getJSONObject(i)
						.getString("name"));
				friendModel.setImageUrl(jsonArray.getJSONObject(i).getString(
						"pic_square"));
				try {
					JSONObject currentLocation = jsonArray.getJSONObject(i)
							.getJSONObject("current_location");
					friendModel.setState(currentLocation.getString("state"));
					friendModel.setLongitude(currentLocation.getInt("longitude"));
					friendModel.setLatitude(currentLocation.getInt("latitude"));
					friendModel.setLocation(currentLocation.getString("city"));
				} catch (Exception currentLocation) {
					Log.d(TAG,"current_location is null");
				}
				// Log.v("json", i+" "+friendModel.getName());
				friendModelList.add(friendModel);
			}
			// String jsonName=jsonArray.getJSONObject(0).getString("name");

			// Log.v("json", jsonName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friendModelList;
	}

}
