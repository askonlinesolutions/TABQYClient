package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.ReviewAdapter;
import com.askonlinesolutions.user.tabqyclient.R;


public class ReviewsFragment extends Fragment {
//ReviewItemBinding binding;

    private ReviewAdapter reviewAdapter;
    RecyclerView reviewRv;
    FloatingActionButton AddCartFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.review_item, container, false);
        reviewRv=view.findViewById(R.id.review_rv);
        AddCartFab=view.findViewById(R.id.review_add_cart_fab);

        init();
        return view;
    }

    private void init() {
        setupReviewRecycler();
        AddCartFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent=new Intent(getActivity(), MainActivity.class);
                mainIntent.putExtra("key","AddCart");
                startActivity(mainIntent);
            }
        });

    }

    private void setupReviewRecycler() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), GridLayoutManager.VERTICAL, false);
        reviewRv.setLayoutManager(gridLayoutManager);
        reviewAdapter = new ReviewAdapter(getActivity());
        reviewRv.setAdapter(reviewAdapter);

    }


}
