package com.askonlinesolutions.user.tabqyclient;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Adapters.MenuAdapter;
import com.askonlinesolutions.user.tabqyclient.Model.MenuModel;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.Reservation.Activity.Thankyou;
import com.askonlinesolutions.user.tabqyclient.databinding.FragmentTableMyCartBinding;
import com.askonlinesolutions.user.tabqyclient.tableCode.menuList.MenuItemActivity;

import java.util.ArrayList;
import java.util.List;


public class TableMyCartFragment extends Fragment implements MenuAdapter.Interface_AdapterMenu {

    FragmentTableMyCartBinding binding;
    private boolean isVisible = true;
    private boolean isShow = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_table_my_cart, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private RecyclerView rv_cart;
    TextView request_btn, no_btn, yes_btn, play_btn, detail_btn;
    ImageView btncross;
    LinearLayout press_yes;
    RelativeLayout dialog_yes;
    private List<MenuModel> mAllMenuList = new ArrayList<>();
    private String food_name[] = {"Spring Roll", "Spring Roll"};
    private MenuAdapter mMenuAdapter;


    private void init() {
        for (int i = 0; i < food_name.length; i++) {
            mAllMenuList.add(new MenuModel(food_name[i]));
        }

        rv_cart = getView().findViewById(R.id.activity_my_cart_recycler);
        request_btn = getView().findViewById(R.id.request_btn);
        detail_btn = getView().findViewById(R.id.detail_btn);

        rv_cart.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_cart.setAdapter(new MenuAdapter(getContext(), mAllMenuList, this));
        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuItemActivity.class);
//
                startActivity(intent);
            }
        });

        request_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

    }

    @Override
    public void click_AdapterMenu(int position) {
        if (position >= 0) {
            startActivity(new Intent(getContext(), ItemsDetailActivity.class));
            getActivity().overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        }
    }


    @Override
    public void click_AdapterMenu_Plus(int position) {
        if (position >= 0) {

        }
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.request_bill);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btncross = (ImageView) dialog.findViewById(R.id.close_img);
        no_btn = dialog.findViewById(R.id.no_btn);
        yes_btn = dialog.findViewById(R.id.yes_btn);
        press_yes = dialog.findViewById(R.id.press_yes);
        dialog_yes = dialog.findViewById(R.id.dialog_yes);
        play_btn = dialog.findViewById(R.id.play_btn);
        btncross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });
        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Thankyou.class);
                startActivity(intent);
            }
        });
        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                press_yes.setVisibility(View.VISIBLE);
                dialog_yes.setVisibility(View.GONE);

            }
        });
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Thankyou.class);
                startActivity(intent);
            }
        });

    }

}




