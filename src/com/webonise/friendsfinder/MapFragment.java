package com.webonise.friendsfinder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

@SuppressLint("ValidFragment")
public class MapFragment extends FragmentActivity implements OnClickListener {

	private GoogleMap googleMap;
	String stringName;
	Double doubleLongitude;
	Double doubleLatitude;
	String stringLocation;
	String stringImageUrl;
	private ImageLoader imageLoader;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.map_fragment);

		imageLoader = ImageLoader.getInstance();
		ImageLoaderConfiguration ilc = ImageLoaderConfiguration
				.createDefault(this);
		imageLoader.init(ilc);

		initializeComponents();
		initializeMap();
	}

	private void initializeMap() {
		if (googleMap == null) {
			SupportMapFragment supportMapFragment = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map));
			googleMap = supportMapFragment.getMap();

			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry the map is not initialize", Toast.LENGTH_LONG)
						.show();
			}
		}
		if (getIntent().hasExtra("name")) {
			setMarkerValues();
			setMarker();
		}
	}

	public void setMarker() {

		View view = LayoutInflater.from(this).inflate(R.layout.friend_info,
				null);
		ImageView imageView = (ImageView) view.findViewById(R.id.friend_pic);
		imageLoader.displayImage(stringImageUrl, imageView);
		Log.v("image", imageView.toString());

		Drawable drawble = imageView.getDrawable();
		Log.v(null, drawble.toString());
		// BitmapDescriptor icon=
		// BitmapDescriptorFactory.fromBitmap(((BitmapDrawable)drawble).getBitmap());

		LatLng position = new LatLng(doubleLatitude, doubleLongitude);
		Marker location = googleMap.addMarker(new MarkerOptions().visible(true)
				.title(stringName).position(position));
		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(position).zoom(12).build();
		googleMap.animateCamera(CameraUpdateFactory
				.newCameraPosition(cameraPosition));
	}

	private void setMarkerValues() {
		Intent intent = getIntent();
		stringName = intent.getStringExtra("name");
		doubleLongitude = intent.getDoubleExtra("longitude", 73.86);
		doubleLatitude = intent.getDoubleExtra("latitude", 18.53);
		stringLocation = intent.getStringExtra("location");
		stringImageUrl = intent.getStringExtra("imageUrl");
		Log.v("map", stringName + " " + stringLocation + " " + doubleLatitude
				+ " " + doubleLongitude + " " + stringImageUrl);
	}

	private void initializeComponents() {
		Button buttonFriends = (Button) findViewById(R.id.button_friends);
		Button buttonMap = (Button) findViewById(R.id.button_map);
		Button buttonNormal = (Button) findViewById(R.id.normal);
		Button buttonSatellite = (Button) findViewById(R.id.satellite);
		Button buttonTerrain = (Button) findViewById(R.id.terrain);
		Button buttonHybrid = (Button) findViewById(R.id.hybrid);

		buttonMap.setClickable(false);

		buttonFriends.setOnClickListener(this);
		buttonNormal.setOnClickListener(this);
		buttonTerrain.setOnClickListener(this);
		buttonSatellite.setOnClickListener(this);
		buttonHybrid.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.normal:
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			break;
		case R.id.hybrid:
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			break;
		case R.id.terrain:
			googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			break;
		case R.id.satellite:
			googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			break;
		case R.id.button_friends:
			Log.v(null, "friends clicked");
			Intent intent = new Intent(this, FriendListFragment.class);
			startActivity(intent);
		default:
			break;
		}

	}
}
