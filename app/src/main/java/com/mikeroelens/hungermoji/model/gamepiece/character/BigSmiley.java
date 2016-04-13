package com.mikeroelens.hungermoji.model.gamepiece.character;

import com.mikeroelens.hungermoji.model.Emojis;
import com.mikeroelens.hungermoji.R;

public class BigSmiley extends Player {
    @Override
    public int getNameResourceId() {
        return R.string.character_name_big_smiley;
    }

    @Override
    String getNormalEmoji() {
        return Emojis.CHAR_BIG_SMILEY;
    }
}
