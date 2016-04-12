package com.mikeroelens.emojification.notification.startmenu;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.mikeroelens.emojification.notification.NotificationAction;
import com.mikeroelens.emojification.R;
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
            .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.transparent_pixel))
            .setSmallIcon(R.drawable.icon_letter_l)
            .setContentTitle(SelectFoodList.list.getCurrentItem().getStringSequence())
            .setContentText(SelectFoodList.list.getCurrentItem().getName());

        setDeleteAction(NotificationAction.NEXT_FOOD);

        return builder().build();
    }

    public void next() {
        SelectFoodList.list.next();
    }
}
