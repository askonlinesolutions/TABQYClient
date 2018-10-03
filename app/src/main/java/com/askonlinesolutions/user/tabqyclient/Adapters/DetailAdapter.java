package com.askonlinesolutions.user.tabqyclient.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.askonlinesolutions.user.tabqyclient.Fragments.MenuFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.InfoFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.ReviewsFragment;

public class DetailAdapter extends FragmentPagerAdapter
{
    Context context;
    int total_tab = 3;
    public DetailAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new MenuFragment();
            case 1:
                return new ReviewsFragment();
            case 2:
                return new InfoFragment();
            default:
                return    new MenuFragment();

        }

    }

    @Override
    public int getCount()
    {
        return total_tab;
    }
}

