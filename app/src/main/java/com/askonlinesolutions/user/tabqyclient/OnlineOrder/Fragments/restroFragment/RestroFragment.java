package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.filter.FilterActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.searchResturent.SearchActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.ChooseCuisine;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.detail_id.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.ResturentList.ResturentResponse;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.servise.GPSTracker;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Utils.Utility;
import com.askonlinesolutions.user.tabqyclient.WebServices.APIClient;
import com.askonlinesolutions.user.tabqyclient.WebServices.OnResponseInterface;
import com.askonlinesolutions.user.tabqyclient.WebServices.ResponseListner;

import java.util.List;

import retrofit2.Call;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestroFragment extends Fragment implements View.OnClickListener, OnResponseInterface, AdapterRestaurantList.Interface_AdapterRestaurant {
    GPSTracker gps;
    //    RestroAdapter mRestro;
//    LinearLayout mCusisne;
    LinearLayout filter, mCusisne, mSearch;
    private int Resturant_Id;
    private String TAG = MainActivity.class.getName();
    private List<ResturentResponse.DataEntity> dataEntity;

    double latitude;
    double longitude;
    //   private static final String TAG = RestroFragment.class.getSimpleName();

    public RestroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rowView = inflater.inflate(R.layout.fragment_restro, null, true);

//        ListView mRecycler = rowView.findViewById(R.id.restro_recycler);
        mCusisne = rowView.findViewById(R.id.cuisine_layout);
        mSearch = rowView.findViewById(R.id.search_layout);

//        mCusisne.setOnClickListener(this);
//
//        mRestroList.clear();
//        mRestroList.add("Dao Xiang Restaurant");
//        mRestroList.add("Dao Xiang Restaurant");
//        mRestroList.add("Dao Xiang Restaurant");
//        mRestro = new RestroAdapter(getContext(),R.layout.restro_item_layout,mRestroList);
//
//        mRecycler.setAdapter(mRestro);
//
//        mRecycler.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                startActivity(new Intent(getContext(), DetailActivity.class));
//            }
//        });
        gps = new GPSTracker(getActivity());
        // check if GPS enabled
        if (gps.canGetLocation()) {
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            // \n is for new line
            Toast.makeText(getActivity(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

        return rowView;
    }

//    private void callrestroapi() {
//        RestroRequest restroRequest =new RestroRequest();
//        restroRequest.setLattitude(latitude);
//        restroRequest.setLongitude(longitude);
//        Call<RestroResponse> call = APIClient.getInstance().getApiInterface().doRestro(restroRequest);
//        call.request().url();
//        Log.d(TAG, "doRestro: " + call.request().url());
//        new ResponseListner(this).getResponse(call);
//    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        callrestroapi();
        init();
        getResturentList();
    }

    private void getResturentList() {
        new Utility().showProgressDialog(getContext());
        Call<ResturentResponse> resturentResponseCall = APIClient.getInstance().getApiInterface().getResturentList(latitude,longitude);
        resturentResponseCall.request().url();
        Log.d(TAG, "ResturentList: " + resturentResponseCall.request().url());
        new ResponseListner(this).getResponse(resturentResponseCall);
    }

    ResturentResponse resturentResponse;
    private RecyclerView rv;

    private void init() {

        rv = getView().findViewById(R.id.fragment_restaurant_list_rv);
        filter = getView().findViewById(R.id.filter_layout);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv.setAdapter(new AdapterRestaurantList(getActivity(),dataEntity,this));

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent filterIntent = new Intent(getActivity(), FilterActivity.class);
                startActivity(filterIntent);
                getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });

        mCusisne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent filterIntent = new Intent(getActivity(), ChooseCuisine.class);
                startActivity(filterIntent);
                getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent filterIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(filterIntent);
                getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });
    }

    @Override
    public void onClick(View v) {
//        if (v==mCusisne)
//        {
//           startActivity(new Intent(getContext(), ChooseCuisine.class));
//        }
    }

    @Override
    public void method_AdapterRestaurant(int pos, int restureni_id) {

        if (pos >= 0) {
            Intent intent = new Intent(getContext(),DetailActivity.class);
            intent.putExtra("resturentId", restureni_id);

            startActivity(intent);
//            startActivity(new Intent(getContext(), DetailActivity.class));

            getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

//    @Override
//    public void onItemClick(int Pos, String type) {
//
//    }

//    @Override
//    public void onApiResponse(Object response) {
//        if (response != null) {
//            ResturentResponse resturentResponse = (ResturentResponse) response;
//            if (resturentResponse.getData() != null && resturentResponse.getData().size() > 0) {
//                dataEntity = resturentResponse.getData();
//                setAdapter();
//            }
//
//        } else {
//            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void setAdapter() {
//        AdapterRestaurantList adapterRestaurantList = new AdapterRestaurantList(this, dataEntity);
//        rv.setAdapter(adapterRestaurantList);
//
//    }

    @Override
    public void onApiResponse(Object response) {
        if (response != null) {
            new Utility().hideDialog();
            ResturentResponse resturentResponse = (ResturentResponse) response;
            if (resturentResponse.getData() != null && resturentResponse.getData().size() > 0) {
                dataEntity = resturentResponse.getData();

                setAdapter();
            }

        } else {
            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
        }
    }

    private void setAdapter() {
        AdapterRestaurantList adapterRestaurantList = new AdapterRestaurantList(getActivity(), dataEntity, this);
        rv.setAdapter(adapterRestaurantList);

    }


    @Override
    public void onApiFailure(String message) {

    }
}


