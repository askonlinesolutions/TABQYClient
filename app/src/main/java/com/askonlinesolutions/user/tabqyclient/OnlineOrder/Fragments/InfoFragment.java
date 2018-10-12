package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.AdapterInfoImage;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment
{
/*
    private static final String TAG = InfoFragment.class.getSimpleName();
   @BindView(R.id.info_recycler) RecyclerView mRestrorecycler;
//   RestroImageAdapter mAdapter;
   int image[] = {R.drawable.rest1,R.drawable.rest2,R.drawable.rest3,R.drawable.rest4,R.drawable.rest5};
   List<int[]> mAllimage = new ArrayList<>();

*/
    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_info, container, false);
//        ButterKnife.bind(this,view);

//        for (int i=0;i<image.length;i++)
//        {
//            mAllimage.add(image);
//        }
//        Log.d(TAG, "onCreateView: " + "List Size " + mAllimage.size());
//        mRestrorecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,true));
//        mAdapter = new RestroImageAdapter(getContext(),mAllimage);
//        mRestrorecycler.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv;
    private void init(){

        rv = getView().findViewById(R.id.fragment_info_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(new AdapterInfoImage());

    }
}
