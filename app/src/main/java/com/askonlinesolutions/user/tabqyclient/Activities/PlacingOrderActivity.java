package com.askonlinesolutions.user.tabqyclient.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlacingOrderActivity extends AppCompatActivity
{
    @BindView(R.id.thankyou_text)TextView mThankyou;
    @BindView(R.id.for_text)TextView mFor;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placing_order);

        ButterKnife.bind(this);
        mThankyou.setTypeface(EasyFonts.walkwayBold(this));
        mFor.setTypeface(EasyFonts.walkwayBold(this));
    }
}
