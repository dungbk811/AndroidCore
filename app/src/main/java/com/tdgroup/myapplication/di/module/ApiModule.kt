package com.tdgroup.myapplication.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.tdgroup.myapplication.di.qualifier.AuthenticationRetrofit
import com.tdgroup.myapplication.di.qualifier.NoAuthenticationRetrofit
import com.tdgroup.myapplication.data.remote.RepoService
import com.tdgroup.myapplication.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

@Module
class ApiModule {
    @Provides
    @AuthenticationRetrofit
    fun provideRetrofitAuthentication(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @NoAuthenticationRetrofit
    fun provideRetrofitNoAuthentication(baseUrl: String, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    fun provideOKHttp(context : Context): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

        val cacheDir = File(context.cacheDir, UUID.randomUUID().toString())
        // 15 MiB cache
        val cache = Cache(cacheDir, 15 * 1024 * 1024)
        return OkHttpClient.Builder()
            .cache(
                cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build() }

    @Provides
    fun provideBaseUrl(): String {
        return Constants.BASE_URL
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().setDateFormat("ddMMyyyy").create()
    }

    @Provides
    @NoAuthenticationRetrofit
    fun provideMainService(@NoAuthenticationRetrofit retrofit: Retrofit) : RepoService {
        return retrofit.create(RepoService::class.java)
    }

    @Provides
    @AuthenticationRetrofit
    fun provideMainServiceNoAuthentication(@AuthenticationRetrofit retrofit: Retrofit) : RepoService {
        return retrofit.create(RepoService::class.java)
    }


//    @
}