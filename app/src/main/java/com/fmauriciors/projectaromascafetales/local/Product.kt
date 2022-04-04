package com.fmauriciors.projectaromascafetales.local

import android.provider.ContactsContract
import android.text.Html
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Types.NULL


@Entity(tableName = "table_products")
data class Product(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") var id: Int = NULL,
    @ColumnInfo(name="productName") var nameProduct: String = "",
    @ColumnInfo(name="cost") var cost: String = "",
    @ColumnInfo(name="resumePlantation") var resumePlantation: String = "",
): Serializable