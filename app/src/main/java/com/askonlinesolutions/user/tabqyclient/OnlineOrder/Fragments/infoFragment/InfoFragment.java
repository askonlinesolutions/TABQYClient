package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.infoFragment;


import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.AdapterInfoImage;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent.MenuResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.ResturentList.ResturentResponse;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Utils.Utility;
import com.askonlinesolutions.user.tabqyclient.WebServices.APIClient;
import com.askonlinesolutions.user.tabqyclient.WebServices.OnResponseInterface;
import com.askonlinesolutions.user.tabqyclient.WebServices.ResponseListner;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment implements OnMapReadyCallback, OnResponseInterface {
    GoogleMap mMap;
    //    FloatingActionButton infoAddToCart;
    private String TAG = InfoFragment.class.getName();
    private ArrayList<MenuResponse.DataEntity> dataEntity = new ArrayList<>();

    private int restureni_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getinforesturent(restureni_id);
        getResturentdata();
        init();
    }

    private void getResturentdata() {
  //      int extras = getArguments().getInt("resturentId");
//        if (extras != null) {
//            restureni_id = extras.getInt("resturentId");

        }


    private void getinforesturent(int restureni_id) {
       // new Utility().showProgressDialog(getActivity());
        Call<InfoResponse> infoResponseCall = APIClient.getInstance().getApiInterface().getInfoResturentDetail(4);
        infoResponseCall.request().url();
        Log.d(TAG, "infoResturentList: " + infoResponseCall.request().url());
        new ResponseListner(this).getResponse(infoResponseCall);
    }


    private RecyclerView rv;

    private void init() {
//        infoAddToCart = getView().findViewById(R.id.info_add_cart_fab);
        rv = getView().findViewById(R.id.fragment_info_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(new AdapterInfoImage());
//        infoAddToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mainIntent = new Intent(getActivity(), MainActivity.class);
//                mainIntent.putExtra("key", "AddCart");
//                startActivity(mainIntent);
//            }
//        });
        setMap();
    }

    private void setMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


    }


    @Override
    public void onApiResponse(Object response) {
        if (response != null) {
         //   new Utility().hideDialog();
            InfoResponse infoResponse = (InfoResponse) response;
            if (infoResponse.getData() != null && infoResponse.getData().size()<0) {
                dataEntity = infoResponse.getData();
               // setAdapter();
            }

        }
    }


    @Override
    public void onApiFailure(String message) {

    }
}
