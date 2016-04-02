package com.mikeroelens.emojification.model.gamepiece;

import com.mikeroelens.emojification.Emojis;

import java.util.Random;

public class BonusPiece extends GamePiece {
    @Override
    public int dismissedScoreDelta() {
        return 10;
    }

    @Override
    public String render() {
        if (new Random().nextInt(2) == 0) {
            return Emojis.POINTING_LEFT + "  " + Emojis.TEN;
        }
        else {
            return Emojis.TEN+ "  " + Emojis.POINTING_RIGHT;
        }
    }
}
