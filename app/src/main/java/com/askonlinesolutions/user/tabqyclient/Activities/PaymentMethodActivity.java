package com.askonlinesolutions.user.tabqyclient.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentMethodActivity extends AppCompatActivity
{
    @BindView(R.id.header_payment)TextView mTitle;
    @BindView(R.id.payment_text)TextView mPayment_text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        ButterKnife.bind(this);

        mTitle.setTypeface(EasyFonts.caviarDreamsBold(this));
        mPayment_text.setTypeface(EasyFonts.caviarDreamsBold(this));
    }
}
