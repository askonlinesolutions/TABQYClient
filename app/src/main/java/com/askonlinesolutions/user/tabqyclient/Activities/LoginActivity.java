package com.askonlinesolutions.user.tabqyclient.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    @BindView(R.id.header_login_text)TextView mHeaderText;
    @BindView(R.id.login_button_text)TextView mLoginText;
    @BindView(R.id.title_back)ImageView mBack_image;
    @BindView(R.id.create_acnt_txt)TextView mCreate;
    @BindView(R.id.login_layout)RelativeLayout mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mHeaderText.setTypeface(EasyFonts.caviarDreamsBold(this));
        mLoginText.setTypeface(EasyFonts.caviarDreamsBold(this));

        mBack_image.setOnClickListener(this);
        mCreate.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v)
    {
       if (v==mBack_image)
       {
           finish();
           overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
       }
       if (v==mCreate)
       {
           startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
           setupWindowAnimations();
       }

       if (v==mLogin)
       {
           finish();
           startActivity(new Intent(LoginActivity.this,MainActivity.class));
           setupWindowAnimations();
       }
    }

}
