package com.mikeroelens.hungermoji.model.gamepiece;

import com.mikeroelens.hungermoji.Config;
import com.mikeroelens.hungermoji.model.SelectFoodList;
import com.mikeroelens.hungermoji.utils.DistributedRandomNumberGenerator;

public class GamePieceGenerator {
    final private static int BOMB = 1;
    final private static int BONUS_PIECE = 2;
    final private static int FOOD_PIECE = 3;
    private static int tilesSinceLastBomb = Config.NUM_GAME_PIECES; // Game is initialized with NUM_GAME_PIECES food pieces

    private static DistributedRandomNumberGenerator drng = new DistributedRandomNumberGenerator();
    static {
        drng.addNumber(BOMB, 0.20d);
        drng.addNumber(BONUS_PIECE, 0.025d);
        drng.addNumber(FOOD_PIECE, 0.775d);
    }

    public static GamePiece random() {
        if (tilesSinceLastBomb == Config.NUM_GAME_PIECES + 2) {
            tilesSinceLastBomb = 0;
            return new Bomb();
        }

        switch (drng.getDistributedRandomNumber()) {
            case BOMB:
                tilesSinceLastBomb = 0;
                return new Bomb();

            case BONUS_PIECE:
                tilesSinceLastBomb++;
                return new BonusPiece();

            default:
                tilesSinceLastBomb++;
                return SelectFoodList.list.getCurrentItem();
        }
    }
}
