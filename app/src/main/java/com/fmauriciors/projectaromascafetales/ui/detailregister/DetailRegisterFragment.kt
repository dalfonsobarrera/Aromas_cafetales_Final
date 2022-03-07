package com.fmauriciors.projectaromascafetales.ui.detailregister

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmauriciors.projectaromascafetales.databinding.FragmentDetailRegisterBinding

class DetailRegisterFragment : Fragment() {

    private lateinit var detailRegisterBinding: FragmentDetailRegisterBinding
    private lateinit var detailRegisterViewModel: DetailRegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailRegisterBinding = FragmentDetailRegisterBinding.inflate(inflater, container, false)
        detailRegisterViewModel = ViewModelProvider(this)[detailRegisterViewModel::class.java]
        return detailRegisterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}