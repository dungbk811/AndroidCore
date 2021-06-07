package com.tdgroup.myapplication.application


import com.tdgroup.myapplication.di.component.DaggerApplicationComponent
import com.tdgroup.myapplication.di.module.UtilModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject


class MyApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }


}