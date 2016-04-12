package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Pig extends Player {
    @Override
    public String getName() {
        return "Pig";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_PIG;
    }
}
