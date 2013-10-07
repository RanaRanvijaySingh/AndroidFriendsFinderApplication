package com.webonise.friendsfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {
	private GoogleMap googleMap;
	MainActivity mainActivity;

	public final LatLng HAMBURG = new LatLng(53.558, 9.927);
	public final LatLng KIEL = new LatLng(53.551, 9.993);

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mainActivity = (MainActivity) this.getActivity();
		View view = inflater.inflate(R.layout.map_fragment, container, false);

		initializeMap();
		setMarker();
		return view;
	}

	private void setMarker() {
		Marker hamburg=googleMap.addMarker(new MarkerOptions().position(HAMBURG).title("Hamburg"));
	}

	private void initializeMap() {
		if (googleMap == null) {
			SupportMapFragment supportMapFragment = ((SupportMapFragment) getFragmentManager()
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
