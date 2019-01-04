package com.askonlinesolutions.user.tabqyclient.tableCode.menuList;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details.ItemsDetailActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.tabqyPoints.TabqyPointsActivity;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityMenuItemBinding;

public class MenuItemActivity extends AppCompatActivity implements MenuItemAdapter.OnItemClickLister, View.OnClickListener {

    private ActivityMenuItemBinding binding;
    private MenuItemAdapter menuItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu_item);

        init();

    }

    private void init() {
        setUpRecyclerview();
        TextView restro_back_btn;
        binding.restroBackBtn.setOnClickListener( this);
    }


    private void setUpRecyclerview() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        binding.menuItemRv.setLayoutManager(gridLayoutManager);
        menuItemAdapter = new MenuItemAdapter(this, this);
        binding.menuItemRv.setAdapter(menuItemAdapter);
    }

    @Override
    public void onItemClick(int Pos, String type) {
        if (type.equals("MENU_ITEM")) {
            Intent intent = new Intent(this, ItemsDetailActivity.class);
            intent.putExtra("key","MENU_ITEM");

            startActivity(intent);
            this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        } else {

        }
    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}
