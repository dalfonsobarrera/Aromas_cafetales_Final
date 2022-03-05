package com.fmauriciors.projectaromascafetales.ui.registeruser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentLoginUserBinding
import com.fmauriciors.projectaromascafetales.databinding.FragmentRegisterUserBinding
import com.fmauriciors.projectaromascafetales.models.User
import com.fmauriciors.projectaromascafetales.ui.loginuser.LoginUserFragmentDirections
import com.fmauriciors.projectaromascafetales.ui.loginuser.LoginUserViewModel
import java.util.regex.Pattern

class RegisterUserFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterUserFragment()
    }

    private lateinit var registerUserViewModel: RegisterUserViewModel
    private lateinit var registerUserBinding: FragmentRegisterUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        registerUserBinding = FragmentRegisterUserBinding.inflate(inflater, container, false)
        registerUserViewModel = ViewModelProvider(this)[RegisterUserViewModel::class.java]
        return registerUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(registerUserBinding){
            registerButton.setOnClickListener {
                if (nameRegisterEditText.text?.isEmpty() == true || telephoneRegisterEditText.text?.isEmpty() == true ||
                    emailRegisterEditText.text?.isEmpty() == true || passwordRegisterEditText.text?.isEmpty() == true ||
                    repPasswordRegisterEditText.text?.isEmpty() == true) {
                    Toast.makeText(
                        requireContext(),
                        "Verifique que los campos 'Nombre, Genero, Teléfono, Email, Contraseña y Verificación de la contraseña' estén completos",
                        Toast.LENGTH_SHORT
                    ).show()
                }else {
                    validated() //Validación de correo y de contraseña mayor o igual a 6 caracteres
                    if (validatedEmail() && validatedPassword()){ //Si ambas validaciones son correctas, se realiza el registro
                        val nameUser: String = nameRegisterEditText.text.toString()
                        val gender = when {
                            generMaleRegisterRadioButtom.isChecked -> 1
                            else -> 2
                        }
                        val numberPhone: String = telephoneRegisterEditText.text.toString()
                        val email: String = emailRegisterEditText.text.toString()
                        val password: String = passwordRegisterEditText.text.toString()
                        val rePassword: String = repPasswordRegisterEditText.text.toString()

                        if (password == rePassword) {
                            val user = User(
                                name = nameUser,
                                gender = gender,
                                numberPhone = numberPhone,
                                //dateRegister,
                                email = email,
                                password = password
                            )
                            findNavController().navigate(RegisterUserFragmentDirections.actionRegisterUserFragmentToDetailRegisterFragment())
                        }else {
                            Toast.makeText(
                                requireContext(),
                                "Las contraseñas no coinciden",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }else {
                        Toast.makeText(
                            requireContext(),
                            "Verifique correo y contraseña",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                }
            }
        }
    }

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
            registerUserBinding.passwordRegisterEditText.error = "La contraseña debe ser mayor a 6 caracteres"
            false
        }else{
            registerUserBinding.passwordRegisterEditText.error = null
            true
        }
    }

}