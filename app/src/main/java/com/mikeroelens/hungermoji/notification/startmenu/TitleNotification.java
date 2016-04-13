package com.mikeroelens.hungermoji.notification.startmenu;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.mikeroelens.hungermoji.R;
import com.mikeroelens.hungermoji.notification.BaseNotification;

public class TitleNotification extends BaseNotification {
    public TitleNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        return builder()
            .setContentTitle(mContext.getString(R.string.start_menu_select_character_and_food))
            .setContentText(mContext.getString(R.string.start_menu_swipe_for_next_option))
            .setOngoing(true)
            .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.transparent_pixel))
            .setSmallIcon(R.drawable.icon_letter_p)
            .setPriority(Notification.PRIORITY_HIGH)
            .build();
    }
}
