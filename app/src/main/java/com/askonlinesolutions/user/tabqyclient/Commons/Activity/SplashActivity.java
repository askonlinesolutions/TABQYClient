package com.askonlinesolutions.user.tabqyclient.Commons.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.askonlinesolutions.user.tabqyclient.R;

public class SplashActivity extends AppCompatActivity
{

    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(i);
                setupWindowAnimations();

            }
        }, SPLASH_TIME_OUT);
    }

    private void setupWindowAnimations() {
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }


}
