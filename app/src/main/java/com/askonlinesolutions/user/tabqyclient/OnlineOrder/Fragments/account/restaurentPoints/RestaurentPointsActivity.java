package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityRestaurentPointsBinding;

public class RestaurentPointsActivity extends AppCompatActivity implements View.OnClickListener, RestaurentPointsAdapter.OnItemClickLister {
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
        binding.restroBackBtn.setOnClickListener(this);
    }

    private void setRestaurentPointsRecyclerView() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, GridLayoutManager.VERTICAL, false);
        binding.restaurentPointRv.setLayoutManager(gridLayoutManager);
        restaurentPointsAdapter = new RestaurentPointsAdapter(this, this);
        binding.restaurentPointRv.setAdapter(restaurentPointsAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.restro_back_btn:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;
        }
    }

    @Override
    public void onItemClick(int Pos, String type) {
        if (type.equals("RECEIPTS")) {
            Intent intent = new Intent(this, TabqyPointsActivity.class);
           intent.putExtra("key","receipt");

            startActivity(intent);
            this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        }
    }
}
