package com.example.myproject.data.storage

import androidx.room.Dao
import androidx.room.Insert
import com.example.myproject.data.models.UserEntity
import io.reactivex.Completable

@Dao
interface UserDao {
    @Insert
    fun insertUsers(user: List<UserEntity>): Completable
}