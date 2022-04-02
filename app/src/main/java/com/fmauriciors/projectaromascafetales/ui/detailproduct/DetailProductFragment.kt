package com.fmauriciors.projectaromascafetales.ui.detailproduct

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs


import com.fmauriciors.projectaromascafetales.databinding.FragmentDetailProductBinding
import com.fmauriciors.projectaromascafetales.server.ProductServer

class DetailProductFragment : Fragment() {


    private lateinit var detailProductBinding: FragmentDetailProductBinding
    private lateinit var detailProductViewModel: DetailProductViewModel
    private val args: DetailProductFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailProductBinding = FragmentDetailProductBinding.inflate(inflater, container, false)
        detailProductViewModel = ViewModelProvider(this)[DetailProductViewModel::class.java]
        return detailProductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product : ProductServer = args.product

        with (detailProductBinding){
            favoriteNameProductTextView.text = product.nameProduct
            favoriteNameCostoTextView.text = product.cost
        }
    }

}








