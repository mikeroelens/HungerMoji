package com.mikeroelens.emojification.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;

import com.mikeroelens.emojification.R;
import com.mikeroelens.emojification.model.SelectPlayerList;
import com.mikeroelens.emojification.model.gamepiece.character.Player;
import com.mikeroelens.emojification.utils.Utils;
import com.mikeroelens.emojification.view.ScoreKeeperIcon;

public class PlayerNotification {
    final private static int ID = 999999999;

    private Context mContext;
    private NotificationManager mNotificationManager;
    private Notification mNotification;
    private ScoreKeeperIcon scoreKeeperIcon;
    private Player mPlayer;
    private int mPosition = 30;

    public PlayerNotification(Context context, NotificationManager notificationManager) {
        mContext = context;
        mNotificationManager = notificationManager;
        scoreKeeperIcon = new ScoreKeeperIcon(context);
        mPlayer = SelectPlayerList.list.getCurrentItem();
        buildNotification(null);
    }

    private void buildNotification(String contentText) {
        NotificationCompat.Builder b = new NotificationCompat.Builder(mContext);

        b.setAutoCancel(true)
                .setWhen(ID)
                .setTicker(Long.toString(System.currentTimeMillis()))
                .setOngoing(true)
                .setContentTitle(Utils.leftPad(mPlayer.render(), mPosition))
                .setDefaults(0)
                .setLargeIcon(scoreKeeperIcon.generateBitmap())
                .setSmallIcon(R.drawable.transparent)
                .setSound(null);

        if (contentText != null) {
            b.setContentText(contentText);
        }

        mNotification = b.build();
    }

    public void display() {
        mNotificationManager.notify(ID, mNotification);
    }

    public void updateNotification(String contentText) {
        buildNotification(contentText);
        display();
    }

    public void updatePosition(final int position) {
        mPosition = position;
        updateNotification(null);
    }

    public void updateScore(int delta) {
        scoreKeeperIcon.updateScore(delta);
    }

    public void explode() {
        mPlayer.setState(Player.STATE_EXPLOSION);
        updateNotification(null);

        //TODO: is this hacky? will getMainLooper technically only work for Activities?
        new Handler(mContext.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPlayer.setState(Player.STATE_DEAD);
                updateNotification("You Lose!"); //TODO: Localize all strings?
            }
        }, 600);
    }

    public void remove() {
        mNotificationManager.cancel(ID);
    }
}
