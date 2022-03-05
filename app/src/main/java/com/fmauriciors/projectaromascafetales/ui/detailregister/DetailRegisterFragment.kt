package com.fmauriciors.projectaromascafetales.ui.detailregister

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentDetailRegisterBinding
import com.fmauriciors.projectaromascafetales.databinding.FragmentLoginUserBinding
import com.fmauriciors.projectaromascafetales.ui.loginuser.LoginUserViewModel

class DetailRegisterFragment : Fragment() {

    companion object {
        fun newInstance() = DetailRegisterFragment()
    }

    private lateinit var detailRegisterBinding: FragmentDetailRegisterBinding
    private lateinit var detailRegisterViewModel: DetailRegisterViewModel
    //private val args: DetailRegisterFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailRegisterBinding = FragmentDetailRegisterBinding.inflate(inflater, container, false)
        detailRegisterViewModel = ViewModelProvider(this)[DetailRegisterViewModel::class.java]
        return detailRegisterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}