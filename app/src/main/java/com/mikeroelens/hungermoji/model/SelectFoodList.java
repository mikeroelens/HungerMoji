package com.mikeroelens.hungermoji.model;

import com.mikeroelens.hungermoji.model.gamepiece.food.FoodPiece;
import com.mikeroelens.hungermoji.model.gamepiece.food.Fruit;
import com.mikeroelens.hungermoji.model.gamepiece.food.Greasy;
import com.mikeroelens.hungermoji.model.gamepiece.food.LiquidDiet;
import com.mikeroelens.hungermoji.model.gamepiece.food.Seafood;
import com.mikeroelens.hungermoji.model.gamepiece.food.Sweets;

import java.util.Arrays;
import java.util.List;

public class SelectFoodList  {
    public static SelectItemList<FoodPiece> list = new SelectItemList<FoodPiece>() {
        @Override
        List<FoodPiece> getItems() {
            return Arrays.asList(
                new Fruit(),
                new Sweets(),
                new Seafood(),
                new LiquidDiet(),
                new Greasy()
            );
        }
    };
}
