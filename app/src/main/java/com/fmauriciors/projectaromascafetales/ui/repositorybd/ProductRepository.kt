package com.fmauriciors.projectaromascafetales.ui.repositorybd;

import com.fmauriciors.projectaromascafetales.ui.ProductProject
import com.fmauriciors.projectaromascafetales.ui.local.Product;
import com.fmauriciors.projectaromascafetales.ui.local.ProductDao
import java.sql.Types.NULL

class ProductRepository {

    suspend fun saveProduct(
        productName: String,
        cost: String,
        resumePlantation: String

    ) {
        val product = Product(

            id = NULL,
            productName = productName,
            cost = cost,
            resumePlantation = resumePlantation
        )

        val productDao : ProductDao = ProductProject.database.ProductDao()
        productDao.saveProduct(product)
    }

    suspend fun searchProduct(nameProduct: String): Product {
        val productDao: ProductDao = ProductProject.database.ProductDao()
        val  product = productDao.searchProduct(nameProduct)
        return product
    }

    suspend fun deleteProduct(product: Product) {
        val productDao: ProductDao = ProductProject.database.ProductDao()
        productDao.deleteProduct(product)
    }

    suspend fun loadProducts(): ArrayList<Product>{
        val productDao: ProductDao = ProductProject.database.ProductDao()
        val productList : ArrayList<Product> = productDao.loadProducts() as ArrayList<Product>
        return productList
    }
}
