package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.ReviewAdapter;
import com.askonlinesolutions.user.tabqyclient.R;


public class ReviewsFragment extends Fragment {

    public ReviewsFragment() {
        // Required empty public constructor
    }
    private ReviewAdapter reviewAdapter;
    RecyclerView reviewRv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.review_item, container, false);
        reviewRv=view.findViewById(R.id.review_rv);
        setupReviewRecycler();
        return view;
    }

    private void setupReviewRecycler() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), GridLayoutManager.VERTICAL, false);
        reviewRv.setLayoutManager(gridLayoutManager);
        reviewAdapter = new ReviewAdapter(getActivity());
        reviewRv.setAdapter(reviewAdapter);

    }


}
