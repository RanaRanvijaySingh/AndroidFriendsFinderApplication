package com.webonise.friendsfinder;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.webonise.friendsfinder.helper.UrlImageHandler;

public class MapFragment extends Fragment {
	private GoogleMap googleMap;
	SupportMapFragment supportMapFragment;
	MainActivity mainActivity;
	View view;

	public MapFragment(MainActivity mainActivity2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mainActivity = (MainActivity) this.getActivity();
		view = null;
		if (view == null) {
			container.removeAllViews();
			view = inflater.inflate(R.layout.map_fragment, container, false);
		}

		 initializeMap();
		// setMarker(55.3,9.9,"Hamburg");
		return view;
	}

	void setMarker(double latitude, double longitude, String name,
			String imageUrl) {
		//initializeMap();
		LatLng position = new LatLng(latitude,longitude);

		//UrlImageHandler uImageHandler = UrlImageHandler.getInstance();
//		Bitmap profilePic = uImageHandler.getUrlImage(imageUrl);

		if(googleMap==null)
		{
			initializeMap();
		}
		Marker location = googleMap.addMarker(new MarkerOptions().visible(true)
				.position(position).snippet(name));

		// Marker kiel = googleMap.addMarker(new MarkerOptions()
		// .position(KIEL)
		// .title("Kiel")
		// .snippet("Keil is cool")
		// .icon(BitmapDescriptorFactory
		// .fromResource(R.drawable.ic_launcher)));

	}

	private void initializeMap() {
		if (googleMap == null) {
			supportMapFragment = ((SupportMapFragment) getFragmentManager()
					.findFragmentById(R.id.map));
			googleMap = supportMapFragment.getMap();
			if (googleMap == null) {
				Toast.makeText(mainActivity, "Sorry the map is not initialize",
						Toast.LENGTH_LONG).show();
			}
		}

	}

	public void onResume() {
		super.onResume();
		initializeMap();
	}

}
