package com.mikeroelens.emojification;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class DisableInternetDialog extends Dialog {
    public interface DisableInternetListener {
        void onContinue();
    }

    private DisableInternetListener mDisableInternetListener;

    public DisableInternetDialog(Context context, DisableInternetListener disableInternetListener) {
        super(context);
        mDisableInternetListener = disableInternetListener;
    }

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_disable_internet);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnContinue)
    public void onContinue() {
        mDisableInternetListener.onContinue();
        dismiss();
    }
}
