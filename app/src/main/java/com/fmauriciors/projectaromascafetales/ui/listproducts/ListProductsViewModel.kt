package com.fmauriciors.projectaromascafetales.ui.listproducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.databinding.FragmentListProductsBinding
import com.fmauriciors.projectaromascafetales.local.Product
import com.fmauriciors.projectaromascafetales.local.repositorybd.ProductRepository
import com.fmauriciors.projectaromascafetales.server.ProductServer
import com.fmauriciors.projectaromascafetales.server.serverrepository.ProductServerRepository
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListProductsViewModel : ViewModel() {
    val productRepository = ProductRepository()
    val productServerRepository = ProductServerRepository()
    private var productList : ArrayList<ProductServer> = ArrayList()

    private val loadProducts: MutableLiveData<ArrayList<Product>> = MutableLiveData()
    val loadProductDone: LiveData<ArrayList<Product>> = loadProducts

    private val loadProductsFromServer : MutableLiveData<ArrayList<ProductServer>> = MutableLiveData()
    val loadProductsFromServerDone : LiveData<ArrayList<ProductServer>> = loadProductsFromServer

    fun loadProducts(){
        GlobalScope.launch(Dispatchers.IO){
            loadProducts.postValue( productRepository.loadProducts())
        }
    }

    fun loadProductsFromServer() {
        GlobalScope.launch ( Dispatchers.IO ){
            val querySnapshot = productServerRepository.loadproducts()
            for (document in querySnapshot) {
                val productServer: ProductServer = document.toObject<ProductServer>()
                productList.add(productServer)
            }
            loadProductsFromServer.postValue(productList)

        }
    }
}