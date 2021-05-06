package com.edu.ucb.examenparcial.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.edu.ucb.examenparcial.model.Book

@Database(entities = [Book:: class], version = 1, exportSchema = false )
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao ():IBookDao

    companion object{
        @Volatile
        private var INSTANCE:BookDatabase? = null

        fun getDatabase(context: Context):BookDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null ){
                return tempInstance
            }
            synchronized(this){
                val instance = databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "book_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}