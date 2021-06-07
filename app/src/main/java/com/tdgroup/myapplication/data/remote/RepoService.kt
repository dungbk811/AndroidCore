package com.tdgroup.myapplication.data.remote

import com.tdgroup.myapplication.data.model.BaseResponse
import com.tdgroup.myapplication.data.model.UserProfile
import io.reactivex.Single
import retrofit2.http.POST

interface RepoService {

    @POST("users")
    fun login(): Single<BaseResponse<UserProfile>>
}