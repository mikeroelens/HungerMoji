package com.mikeroelens.emojification.model.gamepiece.food;

import com.mikeroelens.emojification.model.Emojis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sweets extends FoodPiece {

    @Override
    public String getName() {
        return "Sweets";
    }

    private static List<String> emojis = new ArrayList<>(
            Arrays.asList(
                Emojis.ICE_CREAM_CONE,
                Emojis.DOUGHNUT,
                Emojis.SHORTCAKE,
                Emojis.CHOCOLATE_BAR,
                Emojis.CANDY,
                Emojis.LOLLIPOP,
                Emojis.DANGO
            )
    );

    @Override
    public List<String> getEmojis() {
        return emojis;
    }
}
