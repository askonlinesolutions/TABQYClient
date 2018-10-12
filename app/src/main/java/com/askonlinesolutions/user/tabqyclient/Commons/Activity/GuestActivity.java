package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Commons.HomeActivity;
import com.askonlinesolutions.user.tabqyclient.Helper.Utils;
import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestActivity extends AppCompatActivity implements View.OnClickListener
{
//    @BindView(R.id.toolbar_back)ImageView mBack;
//    @BindView(R.id.toolbar_text)TextView mTitle_text;
//    @BindView(R.id.login_card)CardView mGuest_login_Button;
//    @BindView(R.id.guest_login_text)TextView mGuest_login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

//        ButterKnife.bind(this);
//        mBack.setOnClickListener(this);
//        mGuest_login.setOnClickListener(this);
//        mGuest_login_Button.setOnClickListener(this);
//
//        mTitle_text.setTypeface(EasyFonts.caviarDreamsBold(this));
//        mGuest_login.setTypeface(EasyFonts.caviarDreamsBold(this));

        init();
    }

    private EditText edt_name, edt_phone, edt_email;
    private RelativeLayout tv_login;

    private void init(){

        edt_name = findViewById(R.id.activity_guest_login_name);
        edt_phone = findViewById(R.id.activity_guest_login_phone);
        edt_email = findViewById(R.id.activity_guest_login_email);

        tv_login = findViewById(R.id.activity_guest_login_btn);
        tv_login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v==tv_login) {
            login();
        }
    }

    private void login(){

        if(!edt_name.getText().toString().trim().equals("")){
            if(!edt_email.getText().toString().trim().equals("")){
                if(Utils.checkemail(edt_email.getText().toString().trim())) {
                    if (!edt_phone.getText().toString().trim().equals("")) {
                        if(Utils.isValidMobile(edt_phone.getText().toString().trim())) {
                            Utils.showToast(getApplicationContext(), "Saved Sucessfully");
                        } else {
                            Utils.showToast(getApplicationContext(), "Please Enter a Valid Phone Number");
                        }
                    } else {
                        Utils.showToast(getApplicationContext(), "Please Enter Phone");
                    }
                } else {
                    Utils.showToast(getApplicationContext(), "Please Enter a Valid Email");
                }
            } else {
                Utils.showToast(getApplicationContext(), "Please Enter Email");
            }
        } else {
            Utils.showToast(getApplicationContext(), "Please Enter Name");
        }
    }
}