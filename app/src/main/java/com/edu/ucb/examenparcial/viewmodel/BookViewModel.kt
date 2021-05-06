package com.edu.ucb.examenparcial.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.edu.ucb.examenparcial.data.BookDatabase
import com.edu.ucb.examenparcial.model.Book
import com.edu.ucb.examenparcial.repository.BookRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

class BookViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Book>>
    private val repository: BookRepository
    init{
        val bookDao= BookDatabase.getDatabase(
            application
        ).bookDao()
        repository = BookRepository(bookDao)
        readAllData = repository.readAllData
    }

    fun addBook (book: Book){
        viewModelScope.launch(Dispatchers.IO){
            repository.addBook(book)
        }
    }

    fun updateBook (book: Book){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateBook(book)
        }
    }
}