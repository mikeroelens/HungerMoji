package com.mikeroelens.hungermoji.notification.startmenu;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;

import com.mikeroelens.hungermoji.notification.NotificationAction;
import com.mikeroelens.hungermoji.R;
import com.mikeroelens.hungermoji.model.SelectFoodList;
import com.mikeroelens.hungermoji.model.SelectPlayerList;
import com.mikeroelens.hungermoji.model.gamepiece.character.Player;
import com.mikeroelens.hungermoji.notification.BaseNotification;

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
