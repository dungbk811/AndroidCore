package com.tdgroup.myapplication.data.remote

import com.tdgroup.myapplication.di.qualifier.AuthenticationRetrofit
import javax.inject.Inject

class ApiHelper @Inject constructor(@AuthenticationRetrofit val repoService: RepoService) {
}