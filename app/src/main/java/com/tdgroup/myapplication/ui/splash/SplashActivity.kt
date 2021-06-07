package com.tdgroup.myapplication.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tdgroup.myapplication.R
import com.tdgroup.myapplication.base.BaseActivity
import com.tdgroup.myapplication.ui.login.LoginActivity
import com.tdgroup.myapplication.ui.main.MainActivity
import com.tdgroup.myapplication.viewmodel.LoginViewModel
import com.tdgroup.myapplication.viewmodel.ViewModelFactory
import javax.inject.Inject

class SplashActivity : BaseActivity<LoginViewModel>() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun initData() {
        super.initData()
        if (getViewModel().isLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun getViewModel(): LoginViewModel {
        return ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
    }
}