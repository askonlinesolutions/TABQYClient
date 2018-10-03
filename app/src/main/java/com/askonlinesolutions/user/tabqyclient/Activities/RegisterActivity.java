package com.askonlinesolutions.user.tabqyclient.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener
{
    @BindView(R.id.header_text)TextView mHeader;
    @BindView(R.id.register_button_text)TextView mRegister;
    @BindView(R.id.register_card)CardView mRegisterCard;
    @BindView(R.id.title_back_register)ImageView mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
        mHeader.setTypeface(EasyFonts.caviarDreamsBold(this));
        mRegister.setTypeface(EasyFonts.caviarDreamsBold(this));

        mRegisterCard.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }

    @Override
    public void onBackPressed()
    {

        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v)
    {
        if (v==mRegisterCard)
        {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
// ...Irrelevant code for customizing the buttons and title
            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog, null);
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

           // startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        }
        if (v==mBack)
        {
            finish();
            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
        }
    }
}
