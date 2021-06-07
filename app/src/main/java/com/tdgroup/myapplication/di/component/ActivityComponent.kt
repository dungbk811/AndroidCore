package com.tdgroup.myapplication.di.component

import com.tdgroup.myapplication.di.module.RepositoryModule
import com.tdgroup.myapplication.di.module.ViewModelModule
import com.tdgroup.myapplication.di.scope.ActivityScoped
import com.tdgroup.myapplication.ui.login.LoginActivity
import com.tdgroup.myapplication.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class,RepositoryModule::class])
@ActivityScoped
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : ActivityComponent
    }
}