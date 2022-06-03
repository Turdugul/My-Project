package com.example.myproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myproject.data.models.InformationEntity

@Database(entities = [InformationEntity::class], version = 3)
abstract class AppDatabase: RoomDatabase()  {
    abstract fun booksDao(): InformationDao

    companion object {
        const val DB_NAME = "example.db"
    }
}