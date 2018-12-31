package com.askonlinesolutions.user.tabqyclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckoutAddAddressActivity extends AppCompatActivity {
    ArrayList name = new ArrayList<>(Arrays.asList("Sector 6"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_add_address);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        RecentSearchAdapter recentSearchAdapter = new RecentSearchAdapter(CheckoutAddAddressActivity.this, name);
        recyclerView.setAdapter(recentSearchAdapter);

    }
}
