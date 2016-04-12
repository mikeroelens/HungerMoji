package com.mikeroelens.emojification.view.screens;


import android.content.Context;
import android.view.View;

import com.mikeroelens.emojification.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreGameScreen extends BaseContentScreen {
    public interface PreGameListener {
        void onCancel();
    }

    View mView;
    private PreGameListener mPreGameScreenListener;

    public PreGameScreen(Context context, PreGameListener preGameListener) {
        super(context);
        mPreGameScreenListener = preGameListener;

        init();
    }

    private void init() {
        mView = inflateById(R.layout.pre_game_screen);
        ButterKnife.bind(this, mView);
    }

    @Override
    public View getContentView() {
        return mView;
    }

    @OnClick(R.id.btnCancel)
    public void onCancelClicked() {
        mPreGameScreenListener.onCancel();
    }
}
