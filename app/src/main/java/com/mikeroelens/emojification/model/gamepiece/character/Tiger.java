package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Tiger extends Player {
    @Override
    public String getName() {
        return "Tiger";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_TIGER;
    }
}
