package com.fmauriciors.projectaromascafetales.ui.listregisters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.CardViewItemProductBinding
import com.fmauriciors.projectaromascafetales.ui.listproducts.ProductsAdapter
import com.fmauriciors.projectaromascafetales.ui.local.Product
import com.fmauriciors.projectaromascafetales.ui.local.Register
import java.util.ArrayList

class RegistersAdapter (
    private val registerList: ArrayList<Register>

): RecyclerView.Adapter<RegistersAdapter.RegisterViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_user_register, parent, false)
        return RegisterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegisterViewHolder, position: Int) {
        val register = registerList[position]
        holder.bind(register)
    }

    override fun getItemCount(): Int = registerList.size

    fun appendItems(newList: ArrayList<Product>) {
        registerList.clear()
        registerList.addAll(newList)
        notifyDataSetChanged()
    }

    class RegisterViewHolder(itemView: View): RecyclerRView.ViewHolder(itemView){
        private val binding = CardViewItemRegisterBinding.bind(itemView)
        fun bind(register: Register) {
            with(binding){
                nameCardNameRegisterTextView.text = register.nameUser
                nameCardPhoneRegisterTextView.text = register.phoneNumber
                nameCardEmailRegisterTextView.text = register.email

            }
        }
    }
}
