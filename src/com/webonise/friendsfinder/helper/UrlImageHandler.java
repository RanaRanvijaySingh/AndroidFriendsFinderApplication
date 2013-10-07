package com.webonise.friendsfinder.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class UrlImageHandler {
	private static UrlImageHandler imageHandler=new UrlImageHandler();
	private UrlImageHandler()
	{
		
	}
	public static UrlImageHandler getInstance()
	{
		return imageHandler;
	}
	
	public Bitmap getUrlImage(String stringImageUrl) {
		BitmapFactory.Options bmOptions;
		bmOptions = new BitmapFactory.Options();
		bmOptions.inSampleSize = 1;
		Bitmap bitmapImage = LoadImage(stringImageUrl, bmOptions);
		return bitmapImage;
	}

	private Bitmap LoadImage(String stringUrl, BitmapFactory.Options mOptions) {
		Bitmap bitmapImage = null;
		InputStream inputStream = null;
		try {
			inputStream = OpenHttpConnection(stringUrl);
			bitmapImage = BitmapFactory.decodeStream(inputStream, null, mOptions);
			inputStream.close();
		} catch (IOException e1) {
		}
		return bitmapImage;
	}

	private InputStream OpenHttpConnection(String stringUrl) throws IOException {
		InputStream inputStream = null;
		URL url = new URL(stringUrl);
		URLConnection connection = url.openConnection();

		try {
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			httpConn.setRequestMethod("GET");
			httpConn.connect();

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				inputStream = httpConn.getInputStream();
			}
		} catch (Exception ex) {
		}
		return inputStream;
	}

}