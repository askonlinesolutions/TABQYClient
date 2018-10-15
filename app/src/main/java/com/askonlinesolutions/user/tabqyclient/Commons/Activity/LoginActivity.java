package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.Helper.Utils;
import com.askonlinesolutions.user.tabqyclient.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

//    @BindView(R.id.header_login_text)TextView mHeaderText;
//    @BindView(R.id.login_button_text)TextView mLoginText;
//    @BindView(R.id.title_back)ImageView mBack_image;
//    @BindView(R.id.create_acnt_txt)TextView mCreate;
//    @BindView(R.id.login_layout)RelativeLayout mLogin;
//    @BindView(R.id.activity_login_edt_email)EditText edtEmail;
//    @BindView(R.id.activity_login_edt_password)EditText edtPassword;

    private TextView tv_login, tv_signup, tv_title, tv_forgot_password;
    private EditText edt_email, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        ButterKnife.bind(this);

//        mHeaderText.setTypeface(EasyFonts.caviarDreamsBold(this));
//        mLoginText.setTypeface(EasyFonts.caviarDreamsBold(this));

//        mBack_image.setOnClickListener(this);
//        mCreate.setOnClickListener(this);
//        mLogin.setOnClickListener(this);

        edt_email = findViewById(R.id.activity_login_edt_email);
        edt_password = findViewById(R.id.activity_login_edt_password);
        tv_title = findViewById(R.id.activity_login_title);
        tv_login = findViewById(R.id.activity_login_btn);
        tv_signup = findViewById(R.id.activity_login_signup);
        tv_forgot_password = findViewById(R.id.activity_login_forgot_password);

        tv_forgot_password.setOnClickListener(this);
        tv_signup.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_title.setOnClickListener(this);
    }

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v) {

       if (v == tv_title) {
           finish();
           overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
       } else if (v == tv_signup) {
           startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
           setupWindowAnimations();
       } else if (v == tv_login) {
           login();
       } else if (v == tv_forgot_password) {

       } else {}
    }

    private void login(){

        if(!edt_email.getText().toString().trim().equals("")){
            if(Utils.checkemail(edt_email.getText().toString().trim())){
                if(!edt_password.getText().toString().trim().equals("")){
                    Utils.showToast(getApplicationContext(), "Login Successfull");
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
                    finish();
              } else {
                    Utils.showToast(getApplicationContext(), "Please Enter Password");
                }
            } else {
                Utils.showToast(getApplicationContext(), "Please enter a valid email");
            }
        } else {
            Utils.showToast(getApplicationContext(), "Please Enter Email");
        }
    }

}
