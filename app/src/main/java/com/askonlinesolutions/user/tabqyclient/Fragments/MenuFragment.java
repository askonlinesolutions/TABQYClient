package com.askonlinesolutions.user.tabqyclient.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.Adapters.MenuAdapter;
import com.askonlinesolutions.user.tabqyclient.Model.MenuModel;
import com.askonlinesolutions.user.tabqyclient.Model.OfferModel;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends Fragment
{
   @BindView(R.id.menu_recycler)RecyclerView mRecycler;
   List<MenuModel> mAllMenuList = new ArrayList<>();
    String food_name[] = {"Spring Roll","Veg Roll","Chicken Roll"};
   MenuAdapter mMenuAdapter;
    public MenuFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        ButterKnife.bind(this,view);

        for (int i=0;i<food_name.length;i++)
        {
            mAllMenuList.add(new MenuModel(food_name[i]));
        }

        mMenuAdapter = new MenuAdapter(getContext(),mAllMenuList);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setAdapter(mMenuAdapter);
        return view;
    }






}
