package com.fmauriciors.projectaromascafetales.server.serverrepository

import com.fmauriciors.projectaromascafetales.local.Product
import com.fmauriciors.projectaromascafetales.server.ProductServer
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.sql.Types

class ProductServerRepository {

    val db = Firebase.firestore
    fun saveProduct(nameProduct: String, cost: String, resumePlantation: String) {

        val documentProduct = db.collection("products").document()

        val product = ProductServer(

            id = documentProduct.id,
            nameProduct = nameProduct,
            cost = cost,
            resumePlantation = resumePlantation
        )

        db.collection("products").document(documentProduct.id).set(product)

    }

    fun searchProduct(nameProduct: String) :  ProductServer? {
        var productServerFound : ProductServer? = null
        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    val productServer : ProductServer = document.toObject<ProductServer>()
                    if (nameProduct == productServer?.nameProduct) {
                         productServerFound = productServer

                    }
                }
            }
        return productServerFound
    }

    fun deleteProduct(product: ProductServer) {
       product.id?.let {   id ->
           db.collection("products")
           .document(id)
           .delete()
       }
    }
}