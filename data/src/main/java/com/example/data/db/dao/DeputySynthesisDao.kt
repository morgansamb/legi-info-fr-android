package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.local.DeputySynthesisEntity

@Dao
interface DeputySynthesisDao {

    @Query("SELECT * FROM deputy_synthesis WHERE id=:id")
    suspend fun getSynthesisByDeputy(id: Int): DeputySynthesisEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(synthesis: List<DeputySynthesisEntity>)
}