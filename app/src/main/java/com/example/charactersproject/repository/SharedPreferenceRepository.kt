package com.example.charactersproject.repository

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val GLOBAL_PREF = "global_pref"
private const val FIRST_START = "first_start"

@Singleton
class SharedPreferenceRepository (context: Context) {

    private val globalPreference = context.getSharedPreferences(GLOBAL_PREF, Context.MODE_PRIVATE)

    fun firstStart(): Boolean {
        return globalPreference.getBoolean(FIRST_START, false)
    }

    fun notFirstStart() {
        globalPreference.edit {
            putBoolean(FIRST_START, true)
        }
    }
}