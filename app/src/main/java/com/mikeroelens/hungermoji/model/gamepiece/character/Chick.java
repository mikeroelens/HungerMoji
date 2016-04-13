package com.mikeroelens.hungermoji.model.gamepiece.character;

import com.mikeroelens.hungermoji.model.Emojis;
import com.mikeroelens.hungermoji.R;

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
