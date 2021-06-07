package com.tdgroup.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


open class BaseViewModel : ViewModel() {
    protected val disposable = CompositeDisposable()
    private val isLoading = MutableLiveData<Boolean>()

    open fun getIsLoading(): MutableLiveData<Boolean> {
        return isLoading
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

}