package com.mikeroelens.hungermoji.model.gamepiece;

import com.mikeroelens.hungermoji.model.Emojis;

import java.util.Random;

public class BonusPiece extends GamePiece {
    private static final Rnadom PRNG = new Random();

    @Override
    public int dismissedScoreDelta() {
        return 10;
    }

    @Override
    public String render() {
        if (PRNG.nextInt(2) == 0) {
            return Emojis.POINTING_LEFT + "  " + Emojis.TEN;
        }
        else {
            return Emojis.TEN+ "  " + Emojis.POINTING_RIGHT;
        }
    }
}
