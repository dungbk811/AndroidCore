package com.tdgroup.myapplication.di.component

import com.tdgroup.myapplication.di.scope.LoggedUserScoped
import com.tdgroup.myapplication.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent()
@LoggedUserScoped
interface UserComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }
}