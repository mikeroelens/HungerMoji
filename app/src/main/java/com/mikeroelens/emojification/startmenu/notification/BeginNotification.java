package com.mikeroelens.emojification.startmenu.notification;


import android.app.Notification;
import android.content.Context;

import com.mikeroelens.emojification.NotificationAction;
import com.mikeroelens.emojification.notification.BaseNotification;

public class BeginNotification extends BaseNotification {
    public BeginNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        builder()
            .setContentTitle("Begin!") //TODO: localize
            .setContentText("------------------------->");

        addDeleteIntent(NotificationAction.BEGIN_GAME);

        return builder().build();
    }
}
