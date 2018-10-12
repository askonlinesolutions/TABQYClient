package com.askonlinesolutions.user.tabqyclient.Reservation.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.MyReservationAdapter;


public class MyReservation extends AppCompatActivity implements View.OnClickListener, MyReservationAdapter.MyReservationAdapterInterface {
    
    private RecyclerView recyclerView;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservation);


        iv_back = findViewById(R.id.iv_back_my_reservation);
        
        recyclerView = findViewById(R.id.my_reservation_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        
        setAdapter();

        iv_back.setOnClickListener(this);
    }

    private void setAdapter() {
        MyReservationAdapter myReservationAdapter = new MyReservationAdapter(getApplicationContext(),this);
        recyclerView.setAdapter(myReservationAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back_my_reservation:
                onBackPressed();
                break;
                default:
                    break;
        }
    }

    @Override
    public void getDetails(int getAdapterPosition, String Tag) {
        if (Tag.equals("accepted")){
            TableReservation.showToast(getApplicationContext(),"Accepted");
        }
        else if (Tag.equals("cancel")){
            TableReservation.showToast(getApplicationContext(),"Cancelled");
        }
        else {}
    }
}
