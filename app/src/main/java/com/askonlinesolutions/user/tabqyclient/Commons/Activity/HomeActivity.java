package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme1);
        setContentView(R.layout.activity_home);

        init();
    }

    private RelativeLayout layout_login, layout_online_order, layout_reservation;

    private void init(){

        layout_login = findViewById(R.id.activity_home_layout_login);
        layout_online_order = findViewById(R.id.activity_home_layout_online_order);
        layout_reservation = findViewById(R.id.activity_home_layout_reservation);

        layout_login.setOnClickListener(this);
        layout_online_order.setOnClickListener(this);
        layout_reservation.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();

    }

    @Override
    public void onClick(View v) {
        int id1 = v.getId();
        if (id1 == R.id.activity_home_layout_online_order) {
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
        } else if (id1 == R.id.activity_home_layout_reservation) {
            startActivity(new Intent(HomeActivity.this, SearchActivity.class));
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
        } else if (id1 == R.id.activity_home_layout_login) {
            startActivity(new Intent(HomeActivity.this, DetailActivity.class));
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
        } else {}
    }
}