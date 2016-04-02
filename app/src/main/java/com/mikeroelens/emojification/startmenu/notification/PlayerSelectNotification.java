package com.mikeroelens.emojification.startmenu.notification;

import android.app.Notification;
import android.content.Context;

import com.mikeroelens.emojification.NotificationAction;
import com.mikeroelens.emojification.model.SelectPlayerList;
import com.mikeroelens.emojification.model.gamepiece.character.Player;
import com.mikeroelens.emojification.notification.BaseNotification;

public class PlayerSelectNotification extends BaseNotification {

    public PlayerSelectNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        SelectPlayerList.list.getCurrentItem().setState(Player.STATE_NORMAL);

        builder()
            .setContentTitle(SelectPlayerList.list.getCurrentItem().render())
            .setContentText(SelectPlayerList.list.getCurrentItem().getName());

        addDeleteIntent(NotificationAction.NEXT_PLAYER);

        return builder().build();
    }

    public void next() {
        SelectPlayerList.list.next();
    }
}
