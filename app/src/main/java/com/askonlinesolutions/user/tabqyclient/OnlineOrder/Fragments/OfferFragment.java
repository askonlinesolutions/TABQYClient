package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.AdapterOfferList;
import com.askonlinesolutions.user.tabqyclient.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfferFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rowView=inflater.inflate(R.layout.fragment_offer, null,true);

//        mOfferRecycler = rowView.findViewById(R.id.offer_recycler);
//        mManager = new LinearLayoutManager(getContext());




//        mOfferList.clear();
//        for (int i=0;i<food_name.length;i++)
//        {
//            mOfferList.add(new OfferModel(food_name[i]));
//        }
//        Log.d(TAG, "onCreateView: " + mOfferList.size());



//        mOffer = new OfferAdapter(getContext(),mOfferList);
//        mOfferRecycler.setLayoutManager(mManager);
//        mOfferRecycler.setAdapter(mOffer);



        return rowView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv;

    private void init(){

        rv = getView().findViewById(R.id.fragment_offer_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new AdapterOfferList());
    }
}
