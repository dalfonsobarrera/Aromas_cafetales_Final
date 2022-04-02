package com.fmauriciors.projectaromascafetales.server

import java.io.Serializable


data class ProductServer(
  var id: String? = null,
  var nameProduct: String? = null,
  var cost: String?= null,
  var resumePlantation: String? = null
): Serializable