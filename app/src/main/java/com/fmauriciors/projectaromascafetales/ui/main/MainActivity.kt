package com.fmauriciors.projectaromascafetales.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.ActivityMainBinding
import com.fmauriciors.projectaromascafetales.ui.loginuser.LoginUserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onBackPressed(){
        super.onBackPressed()
        Toast.makeText(this,"Cerrado", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        var emailReceived : String?= ""

        val credenciales = intent.extras
        //hello world
        if (credenciales != null) {
            //credenciales.getString("name")
            //credenciales.getString("telephone")
            //credenciales.getString("brand")
            emailReceived = credenciales.getString("email")        //se toman los valores de las variables en la actividad registro
        }

        //val emailMain : TextView = findViewById(R.id.email_main)
        //emailMain.text = emailReceived

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_sing_out -> goToLoginActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, LoginUserFragment::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }




}