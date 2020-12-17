package com.example.data.repository.file

import com.example.data.model.local.FileEntity

interface FileRepository {
    suspend fun getMostRecentFiles(): List<FileEntity>
    suspend fun getFileById(id: Int): FileEntity
}
