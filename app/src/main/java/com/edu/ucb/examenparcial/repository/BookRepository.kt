package com.edu.ucb.examenparcial.repository

import androidx.lifecycle.LiveData
import com.edu.ucb.examenparcial.data.IBookDao
import com.edu.ucb.examenparcial.model.Book


class BookRepository (private val bookDao: IBookDao) {

    val readAllData: LiveData<List<Book>> = bookDao.readAllData()

    suspend fun  addBook  (book: Book){
        bookDao.addBook(book)
    }

    suspend fun updateBook(book: Book){
        bookDao.updateBook(book)
    }
}