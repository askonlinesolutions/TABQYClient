package com.askonlinesolutions.user.tabqyclient.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.askonlinesolutions.user.tabqyclient.Adapters.OfferAdapter;
import com.askonlinesolutions.user.tabqyclient.Adapters.RestroAdapter;
import com.askonlinesolutions.user.tabqyclient.Model.OfferModel;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfferFragment extends Fragment
{
    private static final String TAG = OfferFragment.class.getSimpleName();
    List<OfferModel>mOfferList = new ArrayList<>();
    RecyclerView mOfferRecycler;
    OfferAdapter mOffer;
    RecyclerView.LayoutManager mManager;
    String food_name[] = {"Spring Roll","Veg Roll","Chicken Roll"};
    public OfferFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rowView=inflater.inflate(R.layout.fragment_offer, null,true);

        mOfferRecycler = rowView.findViewById(R.id.offer_recycler);
        mManager = new LinearLayoutManager(getContext());




        mOfferList.clear();
        for (int i=0;i<food_name.length;i++)
        {
            mOfferList.add(new OfferModel(food_name[i]));
        }
        Log.d(TAG, "onCreateView: " + mOfferList.size());



        mOffer = new OfferAdapter(getContext(),mOfferList);
        mOfferRecycler.setLayoutManager(mManager);
        mOfferRecycler.setAdapter(mOffer);



        return rowView;
    }

}
