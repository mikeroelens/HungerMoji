package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;

public class Monkey extends Player {
    @Override
    public String getName() {
        return "Monkey";
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_MONKEY_NORMAL;
    }

    @Override
    String getDeadEmoji() {
        return Emojis.CHAR_MONKEY_DEAD;
    }
}
