package com.askonlinesolutions.user.tabqyclient.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.askonlinesolutions.user.tabqyclient.R;

import java.util.List;

public class CuisineAdapter extends ArrayAdapter<String>
{
    Context context;
    List<String> nameList;
    int res;

    public CuisineAdapter(@NonNull Context context, int resource, @NonNull List<String> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.res = resource;
        nameList = objects;

    }


    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater=LayoutInflater.from(context);
        View rowView=inflater.inflate(R.layout.cuisine_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.cuisine_text);
        titleText.setText(nameList.get(position));


        return rowView;

    };
}
