package com.fmauriciors.projectaromascafetales.ui.detailproduct

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.fmauriciors.projectaromascafetales.databinding.FragmentDetailProductBinding

class DetailProductFragment : Fragment() {


    private lateinit var detailProductBinding: FragmentDetailProductBinding
    private lateinit var detailViewModel: DetailProductViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailProductBinding = FragmentDetailProductBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[detailViewModel::class.java]
        return detailProductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}








