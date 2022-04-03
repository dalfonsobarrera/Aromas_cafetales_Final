package com.fmauriciors.projectaromascafetales.ui.registeruser

import android.content.ContentValues.TAG
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.databinding.FragmentRegisterUserBinding
import com.fmauriciors.projectaromascafetales.local.repositorybd.RegisterRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterUserViewModel : ViewModel() {

    private val registerRepository = RegisterRepository()

    private lateinit var registerUserBinding: FragmentRegisterUserBinding

        private val msg: MutableLiveData<String> = MutableLiveData()
        val msgDone: LiveData<String> = msg

        private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
        val dataValidated: LiveData<Boolean> = dataValidate


        fun validateFields(nameRegister: String, phone: String, emailRegister: String, passwordRegister: String, repasswordRegister: String) {
            if (nameRegister.isEmpty() ||
                phone.isEmpty() ||
                emailRegister.isEmpty() ||
                passwordRegister.isEmpty() ||
                repasswordRegister.isEmpty()
            ) {
                msg.value = "Verifique que los campos no esten vacios"
            } else {
                if (!Patterns.EMAIL_ADDRESS.matcher(emailRegister).matches()) {
                    msg.value = "Debe digitar el email correctamente"
                } else {
                    if (passwordRegister.length < 6) {
                        msg.value = "La contraseña debe ser mayor a 6 caracteres"
                    } else {
                        if (passwordRegister.equals(repasswordRegister)) {
                            msg.value = "Las contraseñas no coinciden"
                        }
                        dataValidate.value = true
                    }

                }

            }

        }
    fun saveRegister(nameUser: String, phone: String, email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            registerRepository.saveRegister(nameUser, phone, email, password)
        }

    }
}
/*
    private fun validated(){
        val result = arrayOf(validatedEmail(), validatedPassword())
        if (false in result){
            return
        }
    }

    private fun validatedEmail() : Boolean {
        val email = registerUserBinding.emailRegisterEditText?.text.toString()
        return if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            registerUserBinding.emailRegisterEditText.error = "Ingrese un correo válido"
            false
        } else{
            registerUserBinding.emailRegisterEditText.error = null
            true
        }
    }

    private fun validatedPassword() : Boolean {
        val password = registerUserBinding.passwordRegisterEditText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^(.{6,})$"
        )
        return if (!passwordRegex.matcher(password).matches()) {
            registerUserBinding.passwordRegisterEditText.error =
                "La contraseña debe ser mayor a 6 caracteres"
            false
        } else {
            registerUserBinding.passwordRegisterEditText.error = null
            true
        }
    }
*/
