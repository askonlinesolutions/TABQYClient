package com.askonlinesolutions.user.tabqyclient.Reservation.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.filter.FilterActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.searchResturent.SearchActivity;
import com.askonlinesolutions.user.tabqyclient.Reservation.Adapter.FindRestaurantItemsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;

public class FindRestaurants extends AppCompatActivity implements View.OnClickListener, FindRestaurantItemsAdapter.FindRestaurantInterface {

    private RecyclerView recyclerView;
    private TextView filter;
    private EditText et_find_restaurants;
    private ImageView iv_back;
    private LinearLayout current_location_lin, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_restaurants);

        //tv_find_restaurants = findViewById(R.id.tv_find_restaurants);
        et_find_restaurants = findViewById(R.id.et_find_restaurants);
        iv_back = findViewById(R.id.iv_back_find_restaurants);
        filter = findViewById(R.id.filter_btn_tv);
        current_location_lin = findViewById(R.id.current_location_lin);

        //tv_find_restaurants.setOnClickListener(this);
        et_find_restaurants.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        current_location_lin.setOnClickListener(this);
        filter.setOnClickListener(this);

        recyclerView = findViewById(R.id.find_restaurants_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        setAdapter();
    }

    private void setAdapter() {

        FindRestaurantItemsAdapter findRestaurantItemsAdapter = new FindRestaurantItemsAdapter(this);
        recyclerView.setAdapter(findRestaurantItemsAdapter);
    }

    @Override
    public void onClick(View v) {

        String et_str = "";
        /*if (v.getId()==R.id.tv_find_restaurants){
            et_find_restaurants.setVisibility(View.VISIBLE);
        }*/
        if (v.getId() == R.id.et_find_restaurants) {
            Intent searchIntent = new Intent(FindRestaurants.this, SearchActivity.class);
            startActivity(searchIntent);
            et_str = et_find_restaurants.getText().toString().trim();
        } else if (v.getId() == R.id.iv_back_find_restaurants) {
            onBackPressed();
        } else if (v.getId() == R.id.current_location_lin) {
            startActivity(new Intent(FindRestaurants.this, ChooseLocation.class));
        } else if (v.getId() == R.id.filter_btn_tv) {
            Intent filterIntent = new Intent(FindRestaurants.this, FilterActivity.class);
            startActivity(filterIntent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void getPosition(String Tag) {
        if (Tag == "reserve") {
            startActivity(new Intent(FindRestaurants.this, ReserveTable.class));
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        } else if (Tag.equals("reserve_view")) {
            startActivity(new Intent(FindRestaurants.this, ReserveTable.class));
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

        }
    }
}
