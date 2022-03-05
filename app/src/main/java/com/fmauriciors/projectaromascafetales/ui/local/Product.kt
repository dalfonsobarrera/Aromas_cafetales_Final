package com.fmauriciors.projectaromascafetales.ui.local

import java.io.Serializable

data class Product(
    val product_name: String,
    val cost: Int,
    val name_brand: String,
    val resume_plantation:String
): Serializable