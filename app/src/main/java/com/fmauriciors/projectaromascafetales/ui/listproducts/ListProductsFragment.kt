package com.fmauriciors.projectaromascafetales.ui.listproducts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.databinding.FragmentListProductsBinding

class ListProductsFragment : Fragment() {


    private lateinit var listProductsBinding: FragmentListProductsBinding
    private lateinit var listProductsViewModel: ListProductsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        listProductsBinding = FragmentListProductsBinding.inflate(inflater, container, false)
        listProductsViewModel = ViewModelProvider(this)[ListProductsViewModel::class.java]
        return listProductsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listProductsBinding.newProductButton.setOnClickListener {
            findNavController().navigate(ListProductsFragmentDirections.actionListProductsFragmentToNewProductFragment())
        }
    }

}

