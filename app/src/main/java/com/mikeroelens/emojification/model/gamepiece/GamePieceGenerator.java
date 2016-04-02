package com.mikeroelens.emojification.model.gamepiece;

import com.mikeroelens.emojification.model.SelectFoodList;
import com.mikeroelens.emojification.model.gamepiece.Bomb;
import com.mikeroelens.emojification.model.gamepiece.BonusPiece;
import com.mikeroelens.emojification.model.gamepiece.GamePiece;
import com.mikeroelens.emojification.utils.DistributedRandomNumberGenerator;

public class GamePieceGenerator {

    public static GamePiece random() {
        //TODO: Refactor this, shouldn't have to create DistributedRandomNumberGenerator everytime
        DistributedRandomNumberGenerator drng = new DistributedRandomNumberGenerator();
        drng.addNumber(1, 0.20d);
        drng.addNumber(2, 0.025d);
        drng.addNumber(3, 0.775d);

        switch (drng.getDistributedRandomNumber()) {
            case 1: return new Bomb();
            case 2: return new BonusPiece();
            default: return SelectFoodList.list.getCurrentItem();
        }
    }
}
