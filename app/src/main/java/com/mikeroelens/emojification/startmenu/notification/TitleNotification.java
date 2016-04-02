package com.mikeroelens.emojification.startmenu.notification;

import android.app.Notification;
import android.content.Context;

import com.mikeroelens.emojification.notification.BaseNotification;

public class TitleNotification extends BaseNotification {
    public TitleNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        return builder()
            .setContentTitle("Select Character and Food") //TODO: localize
            .setContentText("Swipe notification for next option")
            .build();
    }
}
