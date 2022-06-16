package com.example.myproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myproject.data.models.InformationEntity

@Database(entities = [InformationEntity::class], version = 4)
abstract class AppDatabase: RoomDatabase()  {
    abstract fun weeksDao(): InformationDao

    companion object {
        const val DB_NAME = "example.db"
    }
}