package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.DrawerHomeActivity;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.login.LoginActivity;
import com.askonlinesolutions.user.tabqyclient.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout layout_login, layout_online_order, layout_reservation;
    TextView tablecode_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setTheme(R.style.AppTheme1);
        setContentView(R.layout.activity_home);
     init();
    }

    private void init() {

        layout_login = (RelativeLayout) findViewById(R.id.activity_home_layout_login);
        layout_online_order = findViewById(R.id.activity_home_layout_online_order);
        layout_reservation = findViewById(R.id.activity_home_layout_reservation);
        tablecode_btn = findViewById(R.id.table_code_tv);
//        TableCode=findViewById(R.id.table_code_tv);

        layout_login.setOnClickListener(this);
        layout_online_order.setOnClickListener(this);
        layout_reservation.setOnClickListener(this);
        tablecode_btn.setOnClickListener(this);

//        TableCode.setOnClickListener(this);

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
//            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            startActivity(new Intent(HomeActivity.this, DrawerHomeActivity.class));
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        } else if (id1 == R.id.activity_home_layout_reservation) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        } else if (id1 == R.id.activity_home_layout_login) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("login", "LOGIN");

            startActivity(intent);
//            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        } else if (id1 == R.id.table_code_tv) {

            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("key", "TABLE_CODE");

            startActivity(intent);
            this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
//            startActivity(new Intent(HomeActivity.this, TableDashboardActivity.class));
//            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);

        }
    }
}