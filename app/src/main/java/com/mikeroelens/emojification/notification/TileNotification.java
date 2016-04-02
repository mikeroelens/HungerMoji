package com.mikeroelens.emojification.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.mikeroelens.emojification.MainActivity;
import com.mikeroelens.emojification.R;
import com.mikeroelens.emojification.model.gamepiece.GamePiece;
import com.mikeroelens.emojification.utils.Utils;

public class TileNotification {
    private Context mContext;
    private int mId;
    private int mPosition;
    private GamePiece mGamePiece;
    private Notification mNotification;

    public TileNotification(Context context, int id, int position, GamePiece gamePiece) {
        mContext = context;
        mId = id;
        mPosition = position;
        mGamePiece = gamePiece;
        buildNotification();
    }

    public int getId() {
        return mId;
    }

    public int getPosition() {
        return mPosition;
    }

    public Notification getNotification(){
        return mNotification;
    }

    public GamePiece getGamePiece() {
        return mGamePiece;
    }

    private PendingIntent createDeleteIntent() {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra("type", "TILE_DISMISSED"); //TODO: pull out into constant?
        intent.putExtra("notificationId", mId); //TODO: pull out into constant?

        return PendingIntent.getActivity(mContext, mId, intent, 0); //TODO: should we pass 0's?
    }

    private void buildNotification() {
        NotificationCompat.Builder b = new NotificationCompat.Builder(mContext);

        b.setAutoCancel(false)
                .setWhen(mId)
                //.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.transparent))
                .setSmallIcon(R.drawable.transparent)
                .setTicker(Long.toString(System.currentTimeMillis()))
                .setContentTitle(getPaddedGamePiece())
                .setDefaults(0)
                .setSound(null)
                .setDeleteIntent(createDeleteIntent());


        mNotification = b.build();
    }

    private String getPaddedGamePiece(){
        return Utils.leftPad(mGamePiece.render(), mPosition);
    }
}
