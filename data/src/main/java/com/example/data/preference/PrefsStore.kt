package com.example.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


interface PrefsStore {
    var lastActivityFetch: String?
}

class SharedPrefsStorage(
    context: Context
): PrefsStore {

    private val prefs: Lazy<SharedPreferences> = lazy {
        context.applicationContext.getSharedPreferences(
            PREFS_NAME, Context.MODE_PRIVATE
        )
    }

    override var lastActivityFetch: String?
        get() = prefs.value.getString(PREF_LAST_ACTIVITY_GLOBAL_FETCH, null)
        set(value) {
            prefs.value.edit { putString(PREF_LAST_ACTIVITY_GLOBAL_FETCH, value) }
        }

    companion object {
        private const val PREFS_NAME = "leginf"
        private const val PREF_LAST_ACTIVITY_GLOBAL_FETCH = "pref_last_activity_global_fetch"
    }
}
