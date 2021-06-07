package com.tdgroup.myapplication.data.reposistory

import com.tdgroup.myapplication.data.remote.ApiHelper
import com.tdgroup.myapplication.data.local.DBHelperHelper
import com.tdgroup.myapplication.data.local.PreferenceHelper
import javax.inject.Inject

class MainRepository @Inject constructor(var apiHelper: ApiHelper, var preferenceHelper: PreferenceHelper, var dbHelperHelper: DBHelperHelper) :
    BaseRepository() {
}