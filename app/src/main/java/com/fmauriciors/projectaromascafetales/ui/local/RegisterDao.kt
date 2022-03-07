package com.fmauriciors.projectaromascafetales.ui.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao

interface RegisterDao {

    @Insert
    suspend fun saveRegister ( register: Register)

   /* @Query("SELECT * FROM table_register WHERE productName LIKE :nameProduct")
    suspend fun searchProduct (nameProduct:String): Product*/

    @Query("SELECT * FROM table_register")
    suspend fun loadRegister(): MutableList<Product>
}