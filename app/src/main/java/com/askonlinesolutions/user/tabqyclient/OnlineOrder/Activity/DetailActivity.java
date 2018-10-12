package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.InfoFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.MenuFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.ReviewsFragment;
import com.askonlinesolutions.user.tabqyclient.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener
{
//    private static final String TAG = DetailActivity.class.getSimpleName();
//    @BindView(R.id.detail_pager)ViewPager mPager;
//    @BindView(R.id.detail_tab_layout)TabLayout mTab;
//    @BindView(R.id.title_back_detail)ImageView mBack;
//    @BindView(R.id.header_detail_text)TextView mHeader;
//    DetailAdapter mAdapter;
//    int tab_images[] = {R.drawable.ic_menu_color,R.drawable.ic_reviews_color_w,R.drawable.ic_info_color_w};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        ButterKnife.bind(this);



//        mBack.setOnClickListener(this);
//        mHeader.setTypeface(EasyFonts.caviarDreamsBold(this));
//        mAdapter = new DetailAdapter(getSupportFragmentManager(),this);
//        mPager.setAdapter(mAdapter);
//        mTab.setupWithViewPager(mPager);

//        View view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
//        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_menu_color);
//        mTab.getTabAt(0).setCustomView(view1);

//        View view2 = getLayoutInflater().inflate(R.layout.custom_tab, null);
//        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_reviews_color_w);
//        mTab.getTabAt(1).setCustomView(view2);

//        View view3 = getLayoutInflater().inflate(R.layout.custom_tab, null);
//        view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_info_color_w);
//        mTab.getTabAt(2).setCustomView(view3);

/*
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {

                if (tab.getPosition()==0)
                {
                    Log.d(TAG, "onTabSelected: " + tab.getPosition());
                    View view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
                    view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_menu_color);
                    mTab.getTabAt(tab.getPosition()).setCustomView(view1);

                }
                else if (tab.getPosition()==1)
                {
                    Log.d(TAG, "onTabSelected: " + tab.getPosition());
                    View view2 = getLayoutInflater().inflate(R.layout.custom_tab, null);
                    view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_reviews_color_w);
                    mTab.getTabAt(tab.getPosition()).setCustomView(view2);
                }
                else if (tab.getPosition()==2)
                {
                    Log.d(TAG, "onTabSelected: " + tab.getPosition());
                    View view3 = getLayoutInflater().inflate(R.layout.custom_tab, null);
                    view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_reviews_color_w);
                    mTab.getTabAt(tab.getPosition()).setCustomView(view3);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {


            }
        });
       
*/
        init();
    }

    private RelativeLayout tab_1, tab_2, tab_3;
    private TextView tv_tab_1, tv_tab_2, tv_tab_3;

    private void init(){

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

        if(v.getId() == R.id.restaurant_details_tab_1){
            setDefaulTab();
            tab_1.setBackgroundResource(R.drawable.shape_custom_tab_pink);
            tv_tab_1.setTextColor(getResources().getColor(R.color.white_color));
            tv_tab_1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_menu_button), null , null );
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_detail_frame, new MenuFragment()).commit();
        } else if(v.getId() == R.id.restaurant_details_tab_2){
            setDefaulTab();
            tab_2.setBackgroundResource(R.drawable.shape_custom_tab_pink);
            tv_tab_2.setTextColor(getResources().getColor(R.color.white_color));
            tv_tab_2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_star_white), null , null );
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_detail_frame, new ReviewsFragment()).commit();
        } else if(v.getId() == R.id.restaurant_details_tab_3){
            setDefaulTab();
            tab_3.setBackgroundResource(R.drawable.shape_custom_tab_pink);
            tv_tab_3.setTextColor(getResources().getColor(R.color.white_color));
            tv_tab_3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_information_white), null , null );
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_detail_frame, new InfoFragment()).commit();
        }
    }

    private void setDefaulTab(){

        tab_1.setBackgroundResource(R.drawable.shape_custom_tab_grey);
        tab_2.setBackgroundResource(R.drawable.shape_custom_tab_grey);
        tab_3.setBackgroundResource(R.drawable.shape_custom_tab_grey);

        tv_tab_1.setTextColor(getResources().getColor(R.color.text_color_3));
        tv_tab_2.setTextColor(getResources().getColor(R.color.text_color_3));
        tv_tab_3.setTextColor(getResources().getColor(R.color.text_color_3));

        tv_tab_1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_menu_button_grey), null , null );
        tv_tab_2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_star_white_grey), null , null );
        tv_tab_3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.ic_information_grey), null , null );
    }
}