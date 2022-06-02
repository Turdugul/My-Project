package com.example.myproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myproject.data.models.InformationEntity

@Dao
interface InformationDao {

    @Query("SELECT * FROM InformationEntity")
    fun getAll(): LiveData<List<InformationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(booksList: List<InformationEntity>)
}