package com.tdgroup.myapplication.data.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.tdgroup.myapplication.data.model.UserProfile
import com.tdgroup.myapplication.util.Constants
import javax.inject.Inject


class PreferenceHelper @Inject constructor(val context: Context,val gson: Gson) {


    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    init {
        sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        editor?.apply()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor!!.putBoolean(Constants.IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor!!.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return sharedPreferences!!.getBoolean(Constants.IS_FIRST_TIME_LAUNCH, true)
    }

    fun cacheUser(profile: UserProfile?) {
        val user = gson!!.toJson(profile)
        editor!!.putString(Constants.CACHED_USER, user)
    }

    fun getCachedUser(): UserProfile? {
        val user = sharedPreferences!!.getString(Constants.CACHED_USER, null)
        return gson!!.fromJson(user, UserProfile::class.java)
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences!!.getBoolean(Constants.LOGGED_IN, false)
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        editor!!.putBoolean(Constants.LOGGED_IN, isLoggedIn)
        editor!!.commit()
    }
}