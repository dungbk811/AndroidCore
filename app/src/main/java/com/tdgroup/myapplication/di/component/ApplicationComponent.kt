package com.tdgroup.myapplication.di.component

import com.tdgroup.myapplication.application.MyApplication
import com.tdgroup.myapplication.di.module.*
import com.tdgroup.myapplication.di.scope.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@AppScoped
@Component( modules = [UtilModule::class,ApiModule::class, ViewModelModule::class, RepositoryModule::class,ActivityBuilder::class,AndroidSupportInjectionModule::class])
interface ApplicationComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): ApplicationComponent
    }

}