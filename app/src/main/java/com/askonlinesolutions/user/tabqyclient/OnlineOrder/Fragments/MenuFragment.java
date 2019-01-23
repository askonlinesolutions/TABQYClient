package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent.MainManuAdapter;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.menuResturent.MenuResponse;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Utils.Utility;
import com.askonlinesolutions.user.tabqyclient.WebServices.APIClient;
import com.askonlinesolutions.user.tabqyclient.WebServices.OnResponseInterface;
import com.askonlinesolutions.user.tabqyclient.WebServices.ResponseListner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MenuFragment extends Fragment implements MainManuAdapter.OnItemClickLister, OnResponseInterface {
    @BindView(R.id.menu_recycler)
    RecyclerView mRecycler;
    //    @BindView(R.id.menu_add_cart_fab)
//    FloatingActionButton addToCart;
    TextView addBtn;
    private String TAG = MenuFragment.class.getName();

    MainManuAdapter menuadapter;
    //   List<MenuModel> mAllMenuList = new ArrayList<>();
//    String food_name[] = {"Spring Roll","Veg Roll","Chicken Roll"};
//   MenuAdapter mMenuAdapter;
    ImageView crossTv;
    private ArrayList<MenuResponse.DataEntity> dataEntity = new ArrayList<>();


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

    private void menudetail() {
       // new Utility().showProgressDialog(getActivity());
        Call<MenuResponse> menuResponseCall = APIClient.getInstance().getApiInterface().getMenuDetail(60);
        menuResponseCall.request().url();
        Log.d(TAG, "getMenu: " + menuResponseCall.request().url());
        new ResponseListner(this).getResponse(menuResponseCall);


    }

    private void init() {
        setRestaurentPointsRecyclerView();
        menudetail();
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
//        mainManuAdapter = new MainManuAdapter(getContext(), this);
//        mRecycler.setAdapter(mainManuAdapter);

    }


    @Override
    public void click_AdapterMenu(int position) {

        if (position >= 0) {
            startActivity(new Intent(getContext(), ItemsDetailActivity.class));
            getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        }
    }

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


//    @Override
//    public void OnItemClickLister(int Pos, String type) {
////
////        if (type.equals("MENU")) {
////            Intent intent = new Intent(getActivity(), ItemsDetailActivity.class);
////            startActivity(intent);
////            getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
////        } else if (type.equals("ADD")) {
////            showAddInfoDialog();
////        } else {
////
////        }
//
//    }

    private void showAddInfoDialog() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_item);

        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        crossTv = dialog.findViewById(R.id.dialog_add_more_item_cross);
        addBtn = dialog.findViewById(R.id.add_btn_tv);

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


    @Override
    public void onApiResponse(Object response) {

        if (response != null) {
            //new Utility().hideDialog();
            MenuResponse menuResponse = (MenuResponse) response;
            if (menuResponse.getData() != null && menuResponse.getData().size() > 0) {
                dataEntity.addAll(menuResponse.getData());
                setAdapter();
            }

        } else {
            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
        }
    }

    private void setAdapter() {
        menuadapter = new MainManuAdapter(getActivity(), dataEntity, this);
        mRecycler.setAdapter(menuadapter);

    }

    @Override
    public void onApiFailure(String message) {

    }

//    @Override
//    public void method_AdapterMenu(int pos) {
//
//        }
//}
}