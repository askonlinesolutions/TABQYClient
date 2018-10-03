package com.askonlinesolutions.user.tabqyclient.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener
{
    @BindView(R.id.back_checkout)ImageView mBack;
    @BindView(R.id.header_checkout_text)TextView mHeader;
    @BindView(R.id.edit_image)ImageView mEditContact;
    @BindView(R.id.edit_image_delivery)ImageView mEditDelivery;
    @BindView(R.id.edit_image_order)ImageView mEditOrder;
    @BindView(R.id.edit_image_payment)ImageView mEditPayment;
    @BindView(R.id.deliver_button_text)TextView mDeliverText;
    @BindView(R.id.delivery_card)CardView mDeliveryButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ButterKnife.bind(this);

        mHeader.setTypeface(EasyFonts.caviarDreamsBold(this));
        mDeliverText.setTypeface(EasyFonts.caviarDreamsBold(this));

        mBack.setOnClickListener(this);
        mEditContact.setOnClickListener(this);
        mEditDelivery.setOnClickListener(this);
        mEditOrder.setOnClickListener(this);
        mEditPayment.setOnClickListener(this);
        mDeliveryButton.setOnClickListener(this);


    }

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }

    @Override
    public void onClick(View v)
    {
        if (v==mBack)
        {

        }
        if (v==mEditContact)
        {
            startActivity(new Intent(CheckoutActivity.this,ContactDetailActivity.class));
            setupWindowAnimations();
        }

        if (v==mEditDelivery)
        {
            /*startActivity(new Intent(CheckoutActivity.this,ContactDetailActivity.class));
            setupWindowAnimations();*/
        }
        if (v==mEditOrder)
        {
            startActivity(new Intent(CheckoutActivity.this,OrderMethodActivity.class));
            setupWindowAnimations();
        }
        if (v==mEditPayment)
        {
            startActivity(new Intent(CheckoutActivity.this,PaymentMethodActivity.class));
            setupWindowAnimations();
        }
        if (v==mDeliveryButton)
        {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.edit_address_dailogue, null);
            dialogBuilder.setView(dialogView);
            ImageView close_img = dialogView.findViewById(R.id.close_img);
            final AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            alertDialog.show();
            close_img.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    alertDialog.dismiss();
                }
            });
        }
    }
}
