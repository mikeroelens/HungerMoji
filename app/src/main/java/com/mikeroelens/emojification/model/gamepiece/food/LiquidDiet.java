package com.mikeroelens.emojification.model.gamepiece.food;

import com.mikeroelens.emojification.Emojis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiquidDiet extends FoodPiece {
    @Override
    public String getName() {
        return "Liquid Diet";
    }

    private static List<String> emojis = new ArrayList<>(
            Arrays.asList(
                    Emojis.BABY_BOTTLE,
                    Emojis.COFFEE,
                    Emojis.WINE,
                    Emojis.COCKTAIL,
                    Emojis.TROPICAL_DRINK,
                    Emojis.BEER
            )
    );

    @Override
    public List<String> getEmojis() {
        return emojis;
    }
}
