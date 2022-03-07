package com.fmauriciors.projectaromascafetales.ui.listregisters

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentListProductsBinding
import com.fmauriciors.projectaromascafetales.databinding.FragmentListRegisterBinding
import com.fmauriciors.projectaromascafetales.ui.listproducts.ListProductsFragmentDirections
import com.fmauriciors.projectaromascafetales.ui.listproducts.ListProductsViewModel
import com.fmauriciors.projectaromascafetales.ui.listproducts.ProductsAdapter
import com.fmauriciors.projectaromascafetales.ui.local.Product
import com.fmauriciors.projectaromascafetales.ui.local.Register

class ListRegisterFragment : Fragment() {

    private lateinit var listRegistersBinding: FragmentListRegisterBinding
    private lateinit var listRegistersViewModel: ListRegisterViewModel
    private lateinit var registerAdapter: RegistersAdapter
    private var registerstsList: ArrayList<Register> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listRegistersBinding = FragmentListRegisterBinding.inflate(inflater, container, false)
        listRegistersViewModel = ViewModelProvider(this)[ListRegisterViewModel::class.java]
        return listRegistersBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRegistersViewModel.loadRegisterDone.observe(viewLifecycleOwner, { result ->
            onLoadRegistersDoneSubscribe(result)
        })

        listRegistersViewModel.loadRegisters()

        registerAdapter = RegistersAdapter(registerstsList)

        listRegistersBinding.registerRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListRegisterFragment.requireContext())
            adapter = registerAdapter
            setHasFixedSize(false)
        }

    }

    private fun onLoadRegistersDoneSubscribe(registersListLoaded: ArrayList<Register>) {
        registerstsList = registersListLoaded
        registerAdapter.appendItems(registerstsList)


    }
}