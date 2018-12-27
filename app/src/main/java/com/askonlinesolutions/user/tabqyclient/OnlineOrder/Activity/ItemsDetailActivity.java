package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityItemsDetailBinding;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityProfileSettingBinding;

public class ItemsDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityItemsDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_items_detail);
        init();
    }

    private void init() {
        binding.itemDetailsTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_details_title:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
        }
    }
}
