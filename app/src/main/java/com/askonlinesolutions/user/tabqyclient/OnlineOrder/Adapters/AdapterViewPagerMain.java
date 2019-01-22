package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.MyCartFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.OfferFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.OrderStatusFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.restroFragment.RestroFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.AccountFragment;

public class AdapterViewPagerMain extends FragmentPagerAdapter
{
 Context context;
 int total_tab = 5;
    public AdapterViewPagerMain(FragmentManager fm, Context context)
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
                return new MyCartFragment();
            case 3:
                return new OrderStatusFragment();
            case 4:
                return new AccountFragment();
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