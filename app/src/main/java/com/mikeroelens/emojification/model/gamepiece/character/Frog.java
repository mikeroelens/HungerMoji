package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.model.Emojis;
import com.mikeroelens.emojification.R;

public class Frog extends Player {
    @Override
    public int getNameResourceId() {
        return R.string.character_name_frog;
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_FROG;
    }
}
