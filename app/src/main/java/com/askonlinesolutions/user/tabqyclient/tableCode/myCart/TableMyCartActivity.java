package com.askonlinesolutions.user.tabqyclient.tableCode.myCart;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.detail_id.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Reservation.Activity.Reservation;
import com.askonlinesolutions.user.tabqyclient.Reservation.Activity.TableReservation;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityTableMyCartBinding;

public class TableMyCartActivity extends AppCompatActivity implements TableMyCartAdapter.OnItemClickLister, View.OnClickListener {
    private TableMyCartAdapter tableMyCartAdapter;
    ActivityTableMyCartBinding binding;
    TextView cencelBtn, addMore, reserve, cart_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_table_my_cart);
        init();
    }

    private void init() {
        setupRecyclerView();
        cencelBtn = findViewById(R.id.cancel_btn);
        addMore = findViewById(R.id.add_more_btn);
        reserve = findViewById(R.id.reserve_btn);
        cart_title = findViewById(R.id.cart_title);
        cencelBtn.setOnClickListener(this);
        addMore.setOnClickListener(this);
        reserve.setOnClickListener(this);
        cart_title.setOnClickListener(this);


    }

    private void setupRecyclerView() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.activityMyCartRecycler.setLayoutManager(gridLayoutManager);
        tableMyCartAdapter = new TableMyCartAdapter(this, this);
        binding.activityMyCartRecycler.setAdapter(tableMyCartAdapter);
    }

    @Override
    public void onItemClick(int Pos, String type) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_btn:
                Intent intent2 = new Intent(TableMyCartActivity.this, Reservation.class);
//                intent2.putExtra("res","tv_withfood");
                startActivity(intent2);
                break;

            case R.id.add_more_btn:
                Intent intentAdd = new Intent(TableMyCartActivity.this, DetailActivity.class);
                intentAdd.putExtra("res", "tv_withfood");
                startActivity(intentAdd);
                break;

            case R.id.reserve_btn:
                Intent intentReserve = new Intent(TableMyCartActivity.this, TableReservation.class);
                intentReserve.putExtra("res", "tv_withfood");
                startActivity(intentReserve);
                break;
            case R.id.cart_title:
                onBackPressed();
                break;
        }
    }
}
