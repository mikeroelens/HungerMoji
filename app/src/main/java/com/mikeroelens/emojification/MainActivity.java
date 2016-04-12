package com.mikeroelens.emojification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.mikeroelens.emojification.game.Game;
import com.mikeroelens.emojification.utils.Utils;
import com.mikeroelens.emojification.view.SwipingHandView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends Activity implements StartScreen.StartScreenListener, MidGameScreen.MidGameScreenListener, PreGameScreen.PreGameListener, Game.GameListener, GameOverScreen.GameOverScreenListener {
    private enum Screen {
        START,
        PRE_GAME,
        MID_GAME,
        GAME_OVER
    }

    private Screen mCurrentScreen = Screen.START;
    private Game mGame;
    @Bind(R.id.main_content_view) FrameLayout mainContentLayout;
    @Bind(R.id.imgSwipeHand) SwipingHandView hand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainContentLayout.addView(new StartScreen(this, this).getContentView());
    }

    @Override
    protected void onPause() {
        super.onPause();
        //mGame.stop();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent.getStringExtra(NotificationAction.KEY_ACTION) != null) {
            String action = intent.getStringExtra(NotificationAction.KEY_ACTION);

            switch (action) {
                case NotificationAction.NEXT_PLAYER:
                    mGame.nextPlayer();
                    break;

                case NotificationAction.NEXT_FOOD:
                    mGame.nextFood();
                    break;

                case NotificationAction.TILE_DISMISSED:
                    mGame.tileRemoved(intent.getIntExtra(NotificationAction.KEY_NOTIFICATION_ID, 0));
                    break;

                case NotificationAction.BEGIN_GAME:
                    hand.hide();
                    mGame.startGamePlay();
                    updateScreen(Screen.MID_GAME);
                    break;

            }
        }
    }

    //TODO: create more robust back button handling
    @Override
    public void onBackPressed() {
        if (mCurrentScreen == Screen.START) {
            super.onBackPressed();
        }
        else if (mCurrentScreen == Screen.PRE_GAME) {
            mGame.stop();
            updateScreen(Screen.START);
        }
        else if (mCurrentScreen == Screen.GAME_OVER) {
            updateScreen(Screen.START);
        }
    }

    //TODO: create more robust view swapping
    private void updateScreen(Screen screen) {
        mCurrentScreen = screen;
        mainContentLayout.removeAllViewsInLayout();
        hand.hide();

        switch(screen) {
            case START:
                mainContentLayout.addView(new StartScreen(this, this).getContentView());
                break;

            case PRE_GAME:
                mGame = new Game(this, (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE), this);
                mainContentLayout.addView(new PreGameScreen(this, this).getContentView());
                mGame.displayStartMenu();
                hand.show();
                break;

            case MID_GAME:
                mainContentLayout.addView(new MidGameScreen(this, this).getContentView());
                break;

            case GAME_OVER:
                mainContentLayout.addView(new GameOverScreen(this, mGame, this).getContentView());
                break;
        }
    }

    @Override
    public void onPlayClicked() {
        if (Utils.isNetworkConnected(this)) {
            new DisableInternetDialog(this, new DisableInternetDialog.DisableInternetListener() {
                @Override
                public void onContinue() {
                    updateScreen(Screen.PRE_GAME);
                }
            }).show();
        }
        else {
            updateScreen(Screen.PRE_GAME);
        }
    }

    @Override
    public void onHighScoresClicked() {

    }

    @Override
    public void onStopGame() {
        mGame.stop();
        updateScreen(Screen.GAME_OVER);
    }

    @Override
    public void onGameOver() {
        updateScreen(Screen.GAME_OVER);
    }

    @Override
    public void onHomeClick() {
        updateScreen(Screen.START);
    }

    @Override
    public void onCancel() {
        hand.hide();
        mGame.stop();
        updateScreen(Screen.START);
    }
}