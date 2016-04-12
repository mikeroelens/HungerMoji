package com.mikeroelens.emojification.model.gamepiece.character;

import com.mikeroelens.emojification.model.Emojis;
import com.mikeroelens.emojification.R;

public class Mouse extends Player {
    @Override
    public int getNameResourceId() {
        return R.string.character_name_mouse;
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_MOUSE;
    }
}
