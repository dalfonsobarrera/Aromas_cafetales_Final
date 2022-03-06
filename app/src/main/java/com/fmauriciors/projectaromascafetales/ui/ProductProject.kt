package com.fmauriciors.projectaromascafetales.ui

import android.app.Application
import androidx.room.Room
import com.fmauriciors.projectaromascafetales.ui.local.ProductDatabase

class ProductProject: Application() {

    companion object{

          lateinit var  database: ProductDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database  = Room.databaseBuilder(

            this,
            ProductDatabase::class.java,
            "Product_db"
        ).build()
    }
}