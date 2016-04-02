package com.mikeroelens.emojification.game;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;

import com.mikeroelens.emojification.Config;
import com.mikeroelens.emojification.model.SelectFoodList;
import com.mikeroelens.emojification.model.TileQueue;
import com.mikeroelens.emojification.model.gamepiece.Bomb;
import com.mikeroelens.emojification.model.gamepiece.GamePieceGenerator;
import com.mikeroelens.emojification.model.gamepiece.character.Player;
import com.mikeroelens.emojification.notification.PlayerNotification;
import com.mikeroelens.emojification.notification.TileNotification;
import com.mikeroelens.emojification.startmenu.StartMenu;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    //TODO: don't use enum?
    private enum GameState {
        INSTRUCTIONS,
        START_MENU,
        ACTIVE,
        GAME_OVER
    }

    private AtomicInteger id = new AtomicInteger(2000);
    private TileQueue mTileQueue;
    private NotificationManager mNotificationManager;
    private Context mContext;
    private PlayerNotification mPlayerNotification;
    private GameState mGameState = GameState.INSTRUCTIONS;
    private StartMenu mStartMenu;
    Timer gameTimer;

    public Game(Context context, NotificationManager notificationManager) {
        mContext = context;
        mNotificationManager = notificationManager;
    }

    public void startGamePlay() {
        mGameState = GameState.ACTIVE;
        mTileQueue = new TileQueue(mNotificationManager);
        mPlayerNotification = new PlayerNotification(mContext);
        mPlayerNotification.display(mNotificationManager);

        initializeTiles();
        mStartMenu.remove();

        gameTimer = new Timer();

        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                TileNotification upcomingTile = mTileQueue.peek();
                mPlayerNotification.updatePosition(upcomingTile.getPosition());
                mPlayerNotification.updateScore(1);
                mPlayerNotification.display(mNotificationManager);

                if (upcomingTile.getGamePiece() instanceof Bomb) {
                    mTileQueue.removeAll();
                    gameTimer.cancel();
                    killPlayer();
                    return;
                }

                addRandomTile();
                mTileQueue.remove(); //TODO: NEED TO MAKE SURE tiles isn't empty
            }
        }, 0, Config.GAME_SPEED);//put here time 1000 milliseconds=1 second
    }

    public void displayStartMenu() {
        mGameState = GameState.START_MENU;
        mStartMenu = new StartMenu(mContext, mNotificationManager);
        mStartMenu.display();
    }

    public void nextPlayer() {
        if (mGameState == GameState.START_MENU) {
            mStartMenu.nextPlayer();
        }
    }

    public void nextFood() {
        if (mGameState == GameState.START_MENU) {
            mStartMenu.nextFood();
        }
    }

    private void killPlayer() {
        mPlayerNotification.explode();
        mPlayerNotification.display(mNotificationManager);

        //TODO: is this hacky? will getMainLooper technically only work for Activities?
        new Handler(mContext.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPlayerNotification.kill();
                mPlayerNotification.display(mNotificationManager);
            }
        }, 600);

    }

    public void tileRemoved(int notificationId) {
        TileNotification removedTile = mTileQueue.removeById(notificationId);
        addRandomTile();
        mPlayerNotification.updateScore(removedTile.getGamePiece().dismissedScoreDelta());
    }

    public void stop() {
        gameTimer.cancel();
        mTileQueue.removeAll();
        mNotificationManager.cancelAll();
    }

    private void initializeTiles() {
        for (int i = 0; i < Config.NUM_GAME_PIECES; i++) {
            mTileQueue.add(new TileNotification(mContext, id.decrementAndGet(), getRandomPosition(), SelectFoodList.list.getCurrentItem()));
        }
    }

    private void addRandomTile() {
        mTileQueue.add(new TileNotification(mContext, id.decrementAndGet(), getRandomPosition(), GamePieceGenerator.random()));
    }

    private int getRandomPosition() {
        return new Random().nextInt(40) + 1;
    }
}
