package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Mouse extends Player {
    @Override
    public String getName() {
        return "Mouse";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_MOUSE;
    }
}
