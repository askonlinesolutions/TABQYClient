package com.askonlinesolutions.user.tabqyclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.databinding.ActivityCheckoutCardBinding;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityFilterBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class Checkout_cardActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityCheckoutCardBinding binding;
    CheckoutAdapter checkoutAdapter;

    ArrayList name = new ArrayList<>(Arrays.asList("Riyadh,Sulimania Dabbab", "Riyadh,Sulimania Dabbab "));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_card);

        init();
    }

    private void init() {
        setUpRecyclerView();
        binding.backCheckout.setOnClickListener(this);

    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        checkoutAdapter = new CheckoutAdapter(Checkout_cardActivity.this, name);
        binding.recyclerView.setAdapter(checkoutAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_checkout:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
        }
    }
}

