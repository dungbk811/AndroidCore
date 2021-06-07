package com.tdgroup.myapplication.di.module

import com.tdgroup.myapplication.di.scope.ActivityScoped
import com.tdgroup.myapplication.ui.login.LoginActivity
import com.tdgroup.myapplication.ui.main.MainActivity
import com.tdgroup.myapplication.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    @ActivityScoped
    abstract fun contributeLoginScreen() : LoginActivity

    @ContributesAndroidInjector
    @ActivityScoped
    abstract fun contributeMainScreen() : MainActivity

    @ContributesAndroidInjector
    @ActivityScoped
    abstract fun contributeSplashScreen() : SplashActivity
}