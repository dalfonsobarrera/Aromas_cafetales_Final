package com.fmauriciors.projectaromascafetales.server.serverrepository

import com.fmauriciors.projectaromascafetales.local.Product
import com.fmauriciors.projectaromascafetales.server.ProductServer
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.tasks.await

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

    suspend fun loadproducts(): QuerySnapshot {
        return withContext(Dispatchers.IO) {
            db.collection("products").get().await()
        }
    }
    fun deleteProduct(product: ProductServer) {
       product.id?.let {   id ->
           db.collection("products")
           .document(id)
           .delete()
       }
    }


}