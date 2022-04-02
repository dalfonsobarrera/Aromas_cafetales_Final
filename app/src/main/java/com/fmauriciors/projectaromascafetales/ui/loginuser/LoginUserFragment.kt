package com.fmauriciors.projectaromascafetales.ui.loginuser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentLoginUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginUserFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var loginUserBinding: FragmentLoginUserBinding
    private lateinit var loginUserViewModel: LoginUserViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        loginUserBinding = FragmentLoginUserBinding.inflate(inflater, container, false)
        loginUserViewModel = ViewModelProvider(this)[LoginUserViewModel::class.java]
        context?.theme?.applyStyle(R.style.AppTheme_styleLogin, true)
        return loginUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginUserViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)
        }
        loginUserViewModel.dataValidated.observe(viewLifecycleOwner) { result ->
            onDataValidatedSubscribe(result)
        }
        with(loginUserBinding) {
            signInButton.setOnClickListener {
                loginUserViewModel.validateFields(
                    emailLoginEditText.text.toString(),
                    passwordLoginEditText.text.toString()
                )
            }
        }
        loginUserBinding.registerTextView.setOnClickListener(){
            findNavController().navigate(LoginUserFragmentDirections.actionLoginUserFragmentToRegisterUserFragment())
        }
    }

    private fun onDataValidatedSubscribe(result: Boolean?) {
        auth = Firebase.auth

        with(loginUserBinding){
                val email = emailLoginEditText.text.toString()
                val password = passwordLoginEditText.text.toString()
               // auth.sendPasswordResetEmail(email) // restablecer password
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            Log.d("Register full", "signInWithEmail:success")
                            findNavController().navigate(LoginUserFragmentDirections.actionLoginUserFragmentToListProductsFragment())

                        } else {
                            Log.w("Register full", "signInWithEmail:failure", task.exception)
                            Toast.makeText(requireContext(), task.exception?.message.toString(),
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }


}



