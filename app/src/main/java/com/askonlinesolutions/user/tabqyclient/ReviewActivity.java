package com.askonlinesolutions.user.tabqyclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.MyCartFragment;

public class ReviewActivity extends AppCompatActivity {
    RelativeLayout minus,plus;
    TextView integer_number,goBack,checkout_btn,activity_login_title;
    int start= 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        minus=(RelativeLayout)findViewById(R.id.minus);
        checkout_btn=findViewById(R.id.checkout_btn);
        plus=(RelativeLayout)findViewById(R.id.plus);
        goBack=(TextView)findViewById(R.id.go_back);
        activity_login_title=findViewById(R.id.activity_login_title);
        integer_number=(TextView)findViewById(R.id.integer_number);
        checkout_btn=(TextView)findViewById(R.id.checkout_btn);

      //  activity_login_title =findViewById(R.id.activity_login_title);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(start>1) {
                    start = start - 1;
                    displaytext(start);
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start = start + 1;
                displaytext(start);
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });
        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewActivity.this,PlacingOrderActivity.class);
                startActivity(intent);
            }
        });
        activity_login_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent=new Intent(ReviewActivity.this,PlacingOrderActivity.class);
             startActivity(intent);
            }
        });



    }

    private void displaytext(int number) {
        integer_number=(TextView)findViewById(R.id.integer_number);
        integer_number.setText(""  + start);
    }


            }