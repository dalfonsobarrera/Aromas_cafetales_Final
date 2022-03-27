package com.fmauriciors.projectaromascafetales.ui.splashac

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.databinding.FragmentSplashAcBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//const val DEFAULT_DELAY = 2000L

class SplashAcFragment: Fragment() {

    private lateinit var splashAcBinding: FragmentSplashAcBinding
    private lateinit var splashAcViewModel: SplashAcViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        splashAcBinding = FragmentSplashAcBinding.inflate(inflater, container, false)
        splashAcViewModel = ViewModelProvider(this)[SplashAcViewModel::class.java]
        addSubscriptions()
        return splashAcBinding.root
    }
    private fun addSubscriptions() {
        auth = Firebase.auth
        splashAcViewModel.onTimer.observe(viewLifecycleOwner){
            if (auth.currentUser == null)
            findNavController().navigate(SplashAcFragmentDirections.actionSplashAcFragmentToLoginUserFragment())
            else{
                findNavController().navigate(SplashAcFragmentDirections.actionSplashAcFragmentToListProductsFragment())
            }
        }
    }
}