package com.askonlinesolutions.user.tabqyclient.customText;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class Customtext2  extends android.support.v7.widget.AppCompatTextView {

        public Customtext2(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        public Customtext2(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public Customtext2(Context context) {
            super(context);
            init();
        }

        private void init() {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/MaiandraGDRegular.ttf");
            setTypeface(tf ,1);

        }

    }
