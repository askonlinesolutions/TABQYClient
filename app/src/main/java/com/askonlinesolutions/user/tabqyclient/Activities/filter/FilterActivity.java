package com.askonlinesolutions.user.tabqyclient.Activities.filter;

import android.databinding.adapters.SeekBarBindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;


public class FilterActivity extends AppCompatActivity {

    TextView maxDistance, minDistance, maxAvg, minAvg;
    CrystalRangeSeekbar disSeekbar, avgSeekbar;

    //    private ActivityFilterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        initUi();

    }

    private void initUi() {
        maxAvg = findViewById(R.id.max_avg_cost_tv);
        minAvg = findViewById(R.id.min_avg_cost_tv);
        maxDistance = findViewById(R.id.max_dis_tv);
        minDistance = findViewById(R.id.min_dis_tv);
        disSeekbar = findViewById(R.id.distance_rangeSeekbar);
        avgSeekbar = findViewById(R.id.avg_cost_seekbar);

        setDistanceSeekbar();
        setAvgCostSeekbar();
    }

    private void setAvgCostSeekbar() {
        avgSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                minAvg.setText(String.valueOf(minValue));
                maxAvg.setText(String.valueOf(maxValue));
            }
        });

    }

    private void setDistanceSeekbar() {

        disSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                minDistance.setText(String.valueOf(minValue));
                maxDistance.setText(String.valueOf(maxValue));
            }
        });

//// set final value listener
//        disSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
//            @Override
//            public void finalValue(Number minValue, Number maxValue) {
//                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
//            }
//        });


    }


}
