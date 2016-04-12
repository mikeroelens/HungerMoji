package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.model.Emojis;
import com.mikeroelens.emojification.R;

public class Wolf extends Player {
    @Override
    public int getNameResourceId() {
        return R.string.character_name_wolf;
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_WOLF;
    }
}
