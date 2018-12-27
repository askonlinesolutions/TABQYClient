package com.askonlinesolutions.user.tabqyclient.Activities.filter;

import android.databinding.DataBindingUtil;
import android.databinding.adapters.SeekBarBindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityFilterBinding;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;


public class FilterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView maxDistance, minDistance, maxAvg, minAvg;
    CrystalRangeSeekbar disSeekbar, avgSeekbar;
    ActivityFilterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_filter);

        initUi();

    }

    private void initUi() {
//        maxAvg = findViewById(R.id.max_avg_cost_tv);
//        minAvg = findViewById(R.id.min_avg_cost_tv);
//        maxDistance = findViewById(R.id.max_dis_tv);
//        minDistance = findViewById(R.id.min_dis_tv);
//        disSeekbar = findViewById(R.id.distance_rangeSeekbar);
//        avgSeekbar = findViewById(R.id.avg_cost_seekbar);
        binding.activityLoginTitle.setOnClickListener(this);
        setDistanceSeekbar();
        setAvgCostSeekbar();
    }

    private void setAvgCostSeekbar() {
        binding.avgCostSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                binding.minAvgCostTv.setText(String.valueOf(minValue));
                binding.maxAvgCostTv.setText(String.valueOf(maxValue));
            }
        });

    }

    private void setDistanceSeekbar() {

        binding.distanceRangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                binding.minDisTv.setText(String.valueOf(minValue));
                binding.maxDisTv.setText(String.valueOf(maxValue));
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_login_title:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
        }
    }
}
