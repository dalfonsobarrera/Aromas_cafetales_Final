package com.fmauriciors.projectaromascafetales.ui.shoping

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmauriciors.projectaromascafetales.R

class ShopingFragment : Fragment() {

    companion object {
        fun newInstance() = ShopingFragment()
    }

    private lateinit var viewModel: ShopingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shoping, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShopingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}