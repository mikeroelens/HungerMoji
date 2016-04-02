package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Chicken extends Player {
    @Override
    public String getName() {
        return "Chicken";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_CHICKEN_NORMAL;
    }

    @Override
    String getDeadEmoji() {
        return Emojis.CHAR_CHICKEN_DEAD;
    }
}
