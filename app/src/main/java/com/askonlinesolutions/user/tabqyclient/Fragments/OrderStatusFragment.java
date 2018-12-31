package com.askonlinesolutions.user.tabqyclient.Fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.trackOrder.TrackOrderActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.ReviewAdapter;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.FragmentOrderBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderStatusFragment extends Fragment implements View.OnClickListener, OrderStatusAdapter.OnItemClickLister, OldOrderStatusAdapter.OnItemClickLister {

    FragmentOrderBinding binding;
    private OrderStatusAdapter orderStatusAdapter;
    OldOrderStatusAdapter oldOrderStatusAdapter;

    private boolean isVisible = true;
    private boolean isShow = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false);
        inIt();
        return binding.getRoot();
    }

    private void inIt() {
        setNewOrderRecyclerView();
        setOldOrderRecyclerView();
        setupTabs();
        binding.showNewOrderIv.setOnClickListener(this);
        binding.showOldOrderIv.setOnClickListener(this);
        binding.newOrderLayout.setOnClickListener(this);
        binding.oldOrderLayout.setOnClickListener(this);
    }

    private void setupTabs() {

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.tableOrderRB.isChecked()) {
//                    binding.radioGroup.setBackground(getResources().getDrawable(R.drawable.rounded_corner_border_primary));
                    binding.tableOrderRB.setTextColor(Color.WHITE);
                    binding.tableOrderRB.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.onlineOrderRb.setBackgroundColor(getResources().getColor(R.color.white_color));
                    binding.onlineOrderRb.setTextColor(getResources().getColor(R.color.light_prime));


                }
                if (binding.onlineOrderRb.isChecked()) {
//                    binding.radioGroup.setBackground(getResources().getDrawable(R.drawable.rounded_corner_border_primary));
                    binding.onlineOrderRb.setTextColor(Color.WHITE);
                    binding.onlineOrderRb.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.tableOrderRB.setBackgroundColor(getResources().getColor(R.color.white_color));
                    binding.tableOrderRB.setTextColor(getResources().getColor(R.color.light_prime));

                }

            }
        });


    }

    private void setOldOrderRecyclerView() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), GridLayoutManager.VERTICAL, false);
        binding.oldOrderRv.setLayoutManager(gridLayoutManager);
        oldOrderStatusAdapter = new OldOrderStatusAdapter(getActivity(), this);
        binding.oldOrderRv.setAdapter(oldOrderStatusAdapter);

    }

    private void setNewOrderRecyclerView() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), GridLayoutManager.VERTICAL, false);
        binding.newOrderRv.setLayoutManager(gridLayoutManager);
        orderStatusAdapter = new OrderStatusAdapter(getActivity(), this);
        binding.newOrderRv.setAdapter(orderStatusAdapter);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.new_order_layout:
                if (isVisible) {
                    binding.newOrderRv.setVisibility(View.GONE);
                    binding.showNewOrderIv.setImageResource(R.drawable.ic_down_arrow_prime);
                    binding.oldOrderRv.setVisibility(View.VISIBLE);
                    binding.showOldOrderIv.setImageResource(R.drawable.ic_up_arrow_prime);
                    isVisible = false;
                } else {
                    binding.newOrderRv.setVisibility(View.VISIBLE);
                    binding.showNewOrderIv.setImageResource(R.drawable.ic_up_arrow_prime);
                    binding.oldOrderRv.setVisibility(View.GONE);
                    binding.showOldOrderIv.setImageResource(R.drawable.ic_down_arrow_prime);
                    isVisible = true;
                }
                break;

            case R.id.old_order_layout:
                if (isShow) {
                    binding.oldOrderRv.setVisibility(View.GONE);
                    binding.showOldOrderIv.setImageResource(R.drawable.ic_down_arrow_prime);
                    binding.newOrderRv.setVisibility(View.VISIBLE);
                    binding.showNewOrderIv.setImageResource(R.drawable.ic_up_arrow_prime);

                    isShow = false;
                } else {
                    binding.oldOrderRv.setVisibility(View.VISIBLE);
                    binding.showOldOrderIv.setImageResource(R.drawable.ic_up_arrow_prime);
//                    binding.newOrderRv.setVisibility(View.GONE);
                    binding.newOrderRv.setVisibility(View.GONE);
                    binding.showNewOrderIv.setImageResource(R.drawable.ic_down_arrow_prime);
                    isShow = true;
                }
                break;
        }
    }

    @Override
    public void onItemClick(int Pos, String type) {

        if (type.equals("CANCELE")) {
            Toast.makeText(getActivity(), type, Toast.LENGTH_SHORT).show();
        } else if (type.equals("TRACK")) {
            Intent intent = new Intent(getContext(), TrackOrderActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            Toast.makeText(getActivity(), type, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "somthing went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
