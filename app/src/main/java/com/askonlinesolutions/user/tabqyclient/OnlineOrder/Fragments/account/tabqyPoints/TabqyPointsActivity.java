package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityTabqyPointsBinding;

public class TabqyPointsActivity extends AppCompatActivity {
    ActivityTabqyPointsBinding binding;
    TabqyPointsAdapter tabqyPointsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tabqy_points);

        init();
    }

    private void init() {

        setRecyclerview();
    }

    private void setRecyclerview() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, GridLayoutManager.VERTICAL, false);
        binding.tabqyRv.setLayoutManager(gridLayoutManager);
        tabqyPointsAdapter = new TabqyPointsAdapter( this);
        binding.tabqyRv.setAdapter(tabqyPointsAdapter);

    }
}
