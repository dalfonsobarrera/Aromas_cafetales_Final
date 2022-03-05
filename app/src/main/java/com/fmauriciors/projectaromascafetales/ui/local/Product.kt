package com.fmauriciors.projectaromascafetales.ui.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Types


@Entity(tableName = "table_products")
data class Product(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") var id: Int = Types.NULL,
    @ColumnInfo(name="name") var productName: String = "",
    @ColumnInfo(name="author") var cost: String = "",
    @ColumnInfo(name="resume") var resumePlantation: String = ""
): Serializable