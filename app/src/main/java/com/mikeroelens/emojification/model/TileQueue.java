package com.mikeroelens.emojification.model;


import android.app.NotificationManager;

import com.mikeroelens.emojification.notification.TileNotification;

import java.util.LinkedList;
import java.util.Queue;

public class TileQueue  {
    private NotificationManager mNotificationManager;
    private Queue<TileNotification> tiles = new LinkedList<>();

    public TileQueue(NotificationManager notificationManager) {
        mNotificationManager = notificationManager;
    }

    public void enableDismissalOnAllTiles() {
        synchronized (TileQueue.class) {
            for (TileNotification tile : tiles) {
                tile.setOnGoing(false);
                tile.display(mNotificationManager);
            }
        }
    }

    public void add(TileNotification tile) {
        synchronized (TileQueue.class) {
            tile.display(mNotificationManager);
            tiles.add(tile);
        }
    }

    //TODO: Does it make sense for it to be cancelling the notification? or should that happen outside of this class
    //probably should when looking at removeById
    public TileNotification remove() {
        synchronized (TileQueue.class) {
            //TODO: Safeguard for empty queue
            mNotificationManager.cancel(tiles.peek().getId());
            return tiles.remove();
        }
    }

    public TileNotification removeById(int id) {
        synchronized (TileQueue.class) {
            for (TileNotification tile : tiles) {
                if (tile.getId() == id) {
                    tiles.remove(tile);
                    return tile;
                }
            }
            return null;
        }
    }

    public void removeAll() {
        synchronized (TileQueue.class) {
            while (!tiles.isEmpty()) {
                remove();
            }
        }
    }

    public TileNotification peek() {
        synchronized (TileQueue.class) {
            return tiles.peek();
        }
    }
}
