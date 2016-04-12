package com.mikeroelens.emojification.model;


import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final public class Emojis {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            // Misc.
            EXPLOSION,
            BOMB,

            // Fruits
            GRAPE,
            WATERMELON,
            RED_APPLE,
            LEMON,
            CHERRY,
            BANANA,

            // Greasy
            BURGER,
            FRIES,
            PIZZA,
            BURRITO,
            TACO,
            HOTDOG,

            // Sweets

            ICE_CREAM_CONE,
            DOUGHNUT,
            SHORTCAKE,
            CHOCOLATE_BAR,
            CANDY,
            LOLLIPOP,
            DANGO,

            // Seafood
            SUSHI,
            SHRIMP,
            FISH_CAKE,
            ODEN,
            FISH,
            OCTOPUS,

            // Liquid Diet
            BABY_BOTTLE,
            COFFEE,
            WINE,
            COCKTAIL,
            TROPICAL_DRINK,
            BEER,

            // Bonus
            POINTING_RIGHT,
            POINTING_LEFT,
            TEN,

            // Characters
            CHAR_BIG_SMILEY,
            CHAR_KITTY,
            CHAR_ALIEN,
            CHAR_MONKEY,
            CHAR_COW,
            CHAR_MOUSE,
            CHAR_PIG,
            CHAR_FROG,
            CHAR_WOLF,
            CHAR_TIGER,
            CHAR_BEAR,
            CHAR_CHICK
    })
    public @interface Emoji {}

    // Misc.
    public static final String EXPLOSION = "\uD83D\uDCA5";
    public static final String BOMB = "\uD83D\uDCA3";

    // Characters
    public static final String CHAR_BIG_SMILEY = "\uD83D\uDE00";
    public static final String CHAR_KITTY = "\uD83D\uDE3A";
    public static final String CHAR_ALIEN = "\uD83D\uDC7D";
    public static final String CHAR_MONKEY = "\uD83D\uDC35";
    public static final String CHAR_COW = "\uD83D\uDC2E";
    public static final String CHAR_MOUSE = "\uD83D\uDC2D";
    public static final String CHAR_PIG = "\uD83D\uDC37";
    public static final String CHAR_FROG = "\uD83D\uDC38";
    public static final String CHAR_WOLF = "\uD83D\uDC3A";
    public static final String CHAR_TIGER = "\uD83D\uDC2F";
    public static final String CHAR_BEAR = "\uD83D\uDC3B";
    public static final String CHAR_CHICK = "\uD83D\uDC23";

    // Bonus
    public static final String POINTING_RIGHT = "\uD83D\uDC49";
    public static final String POINTING_LEFT = "\uD83D\uDC48";
    public static final String TEN = "\uD83D\uDD1F";

    // Fruit
    public static final String GRAPE = "\uD83C\uDF47";
    public static final String WATERMELON = "\uD83C\uDF49";
    public static final String RED_APPLE = "\uD83C\uDF4E";
    public static final String LEMON = "\uD83C\uDF4B";
    public static final String CHERRY = "\uD83C\uDF52";
    public static final String BANANA = "\uD83C\uDF4C";

    // Greasy
    public static final String BURGER = "\uD83C\uDF54";
    public static final String FRIES = "\uD83C\uDF5F";
    public static final String PIZZA = "\uD83C\uDF55";
    public static final String BURRITO = "\uD83C\uDF2F";
    public static final String TACO = "\uD83C\uDF2E";
    public static final String HOTDOG = "\uD83C\uDF2D";

    // Sweets
    public static final String ICE_CREAM_CONE = "\uD83C\uDF66";
    public static final String DOUGHNUT = "\uD83C\uDF69";
    public static final String SHORTCAKE = "\uD83C\uDF70";
    public static final String CHOCOLATE_BAR = "\uD83C\uDF6B";
    public static final String CANDY = "\uD83C\uDF6C";
    public static final String LOLLIPOP = "\uD83C\uDF6D";
    public static final String DANGO = "\uD83C\uDF61";

    // Seafood
    public static final String SUSHI = "\uD83C\uDF63";
    public static final String SHRIMP = "\uD83C\uDF64";
    public static final String FISH_CAKE = "\uD83C\uDF65";
    public static final String ODEN = "\uD83C\uDF62";
    public static final String FISH = "\uD83D\uDC1F";
    public static final String OCTOPUS = "\uD83D\uDC19";

    // Liquid Diet
    public static final String BABY_BOTTLE = "\uD83C\uDF7C";
    public static final String COFFEE = "☕";
    public static final String WINE = "\uD83C\uDF77";
    public static final String COCKTAIL = "\uD83C\uDF78";
    public static final String TROPICAL_DRINK = "\uD83C\uDF79";
    public static final String BEER = "\uD83C\uDF7A";
}
