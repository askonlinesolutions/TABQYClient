package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.Adapters.MenuAdapter;
import com.askonlinesolutions.user.tabqyclient.Model.MenuModel;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.manu.MainManuAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends Fragment implements MainManuAdapter.OnItemClickLister {
    @BindView(R.id.menu_recycler)
    RecyclerView mRecycler;
//    @BindView(R.id.menu_add_cart_fab)
//    FloatingActionButton addToCart;
    TextView addBtn;
    //   List<MenuModel> mAllMenuList = new ArrayList<>();
//    String food_name[] = {"Spring Roll","Veg Roll","Chicken Roll"};
//   MenuAdapter mMenuAdapter;
    ImageView crossTv;
    MainManuAdapter mainManuAdapter;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_fragment, container, false);
        ButterKnife.bind(this, view);


        init();
        return view;
    }

    private void init() {
        setRestaurentPointsRecyclerView();

//        addToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mainIntent = new Intent(getActivity(), MainActivity.class);
//                mainIntent.putExtra("key", "AddCart");
//                startActivity(mainIntent);
//            }
//        });
    }

    private void setRestaurentPointsRecyclerView() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(gridLayoutManager);
        mainManuAdapter = new MainManuAdapter(getContext(), this);
        mRecycler.setAdapter(mainManuAdapter);

    }


//    @Override
//    public void click_AdapterMenu(int position) {
//
//        if(position>=0){
//            startActivity(new Intent(getContext(), ItemsDetailActivity.class));
//            getActivity().overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
//        }
//    }


    @Override
    public void onItemClick(int Pos, String type) {

        if (type.equals("MENU")) {
            Intent intent = new Intent(getActivity(), ItemsDetailActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        } else if (type.equals("ADD")) {
            showAddInfoDialog();
        } else {

        }

    }

    private void showAddInfoDialog() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_item);
        dialog.setTitle("Loading...");
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        crossTv = dialog.findViewById(R.id.dialog_add_more_item_cross);
        addBtn=dialog.findViewById(R.id.add_btn_tv);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        crossTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }


}