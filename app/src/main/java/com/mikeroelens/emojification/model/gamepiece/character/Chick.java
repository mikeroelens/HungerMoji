package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.Emojis;
import com.mikeroelens.emojification.R;

public class Chick extends Player {
    @Override
    public int getNameResourceId() {
        return R.string.character_name_chick;
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_CHICK;
    }
}
