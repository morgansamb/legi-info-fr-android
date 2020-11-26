package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.local.DeputyDetailEntity

@Dao
interface DeputyDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(deputy: DeputyDetailEntity)

    @Query("SELECT * FROM deputy_detail WHERE id=:id")
    suspend fun getDeputy(id: Int): DeputyDetailEntity
}