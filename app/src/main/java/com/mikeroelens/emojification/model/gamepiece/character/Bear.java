package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;
import com.mikeroelens.emojification.R;

public class Bear extends Player {
    @Override
    public int getNameResourceId() {
        return R.string.character_name_bear;
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_BEAR;
    }
}
