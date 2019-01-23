package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.detail_id;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.DrawerHomeActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.infoFragment.InfoFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.MenuFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.ReviewsFragment;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.Utils.Utility;
import com.askonlinesolutions.user.tabqyclient.WebServices.APIClient;
import com.askonlinesolutions.user.tabqyclient.WebServices.OnResponseInterface;
import com.askonlinesolutions.user.tabqyclient.WebServices.ResponseListner;
import com.askonlinesolutions.user.tabqyclient.tableCode.myCart.TableMyCartActivity;
import com.squareup.picasso.Picasso;

import retrofit2.Call;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener, OnResponseInterface {


    //    @BindView(R.id.menu_add_cart_fab)
    FloatingActionButton addToCart;
    String value;
    Context context;
//    private ArrayList<DetailResponse.DataEntity> dataEntities =new ArrayList<>();
    private int restureni_id;
    private String TAG = DetailActivity.class.getName();
    TextView activity_main_title, heading_text_restro, country_dish,min_order,avrage_time,distance;
    ImageView resturent_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addToCart = findViewById(R.id.menu_add_cart_fab);
        heading_text_restro = findViewById(R.id.heading_text_restro);
        avrage_time =findViewById(R.id.avrage_time);
        distance =findViewById(R.id.distance);
        min_order =findViewById(R.id.min_order);
        resturent_image =findViewById(R.id.resturent_image);
        country_dish = findViewById(R.id.country_dish);
        activity_main_title = findViewById(R.id.activity_main_title);
        getBundleData();
        getResturentdata();
        getResturentid(restureni_id);
        init();
    }

    private void getResturentid(int restureni_id) {
        new Utility().showProgressDialog(this);
        Call<DetailResponse> detailResponseCall = APIClient.getInstance().getApiInterface().getResturentDetail(restureni_id);
        detailResponseCall.request().url();
        Log.d(TAG, "detailId: " + detailResponseCall.request().url());
        new ResponseListner(this).getResponse(detailResponseCall);


    }

    private void getResturentdata() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            restureni_id = extras.getInt("resturentId");

        }
    }


    private void getBundleData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("res");
            //The key argument here must match that used in the other activity
        }
        if (value != null && value.equals("tv_withfood")) {
//            mPager.setCurrentItem(2);
//            tv_title.setText("My Cart");
//            mTab.getTabAt(2).setIcon(ICONS[2]).setText("My Cart");
        } else {
//            mPager.setCurrentItem(0);
//            binding.backBtn.setText("Tabqy points");
        }

    }

    private RelativeLayout tab_1, tab_2, tab_3;
    private TextView tv_tab_1, tv_tab_2, tv_tab_3;

    private void init() {
        activity_main_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value != null && value.equals("tv_withfood")) {
                    Intent mainIntent = new Intent(DetailActivity.this, TableMyCartActivity.class);
//                    mainIntent.putExtra("key", "AddCart");
                    startActivity(mainIntent);

                } else {

//                    Intent mainIntent = new Intent(DetailActivity.this, MainActivity.class);
                    Intent mainIntent = new Intent(DetailActivity.this, DrawerHomeActivity.class);
                    mainIntent.putExtra("key", "AddCart");
                    startActivity(mainIntent);
                }

            }
        });


        tab_1 = findViewById(R.id.restaurant_details_tab_1);
        tab_2 = findViewById(R.id.restaurant_details_tab_2);
        tab_3 = findViewById(R.id.restaurant_details_tab_3);
        tab_1.setOnClickListener(this);
        tab_2.setOnClickListener(this);
        tab_3.setOnClickListener(this);

        tv_tab_1 = findViewById(R.id.restaurant_details_tab_1_text);
        tv_tab_2 = findViewById(R.id.restaurant_details_tab_2_text);
        tv_tab_3 = findViewById(R.id.restaurant_details_tab_3_text);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_detail_frame, new MenuFragment()).commit();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.restaurant_details_tab_1) {
            setDefaulTab();
            tab_1.setBackgroundResource(R.drawable.shape_custom_tab_pink);
            tv_tab_1.setTextColor(getResources().getColor(R.color.white_color));
            tv_tab_1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_menu_button), null, null);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_detail_frame, new MenuFragment()).commit();
        } else if (v.getId() == R.id.restaurant_details_tab_2) {
            setDefaulTab();
            tab_2.setBackgroundResource(R.drawable.shape_custom_tab_pink);
            tv_tab_2.setTextColor(getResources().getColor(R.color.white_color));
            tv_tab_2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_star_white), null, null);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_detail_frame, new ReviewsFragment()).commit();
        } else if (v.getId() == R.id.restaurant_details_tab_3) {
            setDefaulTab();
            tab_3.setBackgroundResource(R.drawable.shape_custom_tab_pink);
            tv_tab_3.setTextColor(getResources().getColor(R.color.white_color));
            tv_tab_3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_information_white), null, null);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_detail_frame, new InfoFragment()).commit();
        }
    }

    private void setDefaulTab() {

        tab_1.setBackgroundResource(R.drawable.shape_custom_tab_grey);
        tab_2.setBackgroundResource(R.drawable.shape_custom_tab_grey);
        tab_3.setBackgroundResource(R.drawable.shape_custom_tab_grey);

        tv_tab_1.setTextColor(getResources().getColor(R.color.text_color_3));
        tv_tab_2.setTextColor(getResources().getColor(R.color.text_color_3));
        tv_tab_3.setTextColor(getResources().getColor(R.color.text_color_3));

        tv_tab_1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_menu_button_grey), null, null);
        tv_tab_2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_star_white_grey), null, null);
        tv_tab_3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_information_grey), null, null);
    }

    @Override
    public void onApiResponse(Object response) {
        if (response != null) {
            new Utility().hideDialog();
            DetailResponse detailResponse = (DetailResponse) response;
            if (detailResponse.getStatus() == 1) {

                heading_text_restro.setText(detailResponse.getData().getResturantbrand_name());
                country_dish.setText(detailResponse.getData().getResturantbrand_country());
                distance.setText(detailResponse.getData().getResturantbrand_delivery_distance());
                avrage_time.setText(detailResponse.getData().getResturantbrand_delivery_avgtime());


//                Picasso.with( this.context).load("http://webdevelopmenttesting.com/tabqy1/upload/images"
//                        +detailResponse.getData().getResturantbrand_file()) // URL or file
//                .into(resturent_image);
               // avrage_time.setText(detailResponse.getData().);
            }
        }
    }

    @Override
    public void onApiFailure(String message) {

    }
}