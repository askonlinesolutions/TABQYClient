package com.askonlinesolutions.user.tabqyclient.Commons;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Helper.Utils;
import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener
{
//    @BindView(R.id.header_text)TextView mHeader;
//    @BindView(R.id.title_back_register)ImageView mBack;

    private TextView tv_title, btn;
    private EditText edt_email, edt_phone, edt_password, edt_confirm_password, edt_first_name, edt_last_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        ButterKnife.bind(this);
//        mHeader.setTypeface(EasyFonts.caviarDreamsBold(this));

//        mBack.setOnClickListener(this);

        tv_title = findViewById(R.id.activity_register_title);
        edt_email = findViewById(R.id.activity_register_email);
        edt_phone = findViewById(R.id.activity_register_phone);
        edt_password = findViewById(R.id.activity_register_password);
        edt_confirm_password = findViewById(R.id.activity_register_confirm_password);
        edt_first_name = findViewById(R.id.activity_register_first_name);
        edt_last_name = findViewById(R.id.activity_register_last_name);
        btn = findViewById(R.id.activity_register_btn);

        tv_title.setOnClickListener(this);
        btn.setOnClickListener(this);
    }

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v) {
        if (v==tv_title) {
            finish();
            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
        } else if(v == btn){
            signUp();
        }
    }

    private void signUp(){
        if(!edt_email.getText().toString().trim().equals("")){
            if(Utils.checkemail(edt_email.getText().toString().trim())){
                if(!edt_phone.getText().toString().trim().equals("")){
                    if(Utils.isValidMobile(edt_phone.getText().toString().trim())){
                        if(!edt_password.getText().toString().trim().equals("")){
                            if(!edt_confirm_password.getText().toString().trim().equals("")){
                                if(edt_password.getText().toString().trim()
                                        .equals(edt_confirm_password.getText().toString().trim())){
                                    if(!edt_first_name.getText().toString().trim().equals("")){
                                        if(!edt_last_name.getText().toString().trim().equals("")){
                                            edt_email.setText("");
                                            edt_password.setText("");
                                            edt_phone.setText("");
                                            edt_first_name.setText("");
                                            edt_last_name.setText("");
                                            edt_confirm_password.setText("");
                                            Utils.showToast(getApplicationContext(), "Registration Successfull");
                                            startActivity(new Intent(RegisterActivity.this,
                                                    ThankYouSignup.class));
                                            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                                        } else {
                                            Utils.showToast(getApplicationContext(), "Please Enter Your Last Name");
                                        }
                                    } else {
                                        Utils.showToast(getApplicationContext(), "Please Enter Your First Name");
                                    }
                                } else {
                                    Utils.showToast(getApplicationContext(), "Confirm Password Does Not Match");
                                }
                            } else {
                                Utils.showToast(getApplicationContext(), "Please Enter Confirm Password");
                            }
                        } else {
                            Utils.showToast(getApplicationContext(), "Please Enter A Password");
                        }
                    } else {
                        Utils.showToast(getApplicationContext(), "Please Enter A Valid Phone Number");
                    }
                } else {
                    Utils.showToast(getApplicationContext(), "Please Enter A Phone Number");
                }
            } else {
                Utils.showToast(getApplicationContext(), "Please Enter A Valid Email");
            }
        } else {
            Utils.showToast(getApplicationContext(), "Please Enter An Email");
        }
    }
}