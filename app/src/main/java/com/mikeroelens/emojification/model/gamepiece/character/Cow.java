package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Cow extends Player {
    @Override
    public String getName() {
        return "Cow";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_COW;
    }
}
