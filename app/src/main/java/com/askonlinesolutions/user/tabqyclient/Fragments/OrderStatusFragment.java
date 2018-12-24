package com.askonlinesolutions.user.tabqyclient.Fragments;


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

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.ReviewAdapter;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.FragmentOrderBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderStatusFragment extends Fragment implements View.OnClickListener {

    FragmentOrderBinding binding;
    private OrderStatusAdapter orderStatusAdapter;

    private boolean isVisible = true;
    private boolean isShow = true;

    public OrderStatusFragment() {
        // Required empty public constructor
    }


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
        orderStatusAdapter = new OrderStatusAdapter(getActivity());
        binding.oldOrderRv.setAdapter(orderStatusAdapter);

    }

    private void setNewOrderRecyclerView() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), GridLayoutManager.VERTICAL, false);
        binding.newOrderRv.setLayoutManager(gridLayoutManager);
        orderStatusAdapter = new OrderStatusAdapter(getActivity());
        binding.newOrderRv.setAdapter(orderStatusAdapter);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_new_order_iv:
                if (isVisible) {
                    binding.newOrderRv.setVisibility(View.GONE);
                    binding.showNewOrderIv.setImageResource(R.drawable.ic_down_arrow_prime);
                    isVisible = false;
                } else {
                    binding.newOrderRv.setVisibility(View.VISIBLE);
                        binding.showNewOrderIv.setImageResource(R.drawable.ic_up_arrow_prime);
                    isVisible = true;
                }
                break;

            case R.id.show_old_order_iv:
                if (isShow) {
                    binding.oldOrderRv.setVisibility(View.GONE);
                    binding.showOldOrderIv.setImageResource(R.drawable.ic_down_arrow_prime);
//                    binding.newOrderRv.setVisibility(View.VISIBLE);
                    isShow = false;
                } else {
                    binding.oldOrderRv.setVisibility(View.VISIBLE);
                    binding.showOldOrderIv.setImageResource(R.drawable.ic_up_arrow_prime);
//                    binding.newOrderRv.setVisibility(View.GONE);
                    isShow = true;
                }
                break;

        }
    }
}
