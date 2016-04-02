package com.mikeroelens.emojification.model.gamepiece.food;

import com.mikeroelens.emojification.utils.DistributedRandomNumberGenerator;
import com.mikeroelens.emojification.model.gamepiece.GamePiece;

import java.util.List;

abstract public class FoodPiece extends GamePiece {
    abstract public List<String> getEmojis();
    abstract public String getName();

    private DistributedRandomNumberGenerator randomNumberGenerator;

    public FoodPiece() {
        randomNumberGenerator = new DistributedRandomNumberGenerator();

        for (int i = 0; i < getEmojis().size(); i++) {
            randomNumberGenerator.addNumber(i, (double) 1 / getEmojis().size());
        }
    }

    @Override
    public String render() {
        return getEmojis().get(randomNumberGenerator.getDistributedRandomNumber());
    }

    @Override
    public int dismissedScoreDelta() {
        return -10;
    }

    //TODO: rename method?
    public String getStringSequence(){
        StringBuilder sb = new StringBuilder();

        for (String emoji: getEmojis()) {
            sb.append(emoji + " ");
        }

        return sb.toString();
    }
}
