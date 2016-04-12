package com.mikeroelens.emojification.view.screens;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mikeroelens.emojification.model.Emojis;
import com.mikeroelens.emojification.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartScreen extends BaseContentScreen {
    public interface StartScreenListener {
        void onPlayClicked();
        void onHighScoresClicked();
    }

    private StartScreenListener mStartScreenListener;
    View mView;

    @Bind(R.id.txtInstructionsBombEmoji) TextView txtInstructionsBombEmoji;
    @Bind(R.id.txtInstructionsBonusEmoji) TextView txtInstructionsBonusEmoji;
    @Bind(R.id.txtInstructionsFoodEmoji) TextView txtInstructionsFoodEmoji;

    public StartScreen(Context context, StartScreenListener startScreenListener) {
        super(context);
        mStartScreenListener = startScreenListener;

        init();
    }

    private void init() {
        mView = inflateById(R.layout.start_screen);
        ButterKnife.bind(this, mView);

        txtInstructionsBombEmoji.setText(Emojis.BOMB);
        txtInstructionsBonusEmoji.setText(Emojis.TEN);
        txtInstructionsFoodEmoji.setText(Emojis.BANANA + Emojis.ICE_CREAM_CONE + Emojis.BURGER);
    }

    @Override
    public View getContentView() {
        return mView;
    }

    @OnClick(R.id.btnPlay)
    public void onPlayClicked() {
        mStartScreenListener.onPlayClicked();
    }

    /*
    @OnClick(R.id.btnHighScores)
    public void onHighScoresClicked() {
        mStartScreenListener.onHighScoresClicked();
    }
    */
}
