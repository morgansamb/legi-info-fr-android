package com.example.data.repository.file

import com.example.data.model.remote.File

interface FileRepository {
    suspend fun getMostRecentFiles(): List<File>
}