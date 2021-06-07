package com.tdgroup.myapplication.ui.login

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import com.tdgroup.myapplication.databinding.ActivityLoginBinding
import com.tdgroup.myapplication.base.BaseActivity
import com.tdgroup.myapplication.ui.main.MainActivity
import com.tdgroup.myapplication.viewmodel.LoginViewModel
import com.tdgroup.myapplication.viewmodel.ViewModelFactory
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            getViewModel().login("","")
        }
    }
    override fun initEvent() {
        super.initEvent()
        getViewModel().loginSuccess.observe(this, Observer {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        })
    }

    override fun getViewModel(): LoginViewModel {
        return ViewModelProvider(this,viewModelFactory).get(LoginViewModel::class.java)
    }

}
