package com.fmauriciors.projectaromascafetales.ui.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Types


@Entity(tableName = "table_products")
data class Product(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") var id: Int = Types.NULL,
    @ColumnInfo(name="productName") var productName: String = "",
    @ColumnInfo(name="cost") var cost: String = "",
    @ColumnInfo(name="resumePlantation") var resumePlantation: String = ""
): Serializable