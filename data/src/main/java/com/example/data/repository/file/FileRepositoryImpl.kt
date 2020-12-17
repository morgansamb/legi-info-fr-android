package com.example.data.repository.file

import com.example.data.model.local.FileEntity
import com.example.data.model.mapper.toEntity
import com.example.data.source.file.LocalFileDataSource
import com.example.data.source.file.RemoteFileDataSource

class FileRepositoryImpl(
    private val remoteFileDataSource: RemoteFileDataSource,
    private val localFileDataSource: LocalFileDataSource
): FileRepository {

    override suspend fun getMostRecentFiles(): List<FileEntity> {
        val files = remoteFileDataSource.getMostRecentFiles()
        val entities = files.map { it.toEntity() }
        localFileDataSource.insertFiles(entities)

        return localFileDataSource.getFiles()
    }

    override suspend fun getFileById(id: Int): FileEntity {
        TODO("Not yet implemented")
    }
}
