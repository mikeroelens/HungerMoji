package com.mikeroelens.emojification.startmenu.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.mikeroelens.emojification.R;
import com.mikeroelens.emojification.notification.BaseNotification;

public class TitleNotification extends BaseNotification {
    public TitleNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        return builder()
            .setContentTitle("Select character and food") //TODO: localize
            .setContentText("Swipe for next option")
            .setOngoing(true)
            .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.transparent_pixel))
            .setSmallIcon(R.drawable.icon_letter_d)
            .setPriority(Notification.PRIORITY_HIGH)
            .setTicker("Swipe down to begin game!")
            .build();
    }
}
