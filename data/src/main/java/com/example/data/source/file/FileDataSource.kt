package com.example.data.source.file

import com.example.data.model.remote.File

interface FileDataSource

interface RemoteFileDataSource {
    suspend fun getMostRecentFiles(): List<File>
}