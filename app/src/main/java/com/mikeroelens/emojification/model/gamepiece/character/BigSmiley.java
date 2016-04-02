package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class BigSmiley extends Player {
    @Override
    public String getName() {
        return "Big Smiley";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_BIG_SMILEY_NORMAL;
    }

    @Override
    String getDeadEmoji() {
        return Emojis.CHAR_BIG_SMILEY_DEAD;
    }
}
