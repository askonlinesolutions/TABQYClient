package com.askonlinesolutions.user.tabqyclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.CheckoutActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.addAddresss.AddAddressActivity;

public class ContactDetailActivity extends AppCompatActivity {
    Button save;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail2);

        save = findViewById(R.id.save_btn);
        back = findViewById(R.id.contact_title);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent filterIntent = new Intent(ContactDetailActivity.this, Checkout_cardActivity.class);
                startActivity(filterIntent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

    }
}
