package com.mikeroelens.emojification.utils;


import android.content.Context;
import android.util.TypedValue;

public class Utils {

    //TODO: Look if we can include a library such as https://github.com/azer/left-pad ;)
    public static String leftPad(String input, int numSpaces) {
        return String.format("%1$" + numSpaces + "s", input);
    }

    public static int dpToPixels(Context context, int dpValue) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics()));
    }
}
