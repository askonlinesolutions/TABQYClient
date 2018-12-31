package com.askonlinesolutions.user.tabqyclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {
    TextView activity_login_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail2);
        activity_login_title =(TextView)findViewById(R.id.activity_login_title);
        activity_login_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
