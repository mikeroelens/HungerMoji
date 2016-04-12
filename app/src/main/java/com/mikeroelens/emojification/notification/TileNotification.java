package com.mikeroelens.emojification.notification;

import android.app.Notification;
import android.content.Context;

import com.mikeroelens.emojification.NotificationAction;
import com.mikeroelens.emojification.model.gamepiece.GamePiece;
import com.mikeroelens.emojification.utils.Utils;

public class TileNotification extends BaseNotification {
    private int mPosition;
    private GamePiece mGamePiece;
    private boolean mOnGoing = false;

    public TileNotification(Context context, int id, int position, GamePiece gamePiece) {
        super(context, id);
        mPosition = position;
        mGamePiece = gamePiece;
    }

    public TileNotification(Context context, int id, int position, GamePiece gamePiece, boolean onGoing) {
        this(context, id, position, gamePiece);
        mOnGoing = onGoing;
    }

    public int getPosition() {
        return mPosition;
    }

    public GamePiece getGamePiece() {
        return mGamePiece;
    }

    @Override
    public Notification build() {
        builder()
            .setContentTitle(getPaddedGamePiece())
            .setOngoing(mOnGoing);

        setDeleteAction(NotificationAction.TILE_DISMISSED);

        return builder().build();
    }

    public void setOnGoing(boolean onGoing) {
        this.mOnGoing = onGoing;
    }

    private String getPaddedGamePiece(){
        return Utils.leftPad(mGamePiece.render(), mPosition);
    }
}
