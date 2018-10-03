package com.askonlinesolutions.user.tabqyclient.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener
{
    @BindView(R.id.online_text)TextView mOnline;
    @BindView(R.id.reserve_text)TextView mReserve;
    @BindView(R.id.table_order_text)TextView mOrder;
    @BindView(R.id.reserve_layout)RelativeLayout mReserveTable;
    @BindView(R.id.login_layout)RelativeLayout mLogin;
    @BindView(R.id.online_layout)RelativeLayout mOnlineButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        mReserveTable.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mOnlineButton.setOnClickListener(this);

        mOnline.setTypeface(EasyFonts.caviarDreamsBold(this));
        mReserve.setTypeface(EasyFonts.caviarDreamsBold(this));
        mOrder.setTypeface(EasyFonts.caviarDreamsBold(this));
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finishAffinity();
    }

    @Override
    public void onClick(View v)
    {
        if (v==mReserveTable)
        {
            /*startActivity(new Intent(HomeActivity.this,MainActivity.class));
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);*/
        }
        if (v==mLogin)
        {
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
        }
        if (v==mOnlineButton)
        {
            startActivity(new Intent(HomeActivity.this,MainActivity.class));
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
        }
    }
}
