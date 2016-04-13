package com.mikeroelens.hungermoji.model.gamepiece.character;

import android.support.annotation.IntDef;

import com.mikeroelens.hungermoji.model.Emojis;
import com.mikeroelens.hungermoji.model.Emojis.Emoji;
import com.mikeroelens.hungermoji.HungerMojiApplication;
import com.mikeroelens.hungermoji.model.gamepiece.GamePiece;

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
