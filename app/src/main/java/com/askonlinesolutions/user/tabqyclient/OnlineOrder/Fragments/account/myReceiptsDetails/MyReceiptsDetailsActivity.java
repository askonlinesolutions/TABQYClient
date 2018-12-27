package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceiptsDetails;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityFilterBinding;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityMyReceiptsDetailsBinding;

public class MyReceiptsDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMyReceiptsDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_receipts_details);

        init();
    }

    private void init() {
        binding.detailsBackBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.details_back_btn:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;
        }

    }
}
