package com.fmauriciors.projectaromascafetales.ui.loginuser

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginUserViewModel : ViewModel() {

    private lateinit var loginUserViewModel: LoginUserViewModel
    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = msg

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate


    fun validateFields( email: String, password: String) {
        if(email.isEmpty()  ||
            password.isEmpty()){
            msg.value = " Proporcione un correo y/o contraseña validos "
        }else{
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                msg.value = "Debe digitar el email correctamente"
            }else{
                if (password.length <6){
                    msg.value= "La contraseña debe ser mayor a 6 caracteres"
                }else{
                    dataValidate.value = true
                }

            }
        }
    }
}