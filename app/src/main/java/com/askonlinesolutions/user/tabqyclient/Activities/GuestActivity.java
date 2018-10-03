package com.askonlinesolutions.user.tabqyclient.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestActivity extends AppCompatActivity implements View.OnClickListener
{
    @BindView(R.id.toolbar_back)ImageView mBack;
    @BindView(R.id.toolbar_text)TextView mTitle_text;
    @BindView(R.id.login_card)CardView mGuest_login_Button;
    @BindView(R.id.guest_login_text)TextView mGuest_login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);


        ButterKnife.bind(this);
        mBack.setOnClickListener(this);
        mGuest_login.setOnClickListener(this);
        mGuest_login_Button.setOnClickListener(this);

        mTitle_text.setTypeface(EasyFonts.caviarDreamsBold(this));
        mGuest_login.setTypeface(EasyFonts.caviarDreamsBold(this));
    }

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }


    @Override
    public void onClick(View v)
    {
        if (v==mBack)
        {
            finish();
            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
        }
        if (v==mGuest_login_Button)
        {
           // showDialog(GuestActivity.this);
            startActivity(new Intent(GuestActivity.this,HomeActivity.class));
            setupWindowAnimations();
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }


}
