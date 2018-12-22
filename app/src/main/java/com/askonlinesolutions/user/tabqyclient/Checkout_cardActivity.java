package com.askonlinesolutions.user.tabqyclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Checkout_cardActivity extends AppCompatActivity {
    ArrayList name =new ArrayList<>(Arrays.asList("Riyadh,Sulimania Dabbab","Riyadh,Sulimania Dabbab "));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_card);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CheckoutAdapter checkoutAdapter=new CheckoutAdapter(Checkout_cardActivity.this,name);
        recyclerView.setAdapter(checkoutAdapter);
    }
    }

