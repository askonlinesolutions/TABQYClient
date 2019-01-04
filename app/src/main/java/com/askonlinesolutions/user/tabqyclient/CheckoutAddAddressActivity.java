package com.askonlinesolutions.user.tabqyclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.addAddresss.AddAddressActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.filter.FilterActivity;
import com.askonlinesolutions.user.tabqyclient.Reservation.Activity.FindRestaurants;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckoutAddAddressActivity extends AppCompatActivity {
    ArrayList name = new ArrayList<>(Arrays.asList("Sector 6"));
    TextView addLocation,activity_login_title;
    EditText searchLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_add_address);
        addLocation = findViewById(R.id.location);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        searchLocation = findViewById(R.id.search_location);
        activity_login_title=findViewById(R.id.activity_login_title);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        RecentSearchAdapter recentSearchAdapter = new RecentSearchAdapter(CheckoutAddAddressActivity.this, name);
        recyclerView.setAdapter(recentSearchAdapter);
        addLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent filterIntent = new Intent(CheckoutAddAddressActivity.this, AddAddressActivity.class);
                startActivity(filterIntent);
            }
        });

        searchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent filterIntent = new Intent(CheckoutAddAddressActivity.this, AddAddressActivity.class);
                startActivity(filterIntent);
            }
        });
        activity_login_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
