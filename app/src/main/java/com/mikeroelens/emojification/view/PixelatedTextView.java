package com.mikeroelens.emojification.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class PixelatedTextView extends TextView {

    public PixelatedTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public PixelatedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public PixelatedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/PIXELADE.ttf"));
        setTextColor(Color.BLACK);
    }
}
