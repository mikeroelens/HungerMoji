package com.mikeroelens.emojification.model.gamepiece.food;

import com.mikeroelens.emojification.Emojis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fruit extends FoodPiece {

    @Override
    public String getName() {
        return "Fruit";
    }

    private static List<String> emojis = new ArrayList<>(
        Arrays.asList(
            Emojis.GRAPE,
            Emojis.WATERMELON,
            Emojis.RED_APPLE,
            Emojis.LEMON,
            Emojis.CHERRY,
            Emojis.BANANA
        )
    );

    @Override
    public List<String> getEmojis() {
        return emojis;
    }
}
