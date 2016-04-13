package com.mikeroelens.hungermoji.model.gamepiece.character;

import com.mikeroelens.hungermoji.model.Emojis;
import com.mikeroelens.hungermoji.R;

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
