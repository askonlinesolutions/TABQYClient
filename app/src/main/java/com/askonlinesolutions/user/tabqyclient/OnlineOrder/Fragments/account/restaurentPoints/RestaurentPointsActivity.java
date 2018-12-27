package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityRestaurentPointsBinding;

public class RestaurentPointsActivity extends AppCompatActivity {
    RestaurentPointsAdapter restaurentPointsAdapter;
    ActivityRestaurentPointsBinding binding;
//    ActivityFilterBinding


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurent_points);
        init();
    }

    private void init() {

        setRestaurentPointsRecyclerView();
    }

    private void setRestaurentPointsRecyclerView() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, GridLayoutManager.VERTICAL, false);
        binding.restaurentPointRv.setLayoutManager(gridLayoutManager);
        restaurentPointsAdapter = new RestaurentPointsAdapter(this);
        binding.restaurentPointRv.setAdapter(restaurentPointsAdapter);
//        binding..setLayoutManager(gridLayoutManager);
//        tabqyPointsAdapter = new TabqyPointsAdapter( this);
//        binding.tabqyRv.setAdapter(tabqyPointsAdapter);


    }
}
