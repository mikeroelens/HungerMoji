package com.mikeroelens.emojification.model.gamepiece.food;

import com.mikeroelens.emojification.utils.DistributedRandomNumberGenerator;
import com.mikeroelens.emojification.model.gamepiece.GamePiece;

import java.util.List;

abstract public class FoodPiece extends GamePiece {
    abstract public List<String> getEmojis();
    abstract public String getName();
    private String randomEmoji;

    public FoodPiece() {
        DistributedRandomNumberGenerator drng = new DistributedRandomNumberGenerator();

        for (int i = 0; i < getEmojis().size(); i++) {
            drng.addNumber(i, (double) 1 / getEmojis().size());
        }
        randomEmoji = getEmojis().get(drng.getDistributedRandomNumber());
    }

    @Override
    public String render() {
        return randomEmoji;
    }

    @Override
    public int dismissedScoreDelta() {
        return -10;
    }

    //TODO: rename method?
    public String getStringSequence(){
        StringBuilder sb = new StringBuilder();

        for (String emoji: getEmojis()) {
            sb.append(emoji).append(" ");
        }

        return sb.toString();
    }
}
