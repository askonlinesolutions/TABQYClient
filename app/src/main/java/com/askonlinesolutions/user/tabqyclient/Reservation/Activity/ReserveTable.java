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
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.DateAdapter;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.ReservationTableAdapter;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.TimeAdapter;

import java.util.ArrayList;

public class ReserveTable extends AppCompatActivity implements TimeAdapter.TimeAdapterInterface, View.OnClickListener, DateAdapter.DateInterface {


    private RecyclerView recyclerView,dateRecycler;
    private ImageView iv_back;
    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> time = new ArrayList<>();
    private ArrayList<String> click_status = new ArrayList<>();
    private ArrayList<String> time_click_status = new ArrayList<>();
    DateAdapter dateAdapter;
    TimeAdapter timeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_table);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//        time.clear();
//        time.add("10:00 AM");
//        time.add("11:00 AM");
//        time.add("12:00 AM");
//        time.add("01:00 PM");
//        time.add("02:00 PM");
//        time.add("03:00 PM");
//        time.add("04:00 PM");
//        time.add("05:00 PM");
//        time.add("06:00 PM");
//        time.add("07:00 PM");
//        time.add("08:00 PM");
//        time.add("09:00 PM");
//        time.add("10:00 PM");
//        time.add("11:00 PM");
//        time.add("12:00 PM");
//        time.add("01:00 AM");
//        time.add("02:00 AM");
//        time.add("03:00 AM");
//        time.add("04:00 AM");
//        time.add("05:00 AM");
//        time.add("06:00 AM");
//        time.add("07:00 AM");
//        time.add("08:00 AM");
//        time.add("09:00 AM");


        iv_back = findViewById(R.id.iv_back_reservetable);
        recyclerView = findViewById(R.id.time_recycler);
        dateRecycler=findViewById(R.id.date_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager dateLinearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        dateRecycler.setLayoutManager(dateLinearLayoutManager);

        iv_back.setOnClickListener(this);
        setDateAdapter();
        setAdapter();
    }


    private void setDateAdapter() {

        numbers.clear();
        for (int i = 0; i <=50;i++){
            numbers.add(i+" SAT \nFab");
            click_status.add("0");
        }

        dateAdapter = new DateAdapter(numbers, click_status,getApplicationContext(),this);

        dateRecycler.setAdapter(dateAdapter);
    }




    private void setAdapter() {


        time.clear();
        for (int i = 0; i <=50;i++){
            time.add(i+":00 AM");
            time_click_status.add("0");
        }
//
//        reservationTableAdapter = new ReservationTableAdapter(numbers, click_status,
//                getApplicationContext(),this);
//
//        recyclerView1.setAdapter(reservationTableAdapter);


        TimeAdapter timeAdapter = new TimeAdapter(time, time_click_status,getApplicationContext(),this);
        recyclerView.setAdapter(timeAdapter);
    }

    @Override
    public void getDetails(int adapterPosition) {


        if (adapterPosition>=0){
            for (int i = 0; i<=50;i++){
                time_click_status.set(i,":00 AM");
            }

            time_click_status.set(adapterPosition, "1");
        }

        dateAdapter.notifyDataSetChanged();

//        if (adapterPosition>=0){
//            for (int i = 0; i<=50;i++){
//                click_status.set(i, "0");
//            }
//
//            click_status.set(adapterPosition, "1");
//        }

//        timeAdapter.notifyDataSetChanged();


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


    @Override
    public void getDateDetails(int adapterPosition) {


        if (adapterPosition>=0){
            for (int i = 0; i<=30;i++){
                click_status.set(i, " SAT \nFab");
            }

            click_status.set(adapterPosition, "1");
        }

        dateAdapter.notifyDataSetChanged();

    }
}

