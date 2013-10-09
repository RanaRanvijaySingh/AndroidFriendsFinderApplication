package com.webonise.friendsfinder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

@SuppressLint("ValidFragment")
public class MapFragment extends FragmentActivity implements OnClickListener {

	// private GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.map_fragment);
		initializeComponents();
		// initializeMap();
	}

	@SuppressLint("ResourceAsColor")
	private void initializeComponents() {
		Button buttonFriends = (Button) findViewById(R.id.button_friends);
		Button buttonMap = (Button) findViewById(R.id.button_map);
		buttonMap.setClickable(false);
		buttonFriends.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Log.v(null, "friends clicked");
		Intent intent = new Intent(this, FriendListFragment.class);
		startActivity(intent);
	}
	// private void initializeMap() {
	// if (googleMap == null) {
	// SupportMapFragment supportMapFragment =(SupportMapFragment)
	// getSupportFragmentManager().findFragmentById(R.id.map);
	// googleMap = supportMapFragment.getMap();
	// if (googleMap == null) {
	// Toast.makeText(this, "Sorry the map is not initialize",
	// Toast.LENGTH_LONG).show();
	// }
	// }
	// Log.v(null, "Starting Google Map");
	// }

	//
	// void setMarker(double latitude, double longitude, String name,
	// String imageUrl) {
	// // initializeMap();
	// LatLng position = new LatLng(latitude, longitude);
	// // UrlImageHandler uImageHandler = UrlImageHandler.getInstance();
	// // Bitmap profilePic = uImageHandler.getUrlImage(imageUrl);
	// if (googleMap == null) {
	// initializeMap();
	// }
	// Marker location = googleMap.addMarker(new MarkerOptions().visible(true)
	// .position(position).snippet(name));
	// // Marker kiel = googleMap.addMarker(new MarkerOptions()
	// // .position(KIEL)
	// // .title("Kiel")
	// // .snippet("Keil is cool")
	// // .icon(BitmapDescriptorFactory
	// // .fromResource(R.drawable.ic_launcher)));
	// }

	// @Override
	// public void onResume() {
	//
	// super.onResume();
	// initializeMap();
	// }
}
