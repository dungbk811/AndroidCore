package com.tdgroup.myapplication.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tdgroup.myapplication.di.scope.AppScoped
import com.tdgroup.myapplication.viewmodel.BaseViewModel
import com.tdgroup.myapplication.viewmodel.LoginViewModel
import com.tdgroup.myapplication.viewmodel.ViewModelFactory
import com.tdgroup.myapplication.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @AppScoped
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}