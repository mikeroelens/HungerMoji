package com.mikeroelens.hungermoji.notification.startmenu;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.mikeroelens.hungermoji.notification.NotificationAction;
import com.mikeroelens.hungermoji.R;
import com.mikeroelens.hungermoji.model.SelectPlayerList;
import com.mikeroelens.hungermoji.model.gamepiece.character.Player;
import com.mikeroelens.hungermoji.notification.BaseNotification;

public class PlayerSelectNotification extends BaseNotification {

    public PlayerSelectNotification(Context context, int id) {
        super(context, id);
    }

    @Override
    public Notification build() {
        SelectPlayerList.list.getCurrentItem().setState(Player.STATE_NORMAL);

        builder()
            .setSmallIcon(R.drawable.icon_letter_u)
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
