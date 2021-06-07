package com.tdgroup.myapplication.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tdgroup.myapplication.application.MyApplication
import com.tdgroup.myapplication.di.component.ActivityComponent
import com.tdgroup.myapplication.viewmodel.BaseViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity


open abstract class BaseActivity<T : BaseViewModel> : DaggerAppCompatActivity() {
    private lateinit var viewModel : T

    open fun initData(){}
    open fun initEvent(){}

    abstract fun getViewModel(): T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = getViewModel()
        initData()
        initEvent()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}