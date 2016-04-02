package com.mikeroelens.emojification.model.gamepiece;


abstract public class GamePiece {
    public abstract String render();

    public int dismissedScoreDelta() {
        return 0;
    }
}
