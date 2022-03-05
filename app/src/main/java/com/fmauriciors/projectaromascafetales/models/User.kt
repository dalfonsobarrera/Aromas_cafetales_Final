package com.fmauriciors.projectaromascafetales.models

data class User(
    val name: String,
    val gender: Int,
    val numberPhone: String,
    //val dateRegister: String,
    val email: String,
    val password: String
)
