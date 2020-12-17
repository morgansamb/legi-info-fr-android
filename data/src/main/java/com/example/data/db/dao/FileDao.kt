package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.local.FileEntity

@Dao
interface FileDao {

    @Query("SELECT * FROM file ORDER BY maxDate DESC")
    suspend fun getMostRecentFiles(): List<FileEntity>

    @Query("SELECT * FROM file WHERE id=:id")
    suspend fun getFileById(id: Int): FileEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFiles(files: List<FileEntity>)
}
