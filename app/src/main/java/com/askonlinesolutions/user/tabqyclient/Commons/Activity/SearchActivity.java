package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        init();
    }

    private void init() {
        binding.searchBackBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_back_btn:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
        }
    }
}
