package com.mikeroelens.emojification.startmenu;

import android.app.NotificationManager;
import android.content.Context;

import com.mikeroelens.emojification.startmenu.notification.BeginNotification;
import com.mikeroelens.emojification.startmenu.notification.FoodSelectNotification;
import com.mikeroelens.emojification.startmenu.notification.PlayerSelectNotification;
import com.mikeroelens.emojification.startmenu.notification.TitleNotification;

public class StartMenu {
    private Context mContext;
    private NotificationManager mNotificationManager;
    PlayerSelectNotification mPlayerSelectNotification;
    FoodSelectNotification mFoodSelectNotification;

    private static final int ID_TITLE = 4;
    private static final int ID_PLAYER_SELECT = 3;
    private static final int ID_FOOD_SELECT = 2;
    private static final int ID_BEGIN = 1;

    public StartMenu(Context context, NotificationManager notificationManager) {
        mContext = context;
        mNotificationManager = notificationManager;
    }

    public void display() {
        mPlayerSelectNotification = new PlayerSelectNotification(mContext, ID_PLAYER_SELECT);
        mFoodSelectNotification = new FoodSelectNotification(mContext, ID_FOOD_SELECT);

        new TitleNotification(mContext, ID_TITLE).display(mNotificationManager);
        mPlayerSelectNotification.display(mNotificationManager);
        mFoodSelectNotification.display(mNotificationManager);
        new BeginNotification(mContext, ID_BEGIN).display(mNotificationManager);
    }


    public void remove() {
        mNotificationManager.cancel(ID_TITLE);
        mNotificationManager.cancel(ID_PLAYER_SELECT);
        mNotificationManager.cancel(ID_FOOD_SELECT);
        mNotificationManager.cancel(ID_BEGIN);
    }

    public void nextPlayer() {
        mPlayerSelectNotification.next();
        mPlayerSelectNotification.display(mNotificationManager);
    }

    public void nextFood() {
        mFoodSelectNotification.next();
        mFoodSelectNotification.display(mNotificationManager);
    }
}
