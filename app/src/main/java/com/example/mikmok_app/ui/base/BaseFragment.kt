package com.example.mikmok_app.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    abstract fun setup()
    abstract fun callBack()
    abstract val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> VB
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        setup()
        callBack()
        return _binding.root
    }
}