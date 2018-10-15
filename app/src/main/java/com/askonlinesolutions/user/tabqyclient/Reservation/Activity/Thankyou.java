package com.askonlinesolutions.user.tabqyclient.Reservation.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.askonlinesolutions.user.tabqyclient.Commons.Activity.HomeActivity;
import com.askonlinesolutions.user.tabqyclient.R;

public class Thankyou extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private static final long TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Thankyou.this,HomeActivity.class));
            }
        },TIME_OUT);

        iv_back = findViewById(R.id.iv_back_thankyou);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_thankyou:
                onBackPressed();
        }
    }
}
