package com.fmauriciors.projectaromascafetales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fmauriciors.projectaromascafetales.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        with(registerBinding){
            registerButton.setOnClickListener {
                val name = nameEditText.text.toString()
                val telephone = telephoneEditText.text.toString()
                val brand = brandEditText.text.toString()
                val email = emailEditText.text.toString()
                val passsword = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()

                if (passsword == repPassword){
                    val intent= Intent(this@RegisterActivity, LoginActivity::class.java )
                    intent.putExtra("email", email)
                    intent.putExtra("password", passsword)
                    startActivity(intent)
                } else
                    Toast.makeText(applicationContext, "Las contraseñas no coinciden ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}