package com.askonlinesolutions.user.tabqyclient.tableCode.menuDashboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.tableCode.menuList.MenuItemActivity;

public class MenuDashboardFragment extends Fragment {

    LinearLayout menuBtn;

    //    private FragmentMenuDashboardBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_dashboard, container, false);
        menuBtn = view.findViewById(R.id.menu_btn);
        init();

        return view;
    }

    private void init() {
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuItemActivity.class);
//            intent.putExtra("key","receipt");

                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }

}
