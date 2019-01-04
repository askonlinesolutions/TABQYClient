package com.askonlinesolutions.user.tabqyclient.tableCode;

import android.databinding.DataBindingUtil;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityTableDashboardBinding;
import com.askonlinesolutions.user.tabqyclient.tableCode.menuDashboard.MenuDashboardFragment;

public class TableDashboardActivity extends AppCompatActivity {

    private static final String TAG = TableDashboardActivity.class.getSimpleName();
    ViewPagerAdapterTable adapterTable;
    final int[] ICONS = new int[]{R.drawable.ic_qr_code, R.drawable.ic_offer_bottom, R.drawable.ic_cart, R.drawable.ic_order_status,
            R.drawable.ic_call};

    private ViewPager mPager;
    private TabLayout mTab;
    private TextView tv_title;

    ActivityTableDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_table_dashboard);
//        setFragment(new MenuDashboardFragment());
        init();
    }

    private void init() {
        tv_title = findViewById(R.id.activity_main_title);

        mPager = findViewById(R.id.viewpager);
        mTab = findViewById(R.id.tab);

        setupViewPager();

    }

    private void setupViewPager() {


        adapterTable = new ViewPagerAdapterTable(getSupportFragmentManager(), this);
        binding.viewpager.setAdapter(adapterTable);
        binding.tab.setupWithViewPager(mPager);
//        getBundleData();
        //  setUpTab();

        binding.tab.getTabAt(0).setIcon(ICONS[0]).setText("My QR");
        binding.tab.getTabAt(1).setIcon(ICONS[1]).setText("Offers");
        binding.tab.getTabAt(2).setIcon(ICONS[2]).setText("My Cart");
        binding.tab.getTabAt(3).setIcon(ICONS[3]).setText("Order Status");
        binding.tab.getTabAt(4).setIcon(ICONS[4]).setText("Call Waiter");

        binding.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(TableDashboardActivity.this, R.color.white_smoke);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                // mTab.getTabAt(0).setIcon(TAB_ICONS[0]).setText("Restaurant");
                //mTab.getTabAt(3).setIcon(TAB_ICONS[3]).setText("Order Status");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(TableDashboardActivity.this, R.color.dark_grey);
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
                    binding.menuTitle.setVisibility(View.VISIBLE);
                    tv_title.setVisibility(View.GONE);
//                    tv_title.setText("Invitation Code");
                } else if (position == 1) {
                    binding.menuTitle.setVisibility(View.GONE);
                    tv_title.setVisibility(View.VISIBLE);
                    tv_title.setText("Offers");
                } else if (position == 2) {
                    binding.menuTitle.setVisibility(View.GONE);
                    tv_title.setVisibility(View.VISIBLE);
                    tv_title.setText("My Cart");
                } else if (position == 3) {
                    binding.menuTitle.setVisibility(View.GONE);
                    tv_title.setVisibility(View.VISIBLE);
                    tv_title.setText("Order Status");
                } else if (position == 4) {
                    binding.menuTitle.setVisibility(View.VISIBLE);
                    tv_title.setVisibility(View.GONE);
                    binding.menuTitle.setText("Call Waiter");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


    }

    public void setFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.menu_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
