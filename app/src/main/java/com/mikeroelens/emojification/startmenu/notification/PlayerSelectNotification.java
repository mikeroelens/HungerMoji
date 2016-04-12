package com.mikeroelens.emojification.startmenu.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.mikeroelens.emojification.NotificationAction;
import com.mikeroelens.emojification.R;
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
            .setSmallIcon(R.drawable.icon_letter_o)
            .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.transparent_pixel))
            .setContentTitle(SelectPlayerList.list.getCurrentItem().render())
            .setContentText(SelectPlayerList.list.getCurrentItem().getName());

        setDeleteAction(NotificationAction.NEXT_PLAYER);

        return builder().build();
    }

    public void next() {
        SelectPlayerList.list.next();
    }
}
