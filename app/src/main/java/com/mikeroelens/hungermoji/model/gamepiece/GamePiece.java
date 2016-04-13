package com.mikeroelens.hungermoji.model.gamepiece;


abstract public class GamePiece {
    public abstract String render();

    public int dismissedScoreDelta() {
        return 0;
    }
}
