package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.local.OrganizationEntity

@Dao
interface OrganizationDao {
    @Query("SELECT * FROM organization")
    suspend fun getOrganizations(): List<OrganizationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(organizations: List<OrganizationEntity>)
}
