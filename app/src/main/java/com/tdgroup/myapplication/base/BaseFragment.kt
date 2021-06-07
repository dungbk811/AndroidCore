package com.tdgroup.myapplication.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tdgroup.myapplication.viewmodel.BaseViewModel


abstract class BaseFragment<T:BaseViewModel> : Fragment() {
    private var viewModel: T? = null
    abstract fun getViewModel(): T

    abstract fun getLayoutRes(): Int
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = getViewModel();
    }

    override fun onDetach() {
        super.onDetach()
    }
}