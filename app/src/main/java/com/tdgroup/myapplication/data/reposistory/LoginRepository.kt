package com.tdgroup.myapplication.data.reposistory

import com.tdgroup.myapplication.data.remote.ApiHelper
import com.tdgroup.myapplication.data.local.DBHelperHelper
import com.tdgroup.myapplication.data.local.PreferenceHelper
import com.tdgroup.myapplication.data.model.UserProfile
import javax.inject.Inject

class LoginRepository @Inject constructor(var apiHelper: ApiHelper, var preferenceHelper: PreferenceHelper, var dbHelperHelper: DBHelperHelper) :
    BaseRepository() {

    fun login(username: String, password: String) =  apiHelper.repoService.login()

    fun cacheUser(userProfile: UserProfile) {
        preferenceHelper.cacheUser(userProfile)
    }

    fun setIsLogin(isLogin : Boolean) {
        preferenceHelper.setLoggedIn(isLogin)
    }

    fun isLoggedIn() = preferenceHelper.isLoggedIn()
}