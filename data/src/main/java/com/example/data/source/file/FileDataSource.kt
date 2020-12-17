package com.example.data.source.file

import com.example.data.model.local.FileEntity
import com.example.data.model.remote.File

interface FileDataSource

interface RemoteFileDataSource: FileDataSource {
    suspend fun getMostRecentFiles(): List<File>
    suspend fun getFileById(id: Int): File
}

interface LocalFileDataSource: FileDataSource {
    suspend fun getFiles(): List<FileEntity>
    suspend fun getFileById(id: Int): FileEntity
    suspend fun insertFiles(files: List<FileEntity>)
}
