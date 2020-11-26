package com.example.data.repository.file

import com.example.data.source.file.RemoteFileDataSource

class FileRepositoryImpl(
    private val remoteFileDataSource: RemoteFileDataSource
): FileRepository {

    override suspend fun getMostRecentFiles() =
        remoteFileDataSource.getMostRecentFiles()
}
