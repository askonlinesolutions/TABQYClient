package com.askonlinesolutions.user.tabqyclient;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.askonlinesolutions.user.tabqyclient.databinding.ActivityCheckoutCardBinding;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Checkout_cardActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityCheckoutCardBinding binding;
    ImageView contactDetail;
    TextView activity_login_title;
    private boolean isVisible = true;
    private boolean isShow = true;
    ArrayList name = new ArrayList<>(Arrays.asList("Riyadh,Sulimania Dabbab", "Riyadh,Sulimania Dabbab "));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout_card);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        activity_login_title =findViewById(R.id.activity_login_title);
       // ImageView contactDetail = (ImageView) findViewById(R.id.contactDetail);
        // RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.paymentRecyclerView);
        RadioButton radio = (RadioButton) findViewById(R.id.table_order_RB);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CheckoutAdapter checkoutAdapter = new CheckoutAdapter(Checkout_cardActivity.this, name);
        recyclerView.setAdapter(checkoutAdapter);

        inIt();


    }

    private void inIt() {
        setupCheckout();
        setupPayment();
        //setpaymentrRecyclerView();
        binding.editImageOrder.setOnClickListener(this);
        binding.payment.setOnClickListener(this);
        binding.contactDetail.setOnClickListener(this);
        binding.addNew.setOnClickListener(this);
        binding.review.setOnClickListener(this);
        binding.addNewCard.setOnClickListener(this);

    }

    private void setupCheckout() {
        binding.radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (binding.tableOrderRB.isChecked()) {
                    binding.tableOrderRB.setTextColor(Color.WHITE);
                    binding.tableOrderRB.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.onlineOrderRb.setBackgroundColor(getResources().getColor(R.color.white_color));
                    binding.onlineOrderRb.setTextColor(getResources().getColor(R.color.light_prime));
                    binding.review.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.pickup.setVisibility(View.VISIBLE);
                    binding.cashingLayout.setVisibility(View.VISIBLE);
                   // binding.cardLayout.setVisibility(View.VISIBLE);
                    // inding.cashLayout.setVisibility(View.VISIBLE);
                    binding.deliveryLayout.setVisibility(View.GONE);
                }
                if (binding.onlineOrderRb.isChecked()) {
                    binding.onlineOrderRb.setTextColor(Color.WHITE);
                    binding.onlineOrderRb.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.tableOrderRB.setBackgroundColor(getResources().getColor(R.color.white_color));
                    binding.tableOrderRB.setTextColor(getResources().getColor(R.color.light_prime));
                    binding.review.setBackgroundColor(getResources().getColor(R.color.gray));
                    binding.pickup.setVisibility(View.GONE);
                    binding.cashingLayout.setVisibility(View.GONE);
                  //  binding.cardLayout.setVisibility(View.GONE);
                    //binding.cashLayout.setVisibility(View.GONE);
                    binding.deliveryLayout.setVisibility(View.VISIBLE);
                }


            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_image_order:
                if (isVisible) {
                    binding.recyclerView.setVisibility(View.GONE);
                    binding.addNew.setVisibility(View.GONE);
                    binding.radio.setVisibility(View.GONE);
                    binding.pickup.setVisibility(View.GONE);

                    binding.editImageOrder.setImageResource(R.drawable.ic_down_arrow_prime);
                    isVisible = false;
                } else {
                    binding.recyclerView.setVisibility(View.VISIBLE);
                    binding.addNew.setVisibility(View.VISIBLE);
                    binding.pickup.setVisibility(View.VISIBLE);
                    binding.addNewCard.setVisibility(View.VISIBLE);
                    binding.radio.setVisibility(View.VISIBLE);
                    binding.editImageOrder.setImageResource(R.drawable.ic_up_arrow_prime);
                    isVisible = true;
                }
                break;

            case R.id.payment:
                if (isVisible) {
                    binding.cashingLayout.setVisibility(View.GONE);
                  //  binding.radioGroup.setVisibility(View.GONE);
                  //  binding.cashDelivery.setVisibility(View.GONE);
                  //  binding.addNewCard.setVisibility(View.GONE);
                 //  binding.cashDelivery1.setVisibility(View.GONE);
                   binding.payment.setImageResource(R.drawable.ic_down_arrow_prime);
                    isVisible = false;

                } else {
                    binding.cashingLayout.setVisibility(View.VISIBLE);
                  //  binding.radioGroup.setVisibility(View.VISIBLE);
                   // binding.cashDelivery.setVisibility(View.VISIBLE);
                  //  binding.cashDelivery1.setVisibility(View.VISIBLE);
                  //  binding.addNewCard.setVisibility(View.VISIBLE);
                   binding.payment.setImageResource(R.drawable.ic_up_arrow_prime);
                    isVisible = true;
                }
                break;



            case R.id.contactDetail:
                Intent intent = new Intent(this, ContactDetailActivity.class);
                startActivity(intent);
                break;

            case R.id.addNew:

                Intent address =new Intent(this,CheckoutAddAddressActivity.class);
                startActivity(address);
                break;
            case R.id.addNewCard:
                Intent card =new Intent(this,AddPaymentActivity.class);
                startActivity(card);
                break;
            case R.id.review:
                Intent review =new Intent(this,ReviewActivity.class);
                startActivity(review);
                break;
            case R.id.activity_login_title:
                onBackPressed();

        }
    }

    public void setupPayment() {
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (binding.card.isChecked()) {
                    binding.card.setTextColor(Color.WHITE);
                    binding.card.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.cash.setBackgroundColor(getResources().getColor(R.color.white_color));
                    binding.cash.setTextColor(getResources().getColor(R.color.light_prime));
                    binding.cash.setBackground(getResources().getDrawable(R.drawable.corner));
                    binding.cashLayout.setVisibility(View.GONE);
                    binding.cashdeliveryLayout.setVisibility(View.GONE);
                        binding.cardLayout.setVisibility(View.VISIBLE);

                    //binding.card.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.cashOnDelivery.setBackground(getResources().getDrawable(R.drawable.corner));
                    binding.cashOnDelivery.setTextColor(getResources().getColor(R.color.light_prime));
                }
                if (binding.cash.isChecked()) {
                    binding.cash.setTextColor(Color.WHITE);
                    binding.cashLayout.setVisibility(View.VISIBLE);
                    binding.cardLayout.setVisibility(View.GONE);
                    binding.cashdeliveryLayout.setVisibility(View.GONE);

                    binding.cash.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.card.setBackgroundColor(getResources().getColor(R.color.white_color));
                    binding.card.setTextColor(getResources().getColor(R.color.light_prime));
                    binding.card.setBackground(getResources().getDrawable(R.drawable.corner));
                    //binding.cash.setBackgroundColor(getResources().getColor(R.color.light_prime));

                    binding.cashOnDelivery.setBackground(getResources().getDrawable(R.drawable.corner));
                    binding.cashOnDelivery.setTextColor(getResources().getColor(R.color.light_prime));

                }
                if (binding.cashOnDelivery.isChecked()) {
                    binding.cashOnDelivery.setTextColor(Color.WHITE);
                    binding.cashLayout.setVisibility(View.GONE);
                    binding.cardLayout.setVisibility(View.GONE);
                    binding.cashdeliveryLayout.setVisibility(View.VISIBLE);
                    binding.cashOnDelivery.setBackgroundColor(getResources().getColor(R.color.light_prime));
                    binding.cash.setBackgroundColor(getResources().getColor(R.color.white_color));
                    binding.cash.setBackground(getResources().getDrawable(R.drawable.corner));
                    // binding.cashOnDelivery.setBackgroundColor(getResources().getColor(R.color.light_prime));

                    binding.cash.setTextColor(getResources().getColor(R.color.light_prime));
                    binding.card.setBackground(getResources().getDrawable(R.drawable.corner));
                    binding.card.setTextColor(getResources().getColor(R.color.light_prime));
                }
            }
        });
    }




    // private void setpaymentrRecyclerView() {

    // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

    //recyclerView1.setLayoutManager(linearLayoutManager);
    //CheckoutAdapter checkoutAdapter = new CheckoutAdapter(Checkout_cardActivity.this, name);
    // recyclerView1.setAdapter(checkoutAdapter);
}






