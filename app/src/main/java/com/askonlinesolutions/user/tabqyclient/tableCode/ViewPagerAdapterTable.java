package com.askonlinesolutions.user.tabqyclient.tableCode;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.askonlinesolutions.user.tabqyclient.CallWaitingFragment;
import com.askonlinesolutions.user.tabqyclient.Fragments.OrderStatusFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.MyCartFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.OfferFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.RestroFragment;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.AccountFragment;
import com.askonlinesolutions.user.tabqyclient.TableMyCartFragment;
import com.askonlinesolutions.user.tabqyclient.tableCode.menuDashboard.MenuDashboardFragment;
import com.askonlinesolutions.user.tabqyclient.tableCode.qrCode.QrCodeFragment;

public class ViewPagerAdapterTable extends FragmentPagerAdapter {

    Context context;
    int total_tab = 5;
    public ViewPagerAdapterTable(FragmentManager fm, Context context)
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
                return new MenuDashboardFragment();
            case 1:
                return new OfferFragment();
            case 2:
                return new TableMyCartFragment();
            case 3:
                return new OrderStatusFragment();
            case 4:
                return new CallWaitingFragment();
            default:
                return    new MenuDashboardFragment();

        }
    }

    @Override
    public int getCount()
    {
        return total_tab;
    }


}
