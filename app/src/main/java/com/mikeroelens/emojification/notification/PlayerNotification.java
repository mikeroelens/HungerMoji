package com.mikeroelens.emojification.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;

import com.mikeroelens.emojification.R;
import com.mikeroelens.emojification.model.SelectPlayerList;
import com.mikeroelens.emojification.model.gamepiece.character.Player;
import com.mikeroelens.emojification.utils.Utils;
import com.mikeroelens.emojification.view.ScoreKeeperIcon;

public class PlayerNotification extends BaseNotification {
    final private static int ID = 999999999;

    private ScoreKeeperIcon scoreKeeperIcon;
    private Player mPlayer;
    private int mPosition = 30;

    public PlayerNotification(Context context) {
        super(context, ID);
        mContext = context;

        scoreKeeperIcon = new ScoreKeeperIcon(context);
        mPlayer = SelectPlayerList.list.getCurrentItem();
    }

    @Override
    public Notification build() {
        builder()
            .setOngoing(true)
            .setContentTitle(Utils.leftPad(mPlayer.render(), mPosition))
            .setLargeIcon(scoreKeeperIcon.generateBitmap())
            .setSmallIcon(R.drawable.transparent);

        if (mPlayer.getState() == Player.STATE_DEAD) {
            builder().setContentText("Game Over!"); //TODO: Localize
        }

        return builder().build();
    }

    public void updatePosition(final int position) {
        mPosition = position;
    }

    public void updateScore(int delta) {
        scoreKeeperIcon.updateScore(delta);
    }

    public void explode() {
        mPlayer.setState(Player.STATE_EXPLOSION);
    }

    public void kill() {
        mPlayer.setState(Player.STATE_DEAD);
    }
}
