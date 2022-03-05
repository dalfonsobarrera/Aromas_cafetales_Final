package com.fmauriciors.projectaromascafetales.ui.repositorybd;

import com.fmauriciors.projectaromascafetales.ui.ProductProject
import com.fmauriciors.projectaromascafetales.ui.local.Product;
import com.fmauriciors.projectaromascafetales.ui.local.ProductDao
import java.sql.Types.NULL

class ProductRepository {

    suspend fun saveProduct(
        productName: String,
        cost: String,
        resumePlantation: String

    ) {
        val product = Product(

            id = NULL,
            productName = productName,
            cost = cost,
            resumePlantation = resumePlantation
        )

        val productDao : ProductDao = ProductProject.database.ProductDao()
        productDao.saveProduct(product)
    }
/*
    suspend fun searchBook(nameBook: String): Book {
        val bookDao: BookDao = BookProject.database.BookDao()
        val  book= bookDao.searchBook(nameBook)
        return book
    }

    suspend fun deleteBook(book: Book) {
        val bookDao: BookDao = BookProject.database.BookDao()
        bookDao.deleteBook(book)
    }

    suspend fun loadBooks(): ArrayList<Book>{
        val bookDao: BookDao = BookProject.database.BookDao()
        val booksList : ArrayList<Book> = bookDao.loadBooks() as ArrayList<Book>
        return booksList

    }*/

}
