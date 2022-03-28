package com.fmauriciors.projectaromascafetales.server

data class User(
    var uid: String? = null,
    var nombre: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var role: Role? = null
)
enum class Role {
    COMPRADOR,VENDEDOR,AMBOS

}
