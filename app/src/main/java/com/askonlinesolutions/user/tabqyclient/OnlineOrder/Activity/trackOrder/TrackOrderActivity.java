package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.trackOrder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

public class TrackOrderActivity extends AppCompatActivity implements View.OnClickListener {

    TextView backBtn;
//    ActivityTrackOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order);
        backBtn=findViewById(R.id.activity_login_title);

        backBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.activity_login_title:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        }
    }
}
