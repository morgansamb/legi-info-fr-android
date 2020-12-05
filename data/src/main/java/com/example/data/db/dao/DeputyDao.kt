package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.local.DeputyEntity

@Dao
interface DeputyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(deputies: List<DeputyEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(deputy: DeputyEntity)

    @Query("SELECT * FROM deputy")
    suspend fun getDeputies(): List<DeputyEntity>

    @Query("SELECT * FROM deputy WHERE id=:id")
    suspend fun getDeputy(id: Int): DeputyEntity

    @Query("""
        SELECT *
        FROM deputy
        WHERE fullName LIKE :query OR slug LIKE :query
        """)
    suspend fun search(query: String): List<DeputyEntity>
}
