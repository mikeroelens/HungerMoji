package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.model.Emojis;
import com.mikeroelens.emojification.R;

public class Pig extends Player {
    @Override
    public int getNameResourceId() {
        return R.string.character_name_pig;
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_PIG;
    }
}
