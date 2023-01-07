package com.example.androidfall2022.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationData {
    private static final String APP_KEY = "android_course_key";


    // save a String value by key by APP_KEY
    public static void setStringValueInSharedPreferences(Context context, String appKey, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(appKey,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    // save a String value by key
    public static void setStringValueInSharedPreferences(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationData.APP_KEY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    // get a String value by key
    public static String getStringValueFromSharedPreferences(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationData.APP_KEY,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    // save an int value by key
    public static void setIntValueInSharedPreferences(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationData.APP_KEY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    // get an int value by key
    public static int getIntValueFromSharedPreferences(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationData.APP_KEY,
                Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }


    // delete a value by key
    public static void deleteValueFromSharedPreferences(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationData.APP_KEY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    // delete all values
    public static void deleteAllValuesFromSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationData.APP_KEY,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}