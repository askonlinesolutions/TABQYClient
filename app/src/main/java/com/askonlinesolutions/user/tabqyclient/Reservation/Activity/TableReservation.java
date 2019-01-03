package com.askonlinesolutions.user.tabqyclient.Reservation.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;

public class TableReservation extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_table_reservation;
    private TextView tv_nofood,tv_book,addFoodItem;
    private RelativeLayout food_rel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_reservation);

        iv_back_table_reservation = findViewById(R.id.iv_back_table_reservation);
        tv_nofood = findViewById(R.id.tv_nofood);
        tv_book = findViewById(R.id.tv_book);
        addFoodItem=findViewById(R.id.tv_add_food_item);
        food_rel = findViewById(R.id.food_rel);

        iv_back_table_reservation.setOnClickListener(this);
        tv_book.setOnClickListener(this);
        addFoodItem.setOnClickListener(this);

         String s = getIntent().getStringExtra("res");

         if (s.equals("tv_withoutfood")){
             showToast(getBaseContext(),"Done");
             tv_nofood.setVisibility(View.VISIBLE);
             food_rel.setVisibility(View.GONE);
         }
         else if (s.equals("tv_withfood")){
             food_rel.setVisibility(View.VISIBLE);
             tv_nofood.setVisibility(View.GONE);
         }
         else {}
         }


         private static Toast t;
    public static void showToast(Context context,String msg){
        if (t!=null)
            t.cancel();
        t= Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        t.show();

    }

    @Override
    public void onClick(View v) {

        String s = getIntent().getStringExtra("res");

        switch (v.getId()){
            case R.id.iv_back_table_reservation:
                onBackPressed();
                break;

            case R.id.tv_add_food_item:
                startActivity(new Intent(TableReservation.this,DetailActivity.class));
                break;

            case R.id.tv_book:
                if (s.equals("tv_withoutfood")){
                    startActivity(new Intent(TableReservation.this,Thankyou.class));
                }
                else if (s.equals("tv_withfood")){
                    startActivity(new Intent(TableReservation.this,DetailActivity.class));
                }
                else {}
                break;
                default:
                    break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
