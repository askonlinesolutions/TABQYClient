package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityTabqyPointsBinding;

public class TabqyPointsActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityTabqyPointsBinding binding;
    TabqyPointsAdapter tabqyPointsAdapter;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tabqy_points);

        init();
    }

    private void init() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        if (value != null && value.equals("receipt")) {
            binding.backBtn.setText("Restaurant points");
        } else {
            binding.backBtn.setText("Tabqy points");
        }
        setRecyclerview();
        binding.backBtn.setOnClickListener(this);
    }

    private void setRecyclerview() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, GridLayoutManager.VERTICAL, false);
        binding.tabqyRv.setLayoutManager(gridLayoutManager);
        tabqyPointsAdapter = new TabqyPointsAdapter(this);
        binding.tabqyRv.setAdapter(tabqyPointsAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;
        }
    }
}
