package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationActivity extends AppCompatActivity
{
//    @BindView(R.id.header_location)TextView mTitle;
//    @BindView(R.id.location_text)TextView mLocation_text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

//        ButterKnife.bind(this);
//
//        mTitle.setTypeface(EasyFonts.caviarDreamsBold(this));
//        mLocation_text.setTypeface(EasyFonts.caviarDreamsBold(this));
    }
}
