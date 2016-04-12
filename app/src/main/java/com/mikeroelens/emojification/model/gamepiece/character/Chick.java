package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Chick extends Player {
    @Override
    public String getName() {
        return "Chick";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_CHICK;
    }
}
