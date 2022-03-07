package com.fmauriciors.projectaromascafetales.ui

import android.app.Application
import androidx.room.Room
import com.fmauriciors.projectaromascafetales.ui.local.ProductDatabase
import com.fmauriciors.projectaromascafetales.ui.local.RegisterDatabase

class RegisterProject : Application() {

    companion object{

        lateinit var database: RegisterDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database  = Room.databaseBuilder(

            this,
            RegisterDatabase::class.java,
            "Register_db"
        ).allowMainThreadQueries()
            .build()
    }
}