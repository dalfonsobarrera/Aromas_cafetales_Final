package com.fmauriciors.projectaromascafetales.server

data class User(
    var uid: String? = null,
    var nombre: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var role1: Boolean? = null,
    var role2: Boolean? = null
)
enum class Role {
    COMPRADOR,VENDEDOR,AMBOS

}
