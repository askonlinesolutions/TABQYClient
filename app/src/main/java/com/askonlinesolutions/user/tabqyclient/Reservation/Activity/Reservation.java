package com.askonlinesolutions.user.tabqyclient.Reservation.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.ReservationAdultsAdapter;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.ReservationChildAdapter;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.ReservationTableAdapter;

import java.util.ArrayList;

public class Reservation extends AppCompatActivity implements View.OnClickListener,ReservationTableAdapter.ReservationAdapterTableInterface, ReservationAdultsAdapter.ReservationAdultsAdapterInterface, ReservationChildAdapter.ReservationChildAdapterInterface {

    private ImageView iv_back;
    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> number_second = new ArrayList<>();
    private ArrayList<String> number_third = new ArrayList<>();
    private ArrayList<String> click_status = new ArrayList<>();
    private ArrayList<String> click_status_second = new ArrayList<>();
    private ArrayList<String> click_status_third = new ArrayList<>();
    private RecyclerView recyclerView1,recyclerView2,recyclerView3;
    private TextView tv_withoutfood,tv_withfood;
    private ReservationTableAdapter reservationTableAdapter;
    private ReservationAdultsAdapter reservationAdultsAdapter;
    private ReservationChildAdapter reservationChildAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        iv_back = findViewById(R.id.iv_back_reservation);
        tv_withoutfood = findViewById(R.id.tv_withoutfood);
        tv_withfood = findViewById(R.id.tv_withfood);

        iv_back.setOnClickListener(this);
        tv_withoutfood.setOnClickListener(this);
        tv_withfood.setOnClickListener(this);

        recyclerView1 = findViewById(R.id.numbers_tables_recycler);
        recyclerView1.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(linearLayoutManager);

        recyclerView2 = findViewById(R.id.numbers_adults_recycler);
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        recyclerView3 = findViewById(R.id.numbers_kids_recycler);
        recyclerView3.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView3.setLayoutManager(linearLayoutManager3);

        setAdapter();
        setAdapter2();
        setAdapter3();
    }


    private void setAdapter() {

        numbers.clear();
        for (int i = 0; i <=50;i++){
            numbers.add(i+"");
            click_status.add("0");
        }

        reservationTableAdapter = new ReservationTableAdapter(numbers, click_status,
                getApplicationContext(),this);

        recyclerView1.setAdapter(reservationTableAdapter);
    }

    private void setAdapter2() {
        number_second.clear();
        for (int i = 0;i<=50;i++){
            number_second.add(i+"");
            click_status_second.add("0");
        }

        reservationAdultsAdapter = new ReservationAdultsAdapter(getApplicationContext(),numbers,click_status_second,
                this);

        recyclerView2.setAdapter(reservationAdultsAdapter);
    }

    private void setAdapter3() {
        number_third.clear();
        for (int i = 0;i<=50;i++){
            number_third.add(i+"");
            click_status_third.add("0");

            reservationChildAdapter = new ReservationChildAdapter(getApplicationContext(),number_third,click_status_third,
                    this);

            recyclerView3.setAdapter(reservationChildAdapter);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_reservation:
                onBackPressed();
                break;
            case R.id.tv_withoutfood:
                Intent intent = new Intent(Reservation.this, TableReservation.class);
                intent.putExtra("res","tv_withoutfood");
                startActivity(intent);
                break;
            case R.id.tv_withfood:
                Intent intent2 = new Intent(Reservation.this, DetailActivity.class);
                intent2.putExtra("res","tv_withfood");
                startActivity(intent2);
                break;
                default:
                    break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void getDetails(int adapterPosition) {

        if (adapterPosition>=0){
            for (int i = 0; i<=50;i++){
                click_status.set(i, "0");
            }

            click_status.set(adapterPosition, "1");
        }

        reservationTableAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDetailsAdults(int adapterPosition) {
        if (adapterPosition>=0){
            for (int i = 0; i<=50;i++){
                click_status_second.set(i, "0");
            }
            click_status_second.set(adapterPosition, "1");
        }
        reservationAdultsAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDetailsChild(int adapterPosition) {
        if (adapterPosition>=0){
            for (int i=0;i<=50;i++){
                click_status_third.set(i,"0");
            }
            click_status_third.set(adapterPosition,"1");
        }
        reservationChildAdapter.notifyDataSetChanged();
    }
}
