package com.ucb.framework.book.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ucb.framework.book.entity.BookEntity
import com.ucb.framework.local.dao.BookDao

@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        @Suppress("ktlint:standard:property-naming")
        @Volatile
        var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "books_db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
