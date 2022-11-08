package com.hwan3434.gplapplication.domain.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val autoLoginPref: SharedPreferences =
        context.getSharedPreferences(APP_GPL_DOCUMENT, Context.MODE_PRIVATE)

    var gplVersion: Int
        get() = autoLoginPref.getInt(GPL_VERSION, 0)
        set(value) {
            val editor = autoLoginPref.edit()
            editor.putInt(GPL_VERSION, 0)
            editor.apply()
        }

    companion object {
        private const val APP_GPL_DOCUMENT = "GPL_APPLICATION"
        const val GPL_VERSION = "GPL_VERSION"
    }
}