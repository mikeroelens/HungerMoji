package com.mikeroelens.emojification.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;

import com.mikeroelens.emojification.model.SelectPlayerList;
import com.mikeroelens.emojification.model.gamepiece.character.Player;
import com.mikeroelens.emojification.utils.Utils;
import com.mikeroelens.emojification.view.CountdownIcon;
import com.mikeroelens.emojification.view.ScoreKeeperIcon;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerNotification extends BaseNotification {
    public interface CountdownHandler {
        void onCountdownComplete();
    }

    private enum IconState {
        COUNTDOWN,
        SCORE_COUNTER
    }

    private IconState iconState = IconState.COUNTDOWN;

    final private static int ID = 999999999;

    private CountdownHandler mCountdownHandler;
    private NotificationManager mNotificationManager;
    private ScoreKeeperIcon scoreKeeperIcon;
    private CountdownIcon countdownIcon;
    private Player mPlayer;
    private int mPosition = 30;

    //TODO: now that we pass notificationManager, should we refactor the explosion?
    public PlayerNotification(Context context, NotificationManager notificationManager, CountdownHandler countdownHandler) {
        super(context, ID);
        mContext = context;
        mNotificationManager = notificationManager;
        mCountdownHandler = countdownHandler;

        scoreKeeperIcon = new ScoreKeeperIcon(context);
        mPlayer = SelectPlayerList.list.getCurrentItem();

        initCountdown();
    }

    private void initCountdown() {
        countdownIcon = new CountdownIcon(mContext);

        final Timer countdownTimer = new Timer();

        countdownTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (countdownIcon.getCount() == 1) {
                    countdownTimer.cancel();
                    iconState = IconState.SCORE_COUNTER;
                    display(mNotificationManager);
                    mCountdownHandler.onCountdownComplete();
                    return;
                }

                countdownIcon.decrementCount();
                display(mNotificationManager);
            }
        }, 1500, 1000);
    }

    @Override
    public Notification build() {
        builder()
            .setOngoing(true)
            .setContentTitle(Utils.leftPad(mPlayer.render(), mPosition));

        if (iconState == IconState.COUNTDOWN) {
            builder().setLargeIcon(countdownIcon.generateBitmap());
        }
        else {
            builder().setLargeIcon(scoreKeeperIcon.generateBitmap());
        }

        return builder().build();
    }

    public void updatePosition(final int position) {
        mPosition = position;
    }

    public void updateScore(int delta) {
        scoreKeeperIcon.updateScore(delta);

        // Don't show score delta for increases of only 1
        if (delta != 1) {
            scoreKeeperIcon.updateDelta(delta);

            //TODO: is this hacky? will getMainLooper technically only work for Activities?
            new Handler(mContext.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    scoreKeeperIcon.removeDelta();
                }
            }, 400);
        }
    }

    public void explode() {
        mPlayer.setState(Player.STATE_EXPLOSION);
        scoreKeeperIcon.removeDelta();
    }

    //TODO: should probably have more robust score tracking
    public int getScore() {
        return scoreKeeperIcon.getScore();
    }
}
