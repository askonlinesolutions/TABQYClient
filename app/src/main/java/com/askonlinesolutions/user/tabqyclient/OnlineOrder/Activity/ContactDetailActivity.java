package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.askonlinesolutions.user.tabqyclient.Helper.Utils;
import com.askonlinesolutions.user.tabqyclient.R;

public class ContactDetailActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        init();
    }

    private EditText edt_name, edt_email, edt_phone;
    private RelativeLayout btn_save;

    private void init(){

        edt_name = findViewById(R.id.activity_contact_detail_name);
        edt_email = findViewById(R.id.activity_contact_detail_email);
        edt_phone = findViewById(R.id.activity_contact_detail_phone);

        btn_save = findViewById(R.id.activity_contact_detail_save);
        btn_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == btn_save){

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
}