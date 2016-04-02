package com.mikeroelens.emojification.model;

import com.mikeroelens.emojification.model.gamepiece.food.FoodPiece;
import com.mikeroelens.emojification.model.gamepiece.food.Fruit;
import com.mikeroelens.emojification.model.gamepiece.food.Greasy;
import com.mikeroelens.emojification.model.gamepiece.food.Seafood;
import com.mikeroelens.emojification.model.gamepiece.food.Sweets;

import java.util.Arrays;
import java.util.List;

//TODO: is this the best arch pattern?
public class SelectFoodList  {
    public static SelectItemList<FoodPiece> list = new SelectItemList<FoodPiece>() {
        @Override
        List<FoodPiece> getItems() {
            return Arrays.asList(
                new Fruit(),
                new Greasy(),
                new Sweets(),
                new Seafood()
            );
        }
    };
}
