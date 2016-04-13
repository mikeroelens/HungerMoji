package com.mikeroelens.hungermoji.view.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

abstract public class BaseContentScreen {
    protected Context mContext;

    public BaseContentScreen(Context context) {
        mContext = context;
    }

    public abstract View getContentView();

    protected View inflateById(int viewId) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(viewId, null);
    }
}
