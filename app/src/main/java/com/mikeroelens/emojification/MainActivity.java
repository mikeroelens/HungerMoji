package com.mikeroelens.emojification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.mikeroelens.emojification.model.SelectFoodList;
import com.mikeroelens.emojification.model.TileQueue;
import com.mikeroelens.emojification.model.gamepiece.Bomb;
import com.mikeroelens.emojification.model.gamepiece.GamePieceGenerator;
import com.mikeroelens.emojification.notification.FoodSelectNotification;
import com.mikeroelens.emojification.notification.PlayerNotification;
import com.mikeroelens.emojification.notification.PlayerSelectNotification;
import com.mikeroelens.emojification.notification.TileNotification;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends Activity {
    private AtomicInteger id = new AtomicInteger(2000);
    private TileQueue mTileQueue;
    private NotificationManager mNotificationManager;
    private PlayerNotification mPlayerNotification;
    private PlayerSelectNotification mPlayerSelectNotification;
    private FoodSelectNotification mFoodSelectNotification;
    private GameState mGameState = GameState.INSTRUCTIONS;
    Timer gameTimer;
    Button btnPlay;
    Button btnStop;

    //TODO: don't use enum?
    private enum GameState {
        INSTRUCTIONS,
        START_MENU,
        ACTIVE,
        GAME_OVER
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initStartMenu();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopGame();
            }
        });
    }

    //TODO: what if onDestroy doesnt get called?
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopGame();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent.getStringExtra("type") != null) {
            if (intent.getStringExtra("type").equals("NEXT_PLAYER")) {
                if (mGameState != GameState.ACTIVE) {
                    mPlayerSelectNotification.next();
                }
            }
            else if (intent.getStringExtra("type").equals("NEXT_FOOD")) {
                if (mGameState != GameState.ACTIVE) {
                    mFoodSelectNotification.next();
                }
            }
            else if (intent.getStringExtra("type").equals("TILE_DISMISSED")) {
                TileNotification removedTile = mTileQueue.removeById(intent.getIntExtra("notificationId", 0));
                addRandomTile();
                mPlayerNotification.updateScore(removedTile.getGamePiece().dismissedScoreDelta());
            }
            else if (intent.getStringExtra("type").equals("BEGIN_GAME")) {
                beginGame();
                mNotificationManager.cancel(4); //TODO: pull out these ids into constants
                mNotificationManager.cancel(3); //TODO: pull out these ids into constants
                mNotificationManager.cancel(2);
            }
        }
    }

    private void initStartMenu() {
        mGameState = GameState.START_MENU;

        NotificationCompat.Builder b = new NotificationCompat.Builder(this);

        b.setAutoCancel(false)
                .setWhen(4)
                .setSmallIcon(R.drawable.transparent)
                .setTicker(Long.toString(System.currentTimeMillis()))
                .setContentTitle("Select Character and Food") //TODO: localize
                .setContentText("Swipe notification for next option")
                .setDefaults(0)
                .setOngoing(true)
                .setSound(null);

        mNotificationManager.notify(4, b.build()); //TODO: pull ID out into constant

        mPlayerSelectNotification = new PlayerSelectNotification(this, mNotificationManager);
        mPlayerSelectNotification.display();


        mFoodSelectNotification = new FoodSelectNotification(this, mNotificationManager);
        mFoodSelectNotification.display();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("type", "BEGIN_GAME"); //TODO: pull out into constant?
        PendingIntent pi = PendingIntent.getActivity(this, 1, intent, 0); //TODO: should we pass 0's?

        b.setAutoCancel(false)
                .setWhen(1)
                .setSmallIcon(R.drawable.transparent)
                .setTicker(Long.toString(System.currentTimeMillis()))
                .setContentTitle("BEGIN!") //TODO: localize
                .setContentText("-------------------------->")
                .setDefaults(0)
                .setOngoing(false)
                .setSound(null)
                .setDeleteIntent(pi);

        mNotificationManager.notify(1, b.build()); //TODO: pull ID out into constant

        //TODO: figure out a way to center character
    }

    private void beginGame() {
        mGameState = GameState.ACTIVE;
        mTileQueue = new TileQueue(mNotificationManager);
        mPlayerNotification = new PlayerNotification(this, mNotificationManager);
        mPlayerNotification.display();

        initializeTiles();

        gameTimer = new Timer();

        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                TileNotification upcomingTile = mTileQueue.peek();
                mPlayerNotification.updatePosition(upcomingTile.getPosition());
                mPlayerNotification.updateScore(1);

                if (upcomingTile.getGamePiece() instanceof Bomb) {
                    mTileQueue.removeAll();
                    gameTimer.cancel();
                    mPlayerNotification.explode();
                    return;
                }

                addRandomTile();
                mTileQueue.remove(); //TODO: NEED TO MAKE SURE tiles isn't empty
            }
        }, 0, Config.GAME_SPEED);//put here time 1000 milliseconds=1 second
    }

    private void initializeTiles() {
        for (int i = 0; i < Config.NUM_GAME_PIECES; i++) {
            mTileQueue.add(new TileNotification(this, id.decrementAndGet(), getRandomPosition(), SelectFoodList.list.getCurrentItem()));
        }
    }

    private void addRandomTile() {
        mTileQueue.add(new TileNotification(this, id.decrementAndGet(), getRandomPosition(), GamePieceGenerator.random()));
    }

    private int getRandomPosition() {
        return new Random().nextInt(40) + 1;
    }

    private void stopGame() {
        gameTimer.cancel();
        mTileQueue.removeAll();
        mPlayerNotification.remove();
    }
}