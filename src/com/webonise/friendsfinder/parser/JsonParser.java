package com.webonise.friendsfinder.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.facebook.Response;
import com.facebook.model.GraphObject;

public class JsonParser {

	public String[] parseJsonObject(Response response) {

		String stringArray[] = null;
		// Log.v("json", response.getGraphObjectAs(new GraphObject));
		GraphObject graphObject = response.getGraphObject();
		JSONObject jsonObject = graphObject.getInnerJSONObject();

		try {
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			stringArray = new String[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				stringArray[i] = new String();
				stringArray[i] = jsonArray.getJSONObject(i).getString("name");

				Log.v("json", i + " " + stringArray[i]);

			}
			// String jsonName=jsonArray.getJSONObject(0).getString("name");

			// Log.v("json", jsonName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringArray;
	}

}
