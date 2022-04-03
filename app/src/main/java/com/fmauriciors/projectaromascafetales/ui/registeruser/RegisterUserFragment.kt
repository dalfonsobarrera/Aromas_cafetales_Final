package com.fmauriciors.projectaromascafetales.ui.registeruser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentRegisterUserBinding
import com.fmauriciors.projectaromascafetales.server.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterUserFragment : Fragment() {

    private lateinit var registerUserViewModel: RegisterUserViewModel
    private lateinit var registerUserBinding: FragmentRegisterUserBinding
    private lateinit var auth: FirebaseAuth
    var role1:Boolean = false
    var role2:Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        registerUserBinding = FragmentRegisterUserBinding.inflate(inflater, container, false)
        registerUserViewModel = ViewModelProvider(this)[RegisterUserViewModel::class.java]
        context?.theme?.applyStyle(R.style.AppTheme_styleRegister, true)
        return registerUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerUserViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)
        }
        registerUserViewModel.dataValidated.observe(viewLifecycleOwner) { result ->
            onDataValidatedSubscribe(result)
        }

        with(registerUserBinding) {

            registerUserButton.setOnClickListener {

                if(rollBuyerSwitch.isChecked) {
                    role1 = true
                }
                if(rollSellerSwitch.isChecked){
                    role2 = true
                }

                registerUserViewModel.validateFields(
                    nameRegisterEditText.text.toString(),
                    phoneRegisterEditText.text.toString(),
                    emailRegisterEditText.text.toString(),
                    passwordRegisterEditText.text.toString(),
                    repasswordRegisterEditText.text.toString(),
                    role1,
                    role2
                )

                //findNavController().navigate(RegisterUserFragmentDirections.actionRegisterUserFragmentToListRegisterFragment())
            }
        }
    }


    private fun onDataValidatedSubscribe(result: Boolean?) {
        auth = Firebase.auth

        with(registerUserBinding) {
            val nameUser = nameRegisterEditText.text.toString()
            val phone = phoneRegisterEditText.text.toString()
            val email = emailRegisterEditText.text.toString()
            val password = passwordRegisterEditText.text.toString()
            //val repassword = repasswordRegisterEditText.text.toString()
            registerUserViewModel.saveRegister(nameUser, phone, email, password, role1, role2)

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Log.d("Register full", "createUserWithEmail:success")
                        findNavController().navigate(RegisterUserFragmentDirections.actionRegisterUserFragmentToLoginUserFragment())

                        createUser(auth.currentUser?.uid, email)

                    }
                }
        }
    }

    private fun createUser(uid: String?, email: String) {
        val db = Firebase.firestore
        val user = User(uid = uid, email = email, role1 = role1, role2 = role2)
        uid?.let{uid ->
        db.collection("users").document(uid).set(user)
            .addOnSuccessListener {
                Toast.makeText(requireContext(),"Usurio registrado exitosamente", Toast.LENGTH_SHORT).show()
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


