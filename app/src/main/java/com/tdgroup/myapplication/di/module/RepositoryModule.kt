package com.tdgroup.myapplication.di.module

import com.tdgroup.myapplication.di.scope.AppScoped
import com.tdgroup.myapplication.data.reposistory.BaseRepository
import com.tdgroup.myapplication.data.reposistory.LoginRepository
import com.tdgroup.myapplication.data.reposistory.MainRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    @AppScoped
    abstract fun provideMainRepository(repository: MainRepository) : BaseRepository

    @Binds
    @AppScoped
    abstract fun provideLoginRepository(repository: LoginRepository) : BaseRepository
}