package com.askonlinesolutions.user.tabqyclient.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Adapters.CompleteAdapter;
import com.askonlinesolutions.user.tabqyclient.Adapters.DetailAdapter;
import com.askonlinesolutions.user.tabqyclient.R;
import com.vstechlab.easyfonts.EasyFonts;

import butterknife.BindView;
import butterknife.ButterKnife;
import toan.android.floatingactionmenu.FloatingActionsMenu;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final String TAG = DetailActivity.class.getSimpleName();
    @BindView(R.id.detail_pager)ViewPager mPager;
    @BindView(R.id.detail_tab_layout)TabLayout mTab;
    @BindView(R.id.title_back_detail)ImageView mBack;
    @BindView(R.id.header_detail_text)TextView mHeader;
    DetailAdapter mAdapter;
    int tab_images[] = {R.drawable.ic_menu_color,R.drawable.ic_reviews_color_w,R.drawable.ic_info_color_w};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);



        mBack.setOnClickListener(this);
        mHeader.setTypeface(EasyFonts.caviarDreamsBold(this));
        mAdapter = new DetailAdapter(getSupportFragmentManager(),this);
        mPager.setAdapter(mAdapter);
        mTab.setupWithViewPager(mPager);

        View view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_menu_color);
        mTab.getTabAt(0).setCustomView(view1);

        View view2 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_reviews_color_w);
        mTab.getTabAt(1).setCustomView(view2);

        View view3 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.ic_info_color_w);
        mTab.getTabAt(2).setCustomView(view3);

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
       
    }

    @Override
    public void onClick(View v)
    {
        if (v==mBack)
        {
            finish();
            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
        }
    }
}
