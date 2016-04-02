package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Alien extends Player {
    @Override
    public String getName() {
        return "Alien";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_ALIEN_NORMAL;
    }

    @Override
    String getDeadEmoji() {
        return Emojis.CHAR_ALIEN_DEAD;
    }
}
