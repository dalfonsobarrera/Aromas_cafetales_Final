package com.fmauriciors.projectaromascafetales.ui.splashar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmauriciors.projectaromascafetales.R

class SplashArFragment : Fragment() {

    companion object {
        fun newInstance() = SplashArFragment()
    }

    private lateinit var viewModel: SplashArViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_ar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashArViewModel::class.java)
        // TODO: Use the ViewModel
    }

}