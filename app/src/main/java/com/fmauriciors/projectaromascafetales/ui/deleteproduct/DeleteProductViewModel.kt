package com.fmauriciors.projectaromascafetales.ui.deleteproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.local.Product
import com.fmauriciors.projectaromascafetales.local.repositorybd.ProductRepository
import com.fmauriciors.projectaromascafetales.server.ProductServer
import com.fmauriciors.projectaromascafetales.server.serverrepository.ProductServerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DeleteProductViewModel : ViewModel() {
    val productRepository = ProductRepository()
    val productServerRepository = ProductServerRepository()

    private val findProduct: MutableLiveData<Product> = MutableLiveData()
    val findProductDone: LiveData<Product> = findProduct
    private val findProductServer : MutableLiveData<ProductServer?> = MutableLiveData()
    val findProductServerDone: LiveData<ProductServer?> = findProductServer

    fun searchProduct(nameProduct: String) {
        GlobalScope.launch(Dispatchers.IO) {
           // findProduct.postValue(productRepository.searchProduct(nameProduct))
            findProductServer.postValue(productServerRepository.searchProduct(nameProduct))
        }

    }

    fun deleteProduct(product: Product) {
        GlobalScope.launch(Dispatchers.IO) {
            productRepository.deleteProduct(product)
        }
    }

    fun deleteProductServer(product: ProductServer) {
        GlobalScope.launch (Dispatchers.IO){
            productServerRepository.deleteProduct(product)

        }
    }
}