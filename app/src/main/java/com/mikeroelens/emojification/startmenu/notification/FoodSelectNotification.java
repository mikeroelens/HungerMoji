package com.mikeroelens.emojification.startmenu.notification;

import android.app.Notification;
import android.content.Context;

import com.mikeroelens.emojification.NotificationAction;
import com.mikeroelens.emojification.model.SelectFoodList;
import com.mikeroelens.emojification.model.SelectPlayerList;
import com.mikeroelens.emojification.model.gamepiece.character.Player;
import com.mikeroelens.emojification.notification.BaseNotification;

public class FoodSelectNotification extends BaseNotification {

    public FoodSelectNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        SelectPlayerList.list.getCurrentItem().setState(Player.STATE_NORMAL);

        builder()
            .setContentTitle(SelectFoodList.list.getCurrentItem().getStringSequence())
            .setContentText(SelectFoodList.list.getCurrentItem().getName());

        addDeleteIntent(NotificationAction.NEXT_FOOD);

        return builder().build();
    }

    public void next() {
        SelectFoodList.list.next();
    }
}
