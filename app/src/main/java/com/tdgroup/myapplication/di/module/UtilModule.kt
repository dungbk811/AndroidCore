package com.tdgroup.myapplication.di.module

import android.content.Context
import com.tdgroup.myapplication.application.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class UtilModule {
    @Singleton
    @Provides
    fun provideContext(application: MyApplication): Context {
        return application
    }

//    @Singleton
//    @Provides
//    fun provideUtils(context: Context?): Utils {
//        return Utils(context)
//    }
}