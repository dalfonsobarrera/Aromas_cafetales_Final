package com.fmauriciors.projectaromascafetales.local.repositorybd

import com.fmauriciors.projectaromascafetales.AromasCafetalesProyect
import com.fmauriciors.projectaromascafetales.local.Register
import com.fmauriciors.projectaromascafetales.local.RegisterDao
import java.sql.Types.NULL

class RegisterRepository {

    suspend fun saveRegister(nameUser: String, phone: String, email: String, password: String/* role1: Boolean, role2: Boolean*/) {

        val register = Register(


            id = NULL,
            nameUser = nameUser,
            phone = phone,
            email = email,
            password = password,
            //role1 = role1,
            //role2 = role2
        )

        val registerDao : RegisterDao = AromasCafetalesProyect.database.RegisterDao()
        registerDao.saveRegister(register)
    }


/*
    suspend fun deleteProduct(product: Product) {
        val productDao: ProductDao = ProductProject.database.ProductDao()
        productDao.deleteProduct(product)
    }*/

    suspend fun loadRegisters(): ArrayList<Register>{
        val registerDao: RegisterDao = AromasCafetalesProyect.database.RegisterDao()
        val registerList : ArrayList<Register> = registerDao.loadRegisters() as ArrayList<Register>
        return registerList
    }
}