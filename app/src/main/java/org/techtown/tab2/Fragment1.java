package org.techtown.tab2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.ContentValues.TAG;

public class Fragment1 extends Fragment
        implements OnMapReadyCallback {
    View rootView;
    MapView mapView;

    public Fragment1() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment1,container,false);
        mapView = (MapView) rootView.findViewById(R.id.fragment_main_mv);

        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop () {
        super.onStop();
        mapView.onStop();

    }

    @Override
    public void onSaveInstanceState (@Nullable Bundle outState){
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //마커찍기(위도,경도)
        LatLng solnae = new LatLng(35.869253, 127.129006);

        //마커 옵션
        MarkerOptions marker = new MarkerOptions();
        marker.position(solnae); //마커 위치
        marker.title("솔내청소년수련관");
        marker.snippet("전주시 덕진구 송천1동 동부대로 1079");

        //맵에 마커표시, 인포윈도우 보여줌
        googleMap.addMarker(marker).showInfoWindow();

        //인포윈도우 클릭
        //googleMap.setOnInfoWindowClickListener(this);

        //맵뷰 카메라위치, 줌 설정
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(solnae, 13));
    }
    }

