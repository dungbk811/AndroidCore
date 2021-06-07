package com.tdgroup.myapplication.viewmodel


import androidx.lifecycle.MutableLiveData
import com.tdgroup.myapplication.data.reposistory.LoginRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

class LoginViewModel @Inject constructor(private val repository: LoginRepository) :
    BaseViewModel() {
    val loginSuccess = MutableLiveData<Boolean>()

    fun login(username: String, password: String) {
        disposable.add(repository.login(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                getIsLoading().postValue(true)
            }
            .doAfterTerminate {
                getIsLoading().postValue(false)
            }
            .subscribe({
                repository.setIsLogin(true)
                repository.cacheUser(it.data)
                loginSuccess.postValue(true)
            }, {
                loginSuccess.postValue(false)
            })
        )
    }
    fun isLoggedIn() = repository.isLoggedIn()
}