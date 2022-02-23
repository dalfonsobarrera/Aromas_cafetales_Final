package com.fmauriciors.projectaromascafetales.ui.loginuser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmauriciors.projectaromascafetales.R

class LoginUserFragment : Fragment() {

    companion object {
        fun newInstance() = LoginUserFragment()
    }

    private lateinit var viewModel: LoginUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}