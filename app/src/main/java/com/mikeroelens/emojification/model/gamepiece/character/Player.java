package com.mikeroelens.emojification.model.gamepiece.character;

import android.support.annotation.IntDef;

import com.mikeroelens.emojification.Emojis;
import com.mikeroelens.emojification.Emojis.Emoji;
import com.mikeroelens.emojification.model.gamepiece.GamePiece;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

abstract public class Player extends GamePiece {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            STATE_NORMAL,
            STATE_EXPLOSION,
            STATE_DEAD
    })
    public @interface State {}
    public static final int STATE_NORMAL = 1;
    public static final int STATE_EXPLOSION = 2;
    public static final int STATE_DEAD = 3;

    private @State int state = STATE_NORMAL;

    public abstract String getName();
    abstract @Emoji String getNormalEmoji();
    abstract @Emoji String getDeadEmoji();

    @Override
    public String render() {
        switch (state) {
            case STATE_EXPLOSION: return Emojis.EXPLOSION;
            case STATE_DEAD: return getDeadEmoji();
            default: return getNormalEmoji();
        }

    }

    public void setState(@State int state) {
        this.state = state;
    }
}
