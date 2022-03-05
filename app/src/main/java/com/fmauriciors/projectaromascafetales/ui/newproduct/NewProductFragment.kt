package com.fmauriciors.projectaromascafetales.ui.newproduct

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentNewProductBinding
import com.fmauriciors.projectaromascafetales.ui.listproducts.ListProductsFragmentDirections
import com.fmauriciors.projectaromascafetales.ui.local.Product

class NewProductFragment : Fragment() {

    private lateinit var newProductBinding: FragmentNewProductBinding
    private lateinit var viewModel: NewProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        newProductBinding = FragmentNewProductBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NewProductViewModel::class.java)
        return newProductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newProductBinding.saveButton.setOnClickListener {
            findNavController().navigate(NewProductFragmentDirections.actionNewProductFragmentToDetailProductFragment())
        }

        val product = Product(
            product_name = "name",
            cost = 0,
            name_brand = "marca",
            resume_plantation =""

            )
    }
}
