package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Kitty extends Player {
    @Override
    public String getName() {
        return "Kitty";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_KITTY;
    }
}
