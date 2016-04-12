package com.mikeroelens.emojification.model.gamepiece.character;

import android.support.annotation.IntDef;

import com.mikeroelens.emojification.Emojis;
import com.mikeroelens.emojification.Emojis.Emoji;
import com.mikeroelens.emojification.HungerMojiApplication;
import com.mikeroelens.emojification.model.gamepiece.GamePiece;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

abstract public class Player extends GamePiece {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            STATE_NORMAL,
            STATE_EXPLOSION
    })
    public @interface State {}
    public static final int STATE_NORMAL = 1;
    public static final int STATE_EXPLOSION = 2;

    private @State int state = STATE_NORMAL;

    protected abstract int getNameResourceId();
    abstract @Emoji String getNormalEmoji();

    @Override
    public String render() {
        switch (state) {
            case STATE_EXPLOSION: return Emojis.EXPLOSION;
            default: return getNormalEmoji();
        }
    }

    public String getName() {
        return HungerMojiApplication.getContext().getString(getNameResourceId());
    }

    public void setState(@State int state) {
        this.state = state;
    }
}
