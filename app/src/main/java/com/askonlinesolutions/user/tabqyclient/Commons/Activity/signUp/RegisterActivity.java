package com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.ThankYouSignup;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.vo.SignUpRequest;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.vo.SignupResponce;
import com.askonlinesolutions.user.tabqyclient.Helper.Utils;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.WebServices.APIClient;
import com.askonlinesolutions.user.tabqyclient.WebServices.OnResponseInterface;
import com.askonlinesolutions.user.tabqyclient.WebServices.ResponseListner;
import com.google.gson.Gson;

import retrofit2.Call;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, OnResponseInterface {
    private String TAG = RegisterActivity.class.getName();
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
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v) {
        if (v == tv_title) {
            finish();
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        } else if (v == btn) {
           // signUp();
            callSignupapi();
        }
    }

    private void callSignupapi() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setCustomer_phone(edt_phone.getText().toString().trim());
        signUpRequest.setCustomer_email(edt_email.getText().toString().trim());
        signUpRequest.setCustomer_password(edt_password.getText().toString().trim());
        signUpRequest.setFirst_name(edt_first_name.getText().toString().trim());
        signUpRequest.setGender("male");
        signUpRequest.setLast_name(edt_last_name.getText().toString().trim());
        signUpRequest.setCustomer_conf_password(edt_confirm_password.getText().toString().trim());
        Call<SignupResponce> call = APIClient.getInstance().getApiInterface().doRegister(signUpRequest);
        call.request().url();
        Log.d(TAG, "doLogin: " + call.request().url());
        new ResponseListner(this).getResponse(call);
    }


    private void signUp() {
        if (!edt_email.getText().toString().trim().equals("")) {
            if (Utils.checkemail(edt_email.getText().toString().trim())) {
                if (!edt_phone.getText().toString().trim().equals("")) {
                    if (Utils.isValidMobile(edt_phone.getText().toString().trim())) {
                        if (!edt_password.getText().toString().trim().equals("")) {
                            if (!edt_confirm_password.getText().toString().trim().equals("")) {
                                if (edt_password.getText().toString().trim()
                                        .equals(edt_confirm_password.getText().toString().trim())) {
                                    if (!edt_first_name.getText().toString().trim().equals("")) {
                                        if (!edt_last_name.getText().toString().trim().equals("")) {
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

    @Override
    public void onApiResponse(Object response) {
        if (response!=null) {
            if (response instanceof SignupResponce) {
              SignupResponce signupResponce = (SignupResponce) response;
                if (signupResponce.getStatus()==1)
                {
                    startActivity(new Intent(RegisterActivity.this,
                            ThankYouSignup.class));

                    Toast.makeText(this,signupResponce.getMessage(),Toast.LENGTH_SHORT).show();
                }

               // if (SignupResponce.isSuccess()) {
                   // mySharedPreference.saveUserData(new Gson().toJson(loginModal));
                   // mySharedPreference.saveUserId(loginModal.getData().getUser_id());
                    //Intent intent = new Intent(Login.this, MainActivity.class);
                   // startActivity(intent);
                  //  finish();
//                } else {
//                   // dialogError = Utility.createErrorDialog(this,dialogError,loginModal.getMessage());
//                    dialogError.show();
//                }
            }
        }
//        else {
//            dialogError = Utility.createErrorDialog(this,dialogError,getResources().getString(R.string.error));
//            dialogError.show();
//        }
    }

//    private Dialog dialogError;
//
//    }

    @Override
    public void onApiFailure(String message) {

    }
}