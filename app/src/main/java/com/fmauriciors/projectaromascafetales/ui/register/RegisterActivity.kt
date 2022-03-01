package com.fmauriciors.projectaromascafetales.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.fmauriciors.projectaromascafetales.databinding.ActivityRegisterBinding
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        with(registerBinding){
            registerButton.setOnClickListener {

                validated() //se llama la función de validacion, que se encarga de verificar el estado de los campos Email y contraseña.

                val name = nameEditText.text.toString()
                val telephone = telephoneEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()

                if (email != "" && password != "") {
                    if (password == repPassword){
                       //val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        intent.putExtra("name", name)
                        intent.putExtra("telephone", telephone)
                        intent.putExtra("email", email)
                        intent.putExtra("password", password)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Contraseña no coinciden",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }else {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Ingrese usuario y contraseña, campos vacíos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    private fun validated(){

        val result = arrayOf(validatedEmail(), validatedPassword())

        if (false in result){
            return
        }

        Toast.makeText(this, " ", Toast.LENGTH_SHORT).show()
    }

    private fun validatedEmail() : Boolean {

        val email = registerBinding.emailEditText?.text.toString()

        return if (email.isEmpty()){
            registerBinding.emailEditText.error = "El campo está vacío"
            false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            registerBinding.emailEditText.error = "Ingrese un correo válido"
            false
        } else{
            registerBinding.emailEditText.error = null
            true
        }
    }

    private fun validatedPassword() : Boolean {

        val password = registerBinding.passwordEditText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^(.{6,})$"
        )
        return if (password.isEmpty()){
            registerBinding.passwordEditText.error = "El campo está vacío"
            false
        }else if (!passwordRegex.matcher(password).matches()) {
            registerBinding.passwordEditText.error = "La contraseña debe ser mayor a 6 caracteres"
            false
        } else{
            registerBinding.passwordEditText.error = null
            true
        }
    }
}