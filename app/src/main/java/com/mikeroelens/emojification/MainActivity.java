package com.mikeroelens.emojification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mikeroelens.emojification.game.Game;
import com.mikeroelens.emojification.model.SelectFoodList;
import com.mikeroelens.emojification.model.TileQueue;
import com.mikeroelens.emojification.model.gamepiece.Bomb;
import com.mikeroelens.emojification.model.gamepiece.GamePieceGenerator;
import com.mikeroelens.emojification.notification.PlayerNotification;
import com.mikeroelens.emojification.notification.TileNotification;
import com.mikeroelens.emojification.startmenu.StartMenu;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends Activity {
    private NotificationManager mNotificationManager;
    private Game mGame;

    Button btnPlay;
    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mGame = new Game(this, mNotificationManager);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGame.displayStartMenu();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGame.stop();
            }
        });
    }

    //TODO: what if onDestroy doesnt get called?
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGame.stop();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent.getStringExtra(NotificationAction.KEY_ACTION) != null) {
            String action = intent.getStringExtra(NotificationAction.KEY_ACTION);

            switch (action) {
                case NotificationAction.NEXT_PLAYER:
                    mGame.nextPlayer();
                    break;

                case NotificationAction.NEXT_FOOD:
                    mGame.nextFood();
                    break;

                case NotificationAction.TILE_DISMISSED:
                    mGame.tileRemoved(intent.getIntExtra(NotificationAction.KEY_NOTIFICATION_ID, 0));
                    break;

                case NotificationAction.BEGIN_GAME:
                    mGame.startGamePlay();
                    break;

            }
        }
    }

}