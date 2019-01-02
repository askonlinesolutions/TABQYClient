//package com.askonlinesolutions.user.tabqyclient.OnlineOrder.Activity.item_details;
//
//import android.content.Context;
//import android.databinding.DataBindingUtil;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.askonlinesolutions.user.tabqyclient.R;
//import com.askonlinesolutions.user.tabqyclient.databinding.ChechBoxItemListBinding;
//import com.askonlinesolutions.user.tabqyclient.utility.adapter.DataBoundListAdapter;
//
//import java.util.List;
//import java.util.Objects;
//
//public class ItemAdapter extends DataBoundListAdapter<String, ChechBoxItemListBinding> {
//
//    private final Context context;
//    List<String> mList;
//
//    ItemAdapter(Context context) {
//        this.context = context;
//    }
//
//
//    @Override
//    protected ChechBoxItemListBinding createBinding(ViewGroup parent, int viewType) {
//        return DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.chech_box_item_list, parent, false);
//    }
//
//    @Override
//    protected void bind(ChechBoxItemListBinding binding, String item) {
//        binding.getRoot().setTag(getPosition());
//        binding.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int pos = (int) view.getTag();
//            }
//        });
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
//
//
//}
