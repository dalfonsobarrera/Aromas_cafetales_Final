package com.fmauriciors.projectaromascafetales.ui.repositorybd

import com.fmauriciors.projectaromascafetales.ui.RegisterProject
import com.fmauriciors.projectaromascafetales.ui.local.Register
import com.fmauriciors.projectaromascafetales.ui.local.RegisterDao
import java.sql.Types

class RegisterRepository {

    suspend fun saveRegister(
        nameUser: String,
        phoneNumber: String,
        email: String,
        password: String

    ) {
        val register = Register(

            id = Types.NULL,
            nameUser = nameUser,
            phoneNumber = phoneNumber,
            email = email,
            password = password
        )

        val registerDao : RegisterDao = RegisterProject.database.RegisterDao()
        registerDao.saveRegister(register)
    }

    /*suspend fun searchProduct(nameProduct: String): Product {
        val productDao: ProductDao = ProductProject.database.ProductDao()
        val  product = productDao.searchProduct(nameProduct)
        return product
    }

    suspend fun deleteProduct(product: Product) {
        val productDao: ProductDao = ProductProject.database.ProductDao()
        productDao.deleteProduct(product)
    }*/

    suspend fun loadRegister(): ArrayList<Register>{
        val registerDao: RegisterDao = RegisterProject.database.RegisterDao()
        val registerList : ArrayList<Register> = registerDao.loadRegister() as ArrayList<Register>
        return registerList

    }

}