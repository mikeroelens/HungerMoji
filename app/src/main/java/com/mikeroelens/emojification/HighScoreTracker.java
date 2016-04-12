package com.mikeroelens.emojification;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class HighScoreTracker {
    private static final String HIGH_SCORE_PREFS = "HighScorePrefs";
    private static final String HIGH_SCORE_KEY = "HighScoreKey";

    public static void newScore(Context context, int score) {
        if (score > getHighScore(context)) {
            SharedPreferences sp = context.getSharedPreferences(HIGH_SCORE_PREFS, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt(HIGH_SCORE_KEY, score);
            editor.apply();
        }
    }

    public static int getHighScore(Context context) {
        SharedPreferences sp = context.getSharedPreferences(HIGH_SCORE_PREFS, Activity.MODE_PRIVATE);
        return sp.getInt(HIGH_SCORE_KEY, -9999);
    }
}
