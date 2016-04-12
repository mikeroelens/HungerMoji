package com.mikeroelens.emojification.startmenu.notification;


import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.mikeroelens.emojification.NotificationAction;
import com.mikeroelens.emojification.R;
import com.mikeroelens.emojification.notification.BaseNotification;

public class BeginNotification extends BaseNotification {
    public BeginNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        builder()
            .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.transparent_pixel))
            .setSmallIcon(R.drawable.icon_letter_n)
            .setContentTitle(mContext.getString(R.string.start_menu_swipe_to_begin))
            .setContentText(mContext.getString(R.string.start_menu_swipe_arrow));

        setDeleteAction(NotificationAction.BEGIN_GAME);

        return builder().build();
    }
}
