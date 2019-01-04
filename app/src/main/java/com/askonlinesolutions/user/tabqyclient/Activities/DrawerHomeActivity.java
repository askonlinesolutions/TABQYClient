package com.askonlinesolutions.user.tabqyclient.Activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.AddPaymentActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters.AdapterViewPagerMain;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.myReceipt.MyReceiptActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.profileSetting.ProfileSettingActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityDrawerHomeBinding;

public class DrawerHomeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    ActivityDrawerHomeBinding binding;
    private static final String TAG = DrawerHomeActivity.class.getSimpleName();
    String value;

    final int[] ICONS = new int[]{R.drawable.ic_magnifying_glass_white, R.drawable.ic_offer_bottom, R.drawable.ic_cart, R.drawable.ic_order_status,
            R.drawable.ic_account};

    private ViewPager mPager;
    private TabLayout mTab;
    //    private TextView tv_title;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_drawer_home);

        init();


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }

    AdapterViewPagerMain mAdapter;
    TextView myOrderTv, myQrCodeTv, pointTv, paymentOptionTV, favoritesRestTv, saveLocationTv,
            aboutTv, offerTv, notificationTv, liveChatTv, receiptTv, shareAppTv, tabqy_tv, restaurant_tv, home_tv, office_tv, addPaymentMethodTv;
    ImageView pointShowIv, locationShowIv, paymentOptionShowIv, aboutShowIv, settingIv;
    LinearLayout pointLayout, locationLayout, paymentLayout, aboutLayout;

    boolean isPoint = true, isLocation = true, isPayment = true, isAbout = true;

    private void init() {


        setDrawer();
        setUpViewPager();

    }

    private void setDrawer() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.getHeaderView(0);

        myOrderTv = view.findViewById(R.id.nav_my_order_tv);
        myQrCodeTv = view.findViewById(R.id.nav_qrcode);
        pointTv = view.findViewById(R.id.nav_points_tv);
        paymentOptionTV = view.findViewById(R.id.nav_payment_option_tv);
        favoritesRestTv = view.findViewById(R.id.nav_Favorites_rest_tv);
        saveLocationTv = view.findViewById(R.id.save_location_tv);
        aboutTv = view.findViewById(R.id.nav_about_tv);
        offerTv = view.findViewById(R.id.nav_offer_tv);
        notificationTv = view.findViewById(R.id.nav_notification_tv);
        liveChatTv = view.findViewById(R.id.nav_live_chat_tv);
        receiptTv = view.findViewById(R.id.nav_receipt_tv);
        shareAppTv = view.findViewById(R.id.nav_share_chat_tv);

        tabqy_tv = view.findViewById(R.id.tabqy_points);
        restaurant_tv = view.findViewById(R.id.restaurant_points);
        shareAppTv = view.findViewById(R.id.nav_share_chat_tv);

        pointShowIv = view.findViewById(R.id.points_show_iv);
        settingIv = view.findViewById(R.id.setting_iv);
        locationShowIv = view.findViewById(R.id.location_show_iv);
        paymentOptionShowIv = view.findViewById(R.id.payment_show_iv);
        aboutShowIv = view.findViewById(R.id.about_show_iv);
        home_tv = view.findViewById(R.id.home_tv);
        office_tv = view.findViewById(R.id.office_tv);
        addPaymentMethodTv = view.findViewById(R.id.add_payment_method_tv);

        pointLayout = view.findViewById(R.id.points_layout);
        locationLayout = view.findViewById(R.id.location_layout);
        paymentLayout = view.findViewById(R.id.payment_layout);
        aboutLayout = view.findViewById(R.id.about_layout);


        findView();
    }

    private void findView() {

        myOrderTv.setOnClickListener(this);
        myQrCodeTv.setOnClickListener(this);
        pointTv.setOnClickListener(this);
        paymentOptionTV.setOnClickListener(this);
        favoritesRestTv.setOnClickListener(this);
        saveLocationTv.setOnClickListener(this);
        aboutTv.setOnClickListener(this);
        offerTv.setOnClickListener(this);
        notificationTv.setOnClickListener(this);
        liveChatTv.setOnClickListener(this);
        receiptTv.setOnClickListener(this);
        shareAppTv.setOnClickListener(this);
        addPaymentMethodTv.setOnClickListener(this);
        settingIv.setOnClickListener(this);
        pointShowIv.setOnClickListener(this);
        locationShowIv.setOnClickListener(this);
        paymentOptionShowIv.setOnClickListener(this);
        aboutShowIv.setOnClickListener(this);
        restaurant_tv.setOnClickListener(this);
        tabqy_tv.setOnClickListener(this);
        home_tv.setOnClickListener(this);
        office_tv.setOnClickListener(this);
        addPaymentMethodTv.setOnClickListener(this);

    }

    private void setUpViewPager() {
//        tv_title = findViewById(R.id.activity_main_title);

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
                int tabIconColor = ContextCompat.getColor(DrawerHomeActivity.this, R.color.white_smoke);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                // mTab.getTabAt(0).setIcon(TAB_ICONS[0]).setText("Restaurant");
                //mTab.getTabAt(3).setIcon(TAB_ICONS[3]).setText("Order Status");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(DrawerHomeActivity.this, R.color.dark_grey);
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
                    toolbar.setTitle("Restaurants")/*.setText("Restaurants")*/;
                } else if (position == 1) {
                    toolbar.setTitle("Offers");
                } else if (position == 2) {
                    toolbar.setTitle("My Cart");
                } else if (position == 3) {
                    toolbar.setTitle("Order Status");
                } else if (position == 4) {
                    toolbar.setTitle("Account");
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
            toolbar.setTitle("My Cart");
//            mTab.getTabAt(2).setIcon(ICONS[2]).setText("My Cart");
        } else {
            mPager.setCurrentItem(0);
//            binding.backBtn.setText("Tabqy points");
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_my_order_tv:
                Intent intent = new Intent(DrawerHomeActivity.this, MyReceiptActivity.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
            case R.id.setting_iv:
                Intent intentSetting = new Intent(DrawerHomeActivity.this, ProfileSettingActivity.class);
                startActivity(intentSetting);
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;


            case R.id.nav_qrcode:

                break;
            case R.id.nav_points_tv:

                if (isPoint) {
                    pointLayout.setVisibility(View.VISIBLE);
                    pointShowIv.setImageResource(R.drawable.ic_up_arrow);
                    isPoint = false;
                } else {
                    pointLayout.setVisibility(View.GONE);
                    pointShowIv.setImageResource(R.drawable.ic_down_arrow_);
                    isPoint = true;
                }
                break;

            case R.id.nav_payment_option_tv:

                if (isPayment) {
                    paymentLayout.setVisibility(View.VISIBLE);
                    paymentOptionShowIv.setImageResource(R.drawable.ic_up_arrow);
                    isPayment = false;
                } else {
                    paymentLayout.setVisibility(View.GONE);
                    paymentOptionShowIv.setImageResource(R.drawable.ic_down_arrow_);
                    isPayment = true;
                }
                break;

            case R.id.tabqy_points:
                Intent intentTabqy = new Intent(DrawerHomeActivity.this, TabqyPointsActivity.class);
                startActivity(intentTabqy);
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case R.id.restaurant_points:
                Intent intentRest = new Intent(DrawerHomeActivity.this, RestaurentPointsActivity.class);
                startActivity(intentRest);
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case R.id.add_payment_method_tv:
                Intent intentPay = new Intent(DrawerHomeActivity.this, AddPaymentActivity.class);
                startActivity(intentPay);
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;
            case R.id.save_location_tv:
                if (isLocation) {
                    locationLayout.setVisibility(View.VISIBLE);
                    locationShowIv.setImageResource(R.drawable.ic_up_arrow);
                    isLocation = false;
                } else {
                    locationLayout.setVisibility(View.GONE);
                    locationShowIv.setImageResource(R.drawable.ic_down_arrow_);
                    isLocation = true;
                }
                break;
            case R.id.nav_about_tv:

                if (isAbout) {
                    aboutLayout.setVisibility(View.VISIBLE);
                    aboutShowIv.setImageResource(R.drawable.ic_up_arrow);
                    isAbout = false;
                } else {
                    aboutLayout.setVisibility(View.GONE);
                    aboutShowIv.setImageResource(R.drawable.ic_down_arrow_);
                    isAbout = true;
                }
                break;

        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
