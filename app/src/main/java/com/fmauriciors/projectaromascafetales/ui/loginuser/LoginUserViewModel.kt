package com.fmauriciors.projectaromascafetales.ui.loginuser

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.databinding.FragmentRegisterUserBinding

class LoginUserViewModel : ViewModel() {

    private lateinit var loginUserViewModel: LoginUserViewModel

    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = msg

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate


    fun validateFields( email: String, password: String) {
        if(email.isEmpty()  || password.isEmpty()){
            msg.value = " Email y/o Contraseña es incorrecto "
        }else{
            msg.value = " Inicio correcto "
            dataValidate.value = true
        }
    }
}