package com.askonlinesolutions.user.tabqyclient.Activities;

import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.AdapterViewPagerMain;
import com.askonlinesolutions.user.tabqyclient.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    String value;
    //    @BindView(R.id.viewpager)ViewPager mPager;
//    @BindView(R.id.tab)TabLayout mTab;
//    @BindView(R.id.toolbar_text_head)TextView mHeading;
//    @BindView(R.id.toolbar_back_heading)ImageView mBack;
    AdapterViewPagerMain mAdapter;

    final int[] ICONS = new int[]{R.drawable.ic_magnifying_glass_white, R.drawable.ic_offer_bottom, R.drawable.ic_cart, R.drawable.ic_order_status,
            R.drawable.ic_account};

    private ViewPager mPager;
    private TabLayout mTab;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ButterKnife.bind(this);

//        mHeading.setTypeface(EasyFonts.caviarDreamsBold(this));
//        mBack.setOnClickListener(this);

        tv_title = findViewById(R.id.activity_main_title);

        mPager = findViewById(R.id.viewpager);
        mTab = findViewById(R.id.tab);

        mAdapter = new AdapterViewPagerMain(getSupportFragmentManager(), this);
        mPager.setAdapter(mAdapter);
        mTab.setupWithViewPager(mPager);
        getBundleData();
        //  setUpTab();

        mTab.getTabAt(0).setIcon(ICONS[0]).setText("Restaurant");
        mTab.getTabAt(1).setIcon(ICONS[1]).setText("Offers");
        mTab.getTabAt(2).setIcon(ICONS[2]).setText("My Cart");
        mTab.getTabAt(3).setIcon(ICONS[3]).setText("Order Status");
        mTab.getTabAt(4).setIcon(ICONS[4]).setText("Account");

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.white_smoke);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                // mTab.getTabAt(0).setIcon(TAB_ICONS[0]).setText("Restaurant");
                //mTab.getTabAt(3).setIcon(TAB_ICONS[3]).setText("Order Status");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.dark_grey);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
                if (position == 0) {
                    tv_title.setText("Restaurants");
                } else if (position == 1) {
                    tv_title.setText("Offers");
                } else if (position == 2) {
                    tv_title.setText("My Cart");
                } else if (position == 3) {
                    tv_title.setText("Order Status");
                } else if (position == 4) {
                    tv_title.setText("Account");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

    }

    private void getBundleData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        if (value != null && value.equals("AddCart")) {
            mPager.setCurrentItem(2);
            tv_title.setText("My Cart");
//            mTab.getTabAt(2).setIcon(ICONS[2]).setText("My Cart");
        } else {
            mPager.setCurrentItem(0);
//            binding.backBtn.setText("Tabqy points");
        }

    }


    @Override
    public void onClick(View v) {
/*
        if (v==mBack)
        {
            finish();
            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
        }
*/
    }
}
