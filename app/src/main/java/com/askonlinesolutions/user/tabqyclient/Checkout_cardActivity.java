package com.askonlinesolutions.user.tabqyclient;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.askonlinesolutions.user.tabqyclient.databinding.FragmentOrderBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class Checkout_cardActivity extends AppCompatActivity {
    Checkout_cardActivity binding;
    ArrayList name =new ArrayList<>(Arrays.asList("Riyadh,Sulimania Dabbab","Riyadh,Sulimania Dabbab "));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_card);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        RadioButton radio =(RadioButton)findViewById(R.id.table_order_RB);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CheckoutAdapter checkoutAdapter=new CheckoutAdapter(Checkout_cardActivity.this,name);
        recyclerView.setAdapter(checkoutAdapter);
   //     inIt();


    }

   // private void inIt() {

    }

  //  private void setupTabs() {

       // binding.radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         //   @Override
           // public void onCheckedChanged(RadioGroup group, int checkedId) {
             //   if (binding.table_order_RB.isChecked()) {
//             //       binding.radioGroup.setBackground(getResources().getDrawable(R.drawable.rounded_corner_border_primary));
                 //   binding.table_order_RB.setTextColor(Color.WHITE);
                   // binding.table_order_RB.setBackgroundColor(getResources().getColor(R.color.light_prime));
                  //  binding.onlineOrderRb.setBackgroundColor(getResources().getColor(R.color.white_color));
                   // binding.onlineOrderRb.setTextColor(getResources().getColor(R.color.light_prime));

                //if (binding.online_order_rb.isChecked()) {
//                    binding.radioGroup.setBackground(getResources().getDrawable(R.drawable.rounded_corner_border_primary));
                  //  binding.online_order_rb.setTextColor(Color.WHITE);
                    //binding.online_order_rb.setBackgroundColor(getResources().getColor(R.color.light_prime));
                  //  binding.tableOrderRB.setBackgroundColor(getResources().getColor(R.color.white_color));
                 //   binding.online_order_rb.setTextColor(getResources().getColor(R.color.light_prime));

            //    }

          //  }
        //});




