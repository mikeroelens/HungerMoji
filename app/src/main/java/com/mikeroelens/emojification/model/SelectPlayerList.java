package com.mikeroelens.emojification.model;

import com.mikeroelens.emojification.model.gamepiece.character.*;

import java.util.Arrays;
import java.util.List;

public class SelectPlayerList  {
    public static SelectItemList<Player> list = new SelectItemList<Player>() {
        @Override
        List<Player> getItems() {
            return Arrays.asList(
                    new BigSmiley(),
                    new Monkey(),
                    new Alien(),
                    new Bear(),
                    new Cow(),
                    new Kitty(),
                    new Chick(),
                    new Frog(),
                    new Mouse(),
                    new Pig(),
                    new Tiger(),
                    new Wolf()
            );
        }
    };
}
