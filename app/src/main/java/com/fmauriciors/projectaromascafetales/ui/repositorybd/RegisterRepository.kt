package com.fmauriciors.projectaromascafetales.ui.repositorybd

import com.fmauriciors.projectaromascafetales.ui.RegisterProject
import com.fmauriciors.projectaromascafetales.ui.local.Register
import com.fmauriciors.projectaromascafetales.ui.local.RegisterDao
import java.sql.Types.NULL

class RegisterRepository {

    suspend fun saveRegister(
        nameUser: String,
        phone: String,
        email: String,
        password: String

    ) {
        val register = Register(

            id = NULL,
            nameUser = nameUser,
            phone = phone,
            email = email,
            password = password
        )

        val registerDao : RegisterDao = RegisterProject.database.RegisterDao()
        registerDao.saveRegister(register)
    }


/*
    suspend fun deleteProduct(product: Product) {
        val productDao: ProductDao = ProductProject.database.ProductDao()
        productDao.deleteProduct(product)
    }*/

    suspend fun loadRegisters(): ArrayList<Register>{
        val registerDao: RegisterDao = RegisterProject.database.RegisterDao()
        val registerList : ArrayList<Register> = registerDao.loadRegisters() as ArrayList<Register>
        return registerList
    }
}