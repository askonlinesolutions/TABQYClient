package com.askonlinesolutions.user.tabqyclient.Commons.Activity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.Activities.DrawerHomeActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.ThankYouSignup;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.RegisterActivity;
import com.askonlinesolutions.user.tabqyclient.Commons.Activity.signUp.vo.SignupResponce;
import com.askonlinesolutions.user.tabqyclient.Helper.Utils;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Reservation.Activity.FindRestaurants;
import com.askonlinesolutions.user.tabqyclient.WebServices.APIClient;
import com.askonlinesolutions.user.tabqyclient.WebServices.OnResponseInterface;
import com.askonlinesolutions.user.tabqyclient.WebServices.ResponseListner;
import com.askonlinesolutions.user.tabqyclient.tableCode.TableDashboardActivity;

import retrofit2.Call;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnResponseInterface {
    private TextView tv_login, tv_signup, tv_title, tv_forgot_password;
    private EditText edt_email, edt_password;
    String value, login;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getBundleData();
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

  // ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    //Call<LoginModal> call = apiService.getTopRatedMovies(API_KEY);
  //  Call<LoginModal> call = ApiClient.getInstance().getApiInterface().actionLogin("udfygugudgduiygreuigruirweug12skdnk");

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v) {

        if (v == tv_title) {
            finish();
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        } else if (v == tv_signup) {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            setupWindowAnimations();
        } else if (v == tv_login) {
//            if (value != null && value.equals("TABLE_CODE")) {
////                startActivity(new Intent(LoginActivity.this, TableDashboardActivity.class));
////                setupWindowAnimations();
//               // login();
           callLoginapi();
//            } else if (login != null && login.equals("LOGIN")) {
//
//                startActivity(new Intent(LoginActivity.this, DrawerHomeActivity.class));
//                setupWindowAnimations();
//               // login();
//
//            } else {
//
//                startActivity(new Intent(LoginActivity.this, FindRestaurants.class));
//                setupWindowAnimations();
//               // login();
//            }


        } else if (v == tv_forgot_password) {

        } else {
        }
    }

    private void callLoginapi() {
        LoginRequest loginRequest =new LoginRequest();
        loginRequest.setCustomer_email(edt_email.getText().toString().trim());
        loginRequest.setCustomer_password(edt_password.getText().toString().trim());
        Call<LoginResponse> call = APIClient.getInstance().getApiInterface().doLogin(loginRequest);
        call.request().url();
        Log.d(TAG, "doLogin: " + call.request().url());
        new ResponseListner(this).getResponse(call);
    }




    private void getBundleData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            login = extras.getString("login");
            //The key argument here must match that used in the other activity
        }
        if (value != null && value.equals("TABLE_CODE")) {
//            mPager.setCurrentItem(2);
//            tv_title.setText("My Cart");
//            mTab.getTabAt(2).setIcon(ICONS[2]).setText("My Cart");
        } else {
//            mPager.setCurrentItem(0);
//            binding.backBtn.setText("Tabqy points");
        }

    }


    private void login() {

        if (!edt_email.getText().toString().trim().equals("")) {
            if (Utils.checkemail(edt_email.getText().toString().trim())) {
                if (!edt_password.getText().toString().trim().equals("")) {
                    Utils.showToast(getApplicationContext(), "Login Successfull");
                    startActivity(new Intent(LoginActivity.this, FindRestaurants.class));
                    overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
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

    @Override
    public void onApiResponse(Object response) {
        if (response != null) {
            if (response instanceof LoginResponse) {
                LoginResponse loginResponse = (LoginResponse) response;
                if (loginResponse.getStatus() == 1) {
                    if (value != null && value.equals("TABLE_CODE")) {
//                startActivity(new Intent(LoginActivity.this, TableDashboardActivity.class));
//                setupWindowAnimations();
                        // login();
                        callLoginapi();
                    } else if (login != null && login.equals("LOGIN")) {

                        startActivity(new Intent(LoginActivity.this, DrawerHomeActivity.class));
                        setupWindowAnimations();
                        // login();

                    } else {

                        startActivity(new Intent(LoginActivity.this, FindRestaurants.class));
                        setupWindowAnimations();
                        // login();
                    }

                    Toast.makeText(this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onApiFailure(String message) {

    }
}
