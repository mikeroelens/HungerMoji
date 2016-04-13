package com.mikeroelens.hungermoji.view.screens;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mikeroelens.hungermoji.model.Emojis;
import com.mikeroelens.hungermoji.R;
import com.mikeroelens.hungermoji.game.GameInfo;
import com.mikeroelens.hungermoji.game.HighScoreTracker;
import com.mikeroelens.hungermoji.view.PixelatedTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameOverScreen extends BaseContentScreen {
    public interface GameOverScreenListener {
        void onHomeClick();
    }

    @Bind(R.id.txtExplosionEmoji) TextView explosionEmoji;
    @Bind(R.id.txtGameScore) PixelatedTextView txtScore;
    @Bind(R.id.txtHighScore) PixelatedTextView txtHighScore;
    View mView;
    private GameOverScreenListener mGameOverScreenListener;

    public GameOverScreen(Context context, GameInfo gameInfo, GameOverScreenListener gameOverScreenListener) {
        super(context);
        mGameOverScreenListener = gameOverScreenListener;
        HighScoreTracker.newScore(context, gameInfo.getScore());

        init(gameInfo);
    }

    private void init(GameInfo gameInfo) {
        mView = inflateById(R.layout.game_over_screen);
        ButterKnife.bind(this, mView);

        explosionEmoji.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        explosionEmoji.setText(Emojis.EXPLOSION);
        txtScore.setText(Integer.toString(gameInfo.getScore()));

        txtHighScore.setText(String.format(mContext.getString(R.string.game_over_screen_high_score), HighScoreTracker.getHighScore(mContext)));
    }

    @Override
    public View getContentView() {
        return mView;
    }

    @OnClick(R.id.btnHome)
    public void onHome() {
        mGameOverScreenListener.onHomeClick();
    }
}
