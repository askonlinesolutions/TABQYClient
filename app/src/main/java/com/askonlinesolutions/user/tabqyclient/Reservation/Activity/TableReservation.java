package com.askonlinesolutions.user.tabqyclient.Reservation.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.DetailActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.tableCode.myCart.TableMyCartAdapter;

public class TableReservation extends AppCompatActivity implements View.OnClickListener, TableMyCartAdapter.OnItemClickLister {

    private TableMyCartAdapter tableMyCartAdapter;
    private ImageView iv_back_table_reservation;
    private TextView tv_nofood, tv_book, addFoodItem,food;
    private RelativeLayout food_rel;
    LinearLayout add_food_layout, total_layout;
    RecyclerView foodRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_reservation);

        iv_back_table_reservation = findViewById(R.id.iv_back_table_reservation);
        tv_nofood = findViewById(R.id.tv_nofood);
        tv_book = findViewById(R.id.tv_book);
        addFoodItem = findViewById(R.id.tv_add_food_item);
        food_rel = findViewById(R.id.food_rel);
        foodRV = findViewById(R.id.food_menu_rv);
        total_layout = findViewById(R.id.total_layout);
        add_food_layout = findViewById(R.id.add_food_layout);
        food =findViewById(R.id.food);
        iv_back_table_reservation.setOnClickListener(this);
        tv_book.setOnClickListener(this);
        addFoodItem.setOnClickListener(this);

        String s = getIntent().getStringExtra("res");

        if (s.equals("tv_withoutfood")) {
            showToast(getBaseContext(), "Done");
            tv_nofood.setVisibility(View.GONE);
            food.setVisibility(View.GONE);
            add_food_layout.setVisibility(View.VISIBLE);
            food_rel.setVisibility(View.GONE);
            total_layout.setVisibility(View.GONE);
        } else if (s.equals("tv_withfood")) {
            food_rel.setVisibility(View.VISIBLE);
            food.setVisibility(View.VISIBLE);
            tv_nofood.setVisibility(View.GONE);
            total_layout.setVisibility(View.VISIBLE);
            add_food_layout.setVisibility(View.GONE);
        } else {
        }
    }


    private static Toast t;

    public static void showToast(Context context, String msg) {
        if (t != null)
            t.cancel();
        t = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        t.show();

    }

    private void setupRecyclerView() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        foodRV.setLayoutManager(gridLayoutManager);
        tableMyCartAdapter = new TableMyCartAdapter(this, this);
        foodRV.setAdapter(tableMyCartAdapter);
    }


    @Override
    public void onClick(View v) {

        String s = getIntent().getStringExtra("res");

        switch (v.getId()) {
            case R.id.iv_back_table_reservation:
                onBackPressed();
                break;

            case R.id.tv_add_food_item:
//                startActivity(new Intent(TableReservation.this,DetailActivity.class));
                Intent addIntent = new Intent(TableReservation.this, DetailActivity.class);
                addIntent.putExtra("res", "tv_withfood");
                startActivity(addIntent);

                break;

            case R.id.tv_book:
                startActivity(new Intent(TableReservation.this, Thankyou.class));
//                if (s.equals("tv_withoutfood")){
//                    startActivity(new Intent(TableReservation.this,Thankyou.class));
//                }
//                else if (s.equals("tv_withfood")){
////                    startActivity(new Intent(TableReservation.this,DetailActivity.class));
//
//                    Intent mainIntent = new Intent(TableReservation.this, DetailActivity.class);
//                    mainIntent.putExtra("res","tv_withoutfood");
//                    startActivity(mainIntent);

//                }
//                else {}
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

    @Override
    public void onItemClick(int Pos, String type) {

    }
}
