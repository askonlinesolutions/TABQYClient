package com.askonlinesolutions.user.tabqyclient;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GuestLoginActivity extends AppCompatActivity {
    ImageView close_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);
        final Dialog dialog =new Dialog(this);
        Button button=(Button)findViewById(R.id.guest_dialog);
        ImageView btncross=(ImageView) findViewById(R.id.close_img);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDialog();
            }
        });
        }
    public void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
         close_img= findViewById(R.id.close_img);
     // close_img.setOnClickListener(new View.OnClickListener() {
       //  @Override
         // public void onClick(View view) {
          //     dialog.dismiss();
         // }
 //    });
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

      // close_img.setOnClickListener(new View.OnClickListener() {
        //   @Override
          //  public void onClick(View arg0) {
          //      dialog.dismiss();
         //   }
       // });
    }
}
