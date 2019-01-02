//package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details;
//
//import android.support.v7.widget.LinearLayoutManager;
//
//import com.askonlinesolutions.user.tabqyclient.databinding.AddItemDialoagListLayoutBinding;
//import com.askonlinesolutions.user.tabqyclient.utility.adapter.GenericViewHolder;
//import com.askonlinesolutions.user.tabqyclient.utility.adapter.dummyDataGenrator.DummyDataGenerator;
//
//public class ProductViewHolder extends GenericViewHolder<String> {
//
//    private final AddItemDialoagListLayoutBinding binding;
//
//    public ProductViewHolder(AddItemDialoagListLayoutBinding binding) {
//        super(binding.getRoot());
//        this.binding = binding;
//    }
//
//    @Override
//    public void onBind(String item) {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
//        layoutManager.setSmoothScrollbarEnabled(true);
//        binding.itemsRv.setLayoutManager(layoutManager);
//        ItemAdapter itemAdapter = new ItemAdapter(context);
//        binding.itemsRv.setAdapter(itemAdapter);
//        itemAdapter.replace(DummyDataGenerator.getDummyStringList(7));
//
//    }
//
//}
//
//
//
