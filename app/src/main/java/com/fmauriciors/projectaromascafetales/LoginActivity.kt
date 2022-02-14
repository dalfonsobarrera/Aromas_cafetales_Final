package com.fmauriciors.projectaromascafetales

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.fmauriciors.projectaromascafetales.databinding.ActivityLoginBinding
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {

    //private  lateinit var binding: ActivityLoginBinding
    private  lateinit var loginBinding: ActivityLoginBinding

    var emailReceived : String?= ""
    var passwordReceived : String?= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        val credentials = intent.extras

        if (credentials != null) {
            //credentials.getString("name")
            //credentials.getString("telephone")
            //credentials.getString("brand")
            emailReceived = credentials.getString("email")        //se toman los valores de las variables en la actividad registro
            passwordReceived= credentials.getString("password")
        }

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //Para guardar variable a reutilizar si se cierra el MainActivity

        val emailEditT = findViewById<EditText>(R.id.email_edit_text)
        val passwordEditT = findViewById<EditText>(R.id.password_edit_text)
        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
        var ema : String?= ""
        var pass : String?= ""

        if (emailReceived != "" && passwordReceived != "") {
           // emailEditT.setText(preferencias.getString("mailR", ""))
            // passwordEditT.setText(preferencias.getString("passwordR", ""))
            ema=emailEditT.toString()
            pass=passwordEditT.toString()

        }

        with (loginBinding) {
            signInButton.setOnClickListener {

                validated() //se llama la función de validacion, que se encarga de verificar el estado de los campos Email y contraseña.

                val email = emailEditText.text.toString()      //se convierten las variables de tipo label a string
                val password = passwordEditText.text.toString()

                if (email == emailReceived && password == passwordReceived) {  //se comparan las variables recibidas de actividad registro con las escritas en actividad login
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    val editor = preferencias.edit()
                    editor.putString("mailR", emailReceived)
                    editor.putString("passwordR", passwordReceived)
                    editor.commit()
                    startActivity(intent)
                }else if(emailReceived == ema && passwordReceived == pass){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("email", email)
                    startActivity(intent)
                    finish()
                }
                else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuario o contraseña son incorrectos, verifique e intente nuevamente. Recuerde registrase",
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

        val email = loginBinding.emailEditText?.text.toString()

        return if (email.isEmpty()){
            loginBinding.emailEditText.error = "El campo está vacío"
            false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            loginBinding.emailEditText.error = "Ingrese un correo válido"
            false
        } else{
            loginBinding.emailEditText.error = null
            true
        }
    }

    private fun validatedPassword() : Boolean {

        val password = loginBinding.passwordEditText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^(.{6,})$"
        )
        return if (password.isEmpty()){
            loginBinding.passwordEditText.error = "El campo está vacío"
            false
        }else if (!passwordRegex.matcher(password).matches()) {
            loginBinding.passwordEditText.error = "La contraseña debe ser mayor a 6 caracteres"
            false
        } else{
            loginBinding.passwordEditText.error = null
            true
        }
    }


}