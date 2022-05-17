package com.example.myproject.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myproject.data.models.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun userDao(): UserDao


    companion object {
        const val DB_NAME = "example.db"
    }
}