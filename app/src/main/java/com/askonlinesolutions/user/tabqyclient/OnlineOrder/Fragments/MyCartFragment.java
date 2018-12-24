package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.CheckoutActivity;
import com.askonlinesolutions.user.tabqyclient.Adapters.MenuAdapter;
import com.askonlinesolutions.user.tabqyclient.Checkout_cardActivity;
import com.askonlinesolutions.user.tabqyclient.Model.MenuModel;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment implements MenuAdapter.Interface_AdapterMenu{
 TextView checkout;

    public MyCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_cart, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv_cart;
    private List<MenuModel> mAllMenuList = new ArrayList<>();
    private String food_name[] = {"Spring Roll","Spring Roll"};
    private MenuAdapter mMenuAdapter;

    private void init(){
        for (int i=0;i<food_name.length;i++) {
            mAllMenuList.add(new MenuModel(food_name[i]));
        }

        rv_cart = getView().findViewById(R.id.activity_my_cart_recycler);
        checkout =getView().findViewById(R.id.checkout_btn);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Checkout_cardActivity.class);
                startActivity(intent);

            }
        });
        rv_cart.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_cart.setAdapter(new MenuAdapter(getContext(), mAllMenuList, this));

    }

    @Override
    public void click_AdapterMenu(int position) {
        if(position>=0){
            startActivity(new Intent(getContext(), ItemsDetailActivity.class));
            getActivity().overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
        }
    }

    @Override
    public void click_AdapterMenu_Plus(int position) {

        if(position >=0){

        }
    }


}