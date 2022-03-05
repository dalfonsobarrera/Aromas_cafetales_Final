package com.fmauriciors.projectaromascafetales.ui.local;

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface ProductDao {

    @Insert
    suspend fun saveProduct ( product: Product)

    /*@Query("SELECT * FROM table_books WHERE name LIKE :nameBook")
    suspend fun searchBook (nameBook:String): Book

    @Delete
    suspend fun deleteBook(book: Book)

    @Query ("SELECT * FROM table_books")
    suspend fun loadBooks(): MutableList<Book>*/


}
