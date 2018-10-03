package com.askonlinesolutions.user.tabqyclient.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.askonlinesolutions.user.tabqyclient.Fragments.CartFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.InfoFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.OfferFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.OrderFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.ProfileFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.RestroFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.ReviewsFragment;

public class CompleteAdapter extends FragmentPagerAdapter
{
 Context context;
 int total_tab = 5;
    public CompleteAdapter(FragmentManager fm,Context context)
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
                return new RestroFragment();
            case 1:
                return new OfferFragment();
            case 2:
                return new CartFragment();
            case 3:
                return new OrderFragment();
            case 4:
                return new ProfileFragment();
                default:
                 return    new RestroFragment();

        }

    }

    @Override
    public int getCount()
    {
        return total_tab;
    }
}
