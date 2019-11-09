package com.hazem.advansysnasatask.extension

import android.content.Context
import androidx.preference.PreferenceManager

const val USER_CUREENT_THEME = "cureent_theme"

fun Context.saveToSharedPreference(key: String, value: Boolean) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
    val editor = preferences.edit()
    editor.putBoolean(key, value)
    editor.apply()
}

fun Context.saveToSharedPreference(key: String, value: String) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
    val editor = preferences.edit()
    editor.putString(key, value)
    editor.apply()
}

fun Context.saveToSharedPreference(key: String, value: Int) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
    val editor = preferences.edit()
    editor.putInt(key, value)
    editor.apply()
}


fun Context.getSavedFromSharedPreference(key: String, defaultValue: String): String {
    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
    return preferences.getString(key, defaultValue) ?: defaultValue
}

fun Context.getSavedFromSharedPreference(key: String, defaultValue: Boolean): Boolean {
    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
    return preferences.getBoolean(key, defaultValue)
}

fun Context.getSavedFromSharedPreference(key: String, defaultValue: Int): Int {
    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
    return preferences.getInt(key, defaultValue)
}