//package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details;
//
//import android.content.Context;
//import android.databinding.DataBindingUtil;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import com.askonlinesolutions.user.tabqyclient.R;
//import com.askonlinesolutions.user.tabqyclient.databinding.AddItemDialoagListLayoutBinding;
//import com.askonlinesolutions.user.tabqyclient.utility.adapter.DataBoundListAdapter;
//
//import java.util.Objects;
//
//public class AddItemDialoagAdapter extends DataBoundListAdapter<String, AddItemDialoagListLayoutBinding> {
//
//    private final RecyclerView.RecycledViewPool mViewPool;
//    private final Context context;
//
//
//    public AddItemDialoagAdapter(Context context) {
//        this.context = context;
//        mViewPool = new RecyclerView.RecycledViewPool();
//    }
//
//    @Override
//    protected AddItemDialoagListLayoutBinding createBinding(ViewGroup parent, int viewType) {
//        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.add_item_dialoag_list_layout, parent, false);
//    }
//
//    @Override
//    protected void bind(AddItemDialoagListLayoutBinding binding, String item) {
//        binding.itemsRv.setRecycledViewPool(mViewPool);
//        ProductViewHolder viewHolder = new ProductViewHolder(binding);
//        viewHolder.onBind(item);
//    }
//
//    @Override
//    protected boolean areItemsTheSame(String oldItem, String newItem) {
//        return Objects.equals(oldItem, newItem);
//    }
//
//    @Override
//    protected boolean areContentsTheSame(String oldItem, String newItem) {
//        return false;
//    }
//
//}
