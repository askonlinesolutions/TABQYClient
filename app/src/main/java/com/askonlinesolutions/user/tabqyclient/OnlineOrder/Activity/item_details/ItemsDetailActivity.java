package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.Activities.DrawerHomeActivity;
import com.askonlinesolutions.user.tabqyclient.Activities.MainActivity;
import com.askonlinesolutions.user.tabqyclient.OnlineOrder.Fragments.account.restaurentPoints.RestaurentPointsAdapter;
import com.askonlinesolutions.user.tabqyclient.R;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityItemsDetailBinding;
import com.askonlinesolutions.user.tabqyclient.databinding.ActivityProfileSettingBinding;
import com.askonlinesolutions.user.tabqyclient.tableCode.myCart.TableMyCartActivity;

import java.util.Calendar;

public class ItemsDetailActivity extends AppCompatActivity implements View.OnClickListener, ItemDetailsAdapter.OnItemClickLister {

    ActivityItemsDetailBinding binding;
    private ItemDetailsAdapter itemDetailsAdapter;
    ImageView crossTv;
    TextView addBtn;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_items_detail);
        init();
    }

    private void init() {
        binding.itemDetailsTitle.setOnClickListener(this);
        binding.facebookIv.setOnClickListener(this);
        binding.twitterIv.setOnClickListener(this);
        binding.shareDetailsHideIv.setOnClickListener(this);
        binding.shareDetailsShowIv.setOnClickListener(this);
        binding.plusIv.setOnClickListener(this);
        binding.addCartFab.setOnClickListener(this);
        setUpRecyclerView();
        getBundleData();
    }


    private void getBundleData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        if (value != null && value.equals("MENU_ITEM")) {
//            mPager.setCurrentItem(2);
//            tv_title.setText("My Cart");
//            mTab.getTabAt(2).setIcon(ICONS[2]).setText("My Cart");
        } else {
//            mPager.setCurrentItem(0);
//            binding.backBtn.setText("Tabqy points");
        }

    }


    private void setUpRecyclerView() {

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this, GridLayoutManager.HORIZONTAL, false);
        binding.itemsRv.setLayoutManager(gridLayoutManager);
        itemDetailsAdapter = new ItemDetailsAdapter(this, this);
        binding.itemsRv.setAdapter(itemDetailsAdapter);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_details_title:
                onBackPressed();
                this.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                break;

            case R.id.share_details_hide_iv:
                binding.facebookIv.setVisibility(View.VISIBLE);
                binding.twitterIv.setVisibility(View.VISIBLE);
                binding.shareDetailsShowIv.setVisibility(View.VISIBLE);
                binding.shareDetailsHideIv.setVisibility(View.GONE);
                break;

            case R.id.share_details_show_iv:
                binding.facebookIv.setVisibility(View.GONE);
                binding.twitterIv.setVisibility(View.GONE);
                binding.shareDetailsShowIv.setVisibility(View.GONE);
                binding.shareDetailsHideIv.setVisibility(View.VISIBLE);
                break;
            case R.id.plus_iv:
                showAddInfoDialog();
                break;

            case R.id.add_cart_fab:
                if (value != null && value.equals("MENU_ITEM")) {
                    Intent mainIntent = new Intent(ItemsDetailActivity.this, TableMyCartActivity.class);
//                    mainIntent.putExtra("key","AddCart");
                    startActivity(mainIntent);
                } else {
                    Intent mainIntent = new Intent(ItemsDetailActivity.this, DrawerHomeActivity.class);
                    mainIntent.putExtra("key", "AddCart");
                    startActivity(mainIntent);
                }

//
//                Intent mainIntent = new Intent(ItemsDetailActivity.this, MainActivity.class);
//                mainIntent.putExtra("key", "AddCart");
//                startActivity(mainIntent);
                break;

        }
    }

    @Override
    public void onItemClick(int Pos, String type) {

    }

    private void showAddInfoDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_item);
        dialog.setTitle("Loading...");
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        crossTv = dialog.findViewById(R.id.dialog_add_more_item_cross);
        addBtn = dialog.findViewById(R.id.add_btn_tv);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        crossTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }


}
