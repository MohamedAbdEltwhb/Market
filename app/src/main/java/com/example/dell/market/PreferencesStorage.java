package com.example.dell.market;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class PreferencesStorage {

    public static final String MY_PREFS = "MY_PREFS";

    public static String KEY_EMAIL = "email";
    public static String KEY_PASSWORD = "password";

    public static String KEY_NAME = "name";


    SharedPreferences mSharedPreferences;

    public PreferencesStorage(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public void putEmail(String email) {
        mSharedPreferences.edit().putString(KEY_EMAIL, email).apply();
    }

    public String getEmail() {
        return mSharedPreferences.getString(KEY_EMAIL, null);
    }

    public void putPassword(String password) {
        mSharedPreferences.edit().putString(KEY_PASSWORD, password).apply();
    }

    public String getPassword() {
        return mSharedPreferences.getString(KEY_PASSWORD, null);
    }



    public void putUserName(String name) {
        mSharedPreferences.edit().putString(KEY_NAME, name).apply();
    }

    public String getUserName() {
        return mSharedPreferences.getString(KEY_NAME, null);
    }
}
