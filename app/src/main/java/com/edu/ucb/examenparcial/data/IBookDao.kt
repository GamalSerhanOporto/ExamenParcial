package com.edu.ucb.examenparcial.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.edu.ucb.examenparcial.model.Book

@Dao
interface IBookDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun addBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Query( "SELECT * FROM book_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Book>>
}