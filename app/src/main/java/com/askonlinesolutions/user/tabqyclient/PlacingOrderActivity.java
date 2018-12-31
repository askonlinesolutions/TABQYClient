package com.askonlinesolutions.user.tabqyclient;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Commons.Activity.HomeActivity;
import com.askonlinesolutions.user.tabqyclient.Reservation.Activity.Thankyou;

public class PlacingOrderActivity extends AppCompatActivity {
    private static final long TIME_OUT = 3000;
    TextView activity_login_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placing_order2);
        activity_login_title=(TextView)findViewById(R.id.activity_login_title);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(PlacingOrderActivity.this,Thankyou.class));
            }
        },TIME_OUT);
        activity_login_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
