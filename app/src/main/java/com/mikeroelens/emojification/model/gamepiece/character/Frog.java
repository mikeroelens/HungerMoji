package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Frog extends Player {
    @Override
    public String getName() {
        return "Frog";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_FROG;
    }
}
