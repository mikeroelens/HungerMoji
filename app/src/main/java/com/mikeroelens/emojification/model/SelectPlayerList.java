package com.mikeroelens.emojification.model;

import com.mikeroelens.emojification.model.gamepiece.character.Alien;
import com.mikeroelens.emojification.model.gamepiece.character.BigSmiley;
import com.mikeroelens.emojification.model.gamepiece.character.Chicken;
import com.mikeroelens.emojification.model.gamepiece.character.Kitty;
import com.mikeroelens.emojification.model.gamepiece.character.Monkey;
import com.mikeroelens.emojification.model.gamepiece.character.Player;

import java.util.Arrays;
import java.util.List;

//TODO: is this the best arch pattern?
public class SelectPlayerList  {
    public static SelectItemList<Player> list = new SelectItemList<Player>() {
        @Override
        List<Player> getItems() {
            return Arrays.asList(
                    new BigSmiley(),
                    new Kitty(),
                    new Chicken(),
                    new Monkey(),
                    new Alien()
            );
        }
    };
}
