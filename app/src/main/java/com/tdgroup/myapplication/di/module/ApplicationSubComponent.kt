package com.tdgroup.myapplication.di.module

import com.tdgroup.myapplication.di.component.ActivityComponent
import com.tdgroup.myapplication.di.component.UserComponent
import dagger.Module

@Module(subcomponents = [UserComponent::class, ActivityComponent::class])
class ApplicationSubComponent {
}