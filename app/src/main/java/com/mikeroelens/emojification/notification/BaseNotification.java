package com.mikeroelens.emojification.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.mikeroelens.emojification.MainActivity;
import com.mikeroelens.emojification.R;

abstract public class BaseNotification {
    protected int mId;
    protected Context mContext;
    private NotificationCompat.Builder builder;

    public BaseNotification(Context context, int id) {
        mContext = context;
        mId = id;

        builder = new NotificationCompat.Builder(context)
                .setAutoCancel(false)
                .setWhen(mId)
                .setOngoing(false)
                .setDefaults(0)
                .setSmallIcon(R.drawable.transparent_pixel)
                .setColor(mContext.getResources().getColor(R.color.notification_icon_tint))
                .setSound(null);
    }

    public int getId() {
        return mId;
    }

    public abstract Notification build();

    public NotificationCompat.Builder builder() {
        return builder;
    }

    public void display(NotificationManager notificationManager) {
        notificationManager.notify(mId, build());
    }

    public void setDeleteAction(@NotificationAction.Action String action) {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra(NotificationAction.KEY_ACTION, action);
        intent.putExtra(NotificationAction.KEY_NOTIFICATION_ID, mId);

        builder.setDeleteIntent(PendingIntent.getActivity(mContext, mId, intent, 0));
    }

}
