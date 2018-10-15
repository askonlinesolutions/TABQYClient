package com.askonlinesolutions.user.tabqyclient.customText;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Created by lenovo on 4/13/2018.
 */

public class CustomTextViewMedium extends android.support.v7.widget.AppCompatTextView {

    public CustomTextViewMedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomTextViewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextViewMedium(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Montserrat-Medium.ttf");
        setTypeface(tf ,1);
    }
}