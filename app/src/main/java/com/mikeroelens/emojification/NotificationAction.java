package com.mikeroelens.emojification;


import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NotificationAction {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            BEGIN_GAME,
            TILE_DISMISSED,
            NEXT_FOOD,
            NEXT_PLAYER
    })
    public @interface Action {}

    public static final String KEY_ACTION = "type";
    public static final String KEY_NOTIFICATION_ID = "notificationId";

    public static final String BEGIN_GAME = "BeginGame";
    public static final String TILE_DISMISSED = "TileDismissed";
    public static final String NEXT_FOOD = "NextFood";
    public static final String NEXT_PLAYER = "NextPlayer";
}
