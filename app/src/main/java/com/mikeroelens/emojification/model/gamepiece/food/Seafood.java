package com.mikeroelens.emojification.model.gamepiece.food;

import com.mikeroelens.emojification.Emojis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seafood extends FoodPiece {

    @Override
    public String getName() {
        return "Seafood";
    }

    private static List<String> emojis = new ArrayList<>(
        Arrays.asList(
            Emojis.SUSHI,
            Emojis.SHRIMP,
            Emojis.FISH,
            Emojis.FISH_CAKE,
            Emojis.ODEN,
            Emojis.OCTOPUS
        )
    );

    @Override
    public List<String> getEmojis() {
        return emojis;
    }
}
