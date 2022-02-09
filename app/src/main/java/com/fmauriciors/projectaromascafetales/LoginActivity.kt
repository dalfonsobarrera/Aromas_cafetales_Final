package com.fmauriciors.projectaromascafetales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fmauriciors.projectaromascafetales.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private  lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        var emailReceived : String?= ""
        var passwordReceived : String?= ""

        val credentials = intent.extras
        if (credentials != null) {
            credentials.getString("name")
            credentials.getString("telephone")
            credentials.getString("brand")
            emailReceived = credentials.getString("email")
            passwordReceived = credentials.getString("password")
        }

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        with (loginBinding) {
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty()) {

                    if (email == emailReceived && password == passwordReceived) {

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Usuario o contraseña son incorrectos, verifique e intente nuevamente",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Verifique el ingreso de los campos Email o Contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}