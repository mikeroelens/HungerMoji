package com.mikeroelens.emojification.notification;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.mikeroelens.emojification.MainActivity;
import com.mikeroelens.emojification.R;
import com.mikeroelens.emojification.model.SelectFoodList;

public class FoodSelectNotification {
    final private int mID = 2;
    private Context mContext;
    private NotificationManager mNotificationManager;

    public FoodSelectNotification(Context context, NotificationManager notificationManager) {
        mContext = context;
        mNotificationManager = notificationManager;
    }

    public void display() {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra("type", "NEXT_FOOD"); //TODO: pull out into constant?

        PendingIntent pi = PendingIntent.getActivity(mContext, mID, intent, 0); //TODO: should we pass 0's?

        NotificationCompat.Builder b = new NotificationCompat.Builder(mContext);
        b.setAutoCancel(false)
                .setWhen(mID)
                .setSmallIcon(R.drawable.transparent)
                .setTicker(Long.toString(System.currentTimeMillis()))
                .setContentTitle(SelectFoodList.list.getCurrentItem().getStringSequence())
                .setContentText(SelectFoodList.list.getCurrentItem().getName())
                .setDefaults(0)
                .setOngoing(false)
                .setSound(null)
                .setDeleteIntent(pi);

        mNotificationManager.notify(mID, b.build()); //TODO: pull ID out into constant
    }

    public void next() {
        SelectFoodList.list.next();
        display();
    }
}
