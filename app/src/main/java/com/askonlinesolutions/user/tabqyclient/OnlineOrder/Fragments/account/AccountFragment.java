package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.askonlinesolutions.user.tabqyclient.Activities.addAddresss.AddAddressActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceipt.MyReceiptActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceiptsDetails.MyReceiptsDetailsActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.profileSetting.ProfileSettingActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceipt.MyReceiptActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceiptsDetails.MyReceiptsDetailsActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.profileSetting.ProfileSettingActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment implements View.OnClickListener {

    private FragmentAccountBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false);

        initUi();
        return binding.getRoot();

    }

    private void initUi() {
        binding.myPointsTv.setOnClickListener(this);
        binding.profileLayour.setOnClickListener(this);
        binding.prfileSettingTv.setOnClickListener(this);
        binding.profileEditIv.setOnClickListener(this);
        binding.restaurentPointsLayout.setOnClickListener(this);
        binding.tabyqPointLayout.setOnClickListener(this);
        binding.myOrderTv.setOnClickListener(this);
        binding.myOrderBody.setOnClickListener(this);
        binding.addNewTv.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.my_points_tv:
                binding.profileLayour.setVisibility(View.VISIBLE);
                break;
            case R.id.prfile_setting_tv:
                binding.profileLayour.setVisibility(View.GONE);
                break;
            case R.id.tabyq_point_layout:
                Intent intent = new Intent(getActivity(), TabqyPointsActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case R.id.restaurent_points_layout:
                Intent intentRestro = new Intent(getActivity(), RestaurentPointsActivity.class);
                startActivity(intentRestro);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case R.id.profile_edit_iv:
                Intent intentEdit = new Intent(getActivity(), ProfileSettingActivity.class);
                startActivity(intentEdit);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case R.id.my_order_tv:
                Intent intentReceipt = new Intent(getActivity(), MyReceiptActivity.class);
                startActivity(intentReceipt);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case R.id.my_order_body:
                Intent intentDetails = new Intent(getActivity(), MyReceiptsDetailsActivity.class);
                startActivity(intentDetails);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
            case R.id.add_new_tv:
                Intent intentNewAdd = new Intent(getActivity(), AddAddressActivity.class);
                startActivity(intentNewAdd);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

        }

    }
}
