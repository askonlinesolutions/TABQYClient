package com.askonlinesolutions.user.tabqyclient.Reservation.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.TimeAdapter;

import java.util.ArrayList;

public class ReserveTable extends AppCompatActivity implements TimeAdapter.TimeAdapterInterface, View.OnClickListener {


    private RecyclerView recyclerView;
    private ImageView iv_back;
    private ArrayList<String> time = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_table);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        time.clear();
        time.add("10:00 AM");
        time.add("11:00 AM");
        time.add("12:00 AM");
        time.add("01:00 PM");
        time.add("02:00 PM");
        time.add("03:00 PM");
        time.add("04:00 PM");
        time.add("05:00 PM");
        time.add("06:00 PM");
        time.add("07:00 PM");
        time.add("08:00 PM");
        time.add("09:00 PM");
        time.add("10:00 PM");
        time.add("11:00 PM");
        time.add("12:00 PM");
        time.add("01:00 AM");
        time.add("02:00 AM");
        time.add("03:00 AM");
        time.add("04:00 AM");
        time.add("05:00 AM");
        time.add("06:00 AM");
        time.add("07:00 AM");
        time.add("08:00 AM");
        time.add("09:00 AM");


        iv_back = findViewById(R.id.iv_back_reservetable);
        recyclerView = findViewById(R.id.time_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        iv_back.setOnClickListener(this);

        setAdapter();
    }

    private void setAdapter() {

        TimeAdapter timeAdapter = new TimeAdapter(time,this);
        recyclerView.setAdapter(timeAdapter);
    }

    @Override
    public void getDetails() {
        startActivity(new Intent(ReserveTable.this, Reservation.class));
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_reservetable:
                onBackPressed();
                break;
                default:
                    break;
        }
    }
}

