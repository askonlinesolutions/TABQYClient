package com.askonlinesolutions.user.tabqyclient.utility.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class GenericViewHolder<T> extends RecyclerView.ViewHolder {

    public final Context context;

    public GenericViewHolder(View itemView) {
        super(itemView);
        this.context = itemView.getContext();
    }

    abstract public void onBind(T item);
}