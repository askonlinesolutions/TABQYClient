package com.askonlinesolutions.user.tabqyclient.Commons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

public class ThankYouSignup extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you_signup);

        init();
    }

    private TextView tv_title, tv_next;

    private void init(){

        tv_title = findViewById(R.id.activity_thank_you_signup_title);
        tv_next = findViewById(R.id.activity_thank_you_signup_next);

        tv_title.setOnClickListener(this);
        tv_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == tv_title){
            finish();
        }
    }
}
