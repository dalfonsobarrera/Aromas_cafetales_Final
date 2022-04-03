package com.fmauriciors.projectaromascafetales.ui.listproducts

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.CardViewItemProductBinding
import com.fmauriciors.projectaromascafetales.local.Product
import com.fmauriciors.projectaromascafetales.server.ProductServer
import com.squareup.picasso.Picasso
import java.util.ArrayList

class ProductsAdapter (
    private val productsList: ArrayList <ProductServer>,
    private val onItemClicked: (ProductServer) -> Unit
    ): RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_product, parent, false)
            return ProductViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            val product = productsList[position]
            holder.bind(product)
            holder.itemView.setOnClickListener { onItemClicked(productsList[position])
            }
        }

        override fun getItemCount(): Int = productsList.size

        fun appendItems(newList: ArrayList<ProductServer>) {
            productsList.clear()
            productsList.addAll(newList)
            notifyDataSetChanged()
        }

        class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            private val binding = CardViewItemProductBinding.bind(itemView)
            fun bind(product: ProductServer) {
                with(binding){
                    favoriteNameProductTextView.text = product.nameProduct
                    favoriteNameCostoTextView.text = product.cost
                   // nameCardResumeTextView.text = product.resumePlantation
                    Picasso.get().load(product.urlPicture).into(favoriteProductImageView)
                }
                itemView.setOnClickListener {
                    Log.d ("ClicAdapter","en Iten")
                }
            }
        }
    }
