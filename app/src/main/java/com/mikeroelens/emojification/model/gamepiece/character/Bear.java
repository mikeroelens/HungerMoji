package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Bear extends Player {
    @Override
    public String getName() {
        return "Bear";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_BEAR;
    }
}
