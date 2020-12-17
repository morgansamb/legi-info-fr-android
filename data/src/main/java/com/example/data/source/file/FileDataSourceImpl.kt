package com.example.data.source.file

import com.example.data.api.NosDeputesService
import com.example.data.db.dao.FileDao
import com.example.data.model.local.FileEntity
import com.example.data.model.remote.File

class RemoteFileDataSourceImpl(
    private val nosDeputesService: NosDeputesService
): RemoteFileDataSource {

    override suspend fun getMostRecentFiles(): List<File> =
        nosDeputesService.getMostRecentFiles().files

    override suspend fun getFileById(id: Int): File =
        nosDeputesService.getFileById(id)
}


class LocalFileDataSourceImpl(
    private val fileDao: FileDao
): LocalFileDataSource {

    override suspend fun getFiles(): List<FileEntity> =
        fileDao.getMostRecentFiles()

    override suspend fun getFileById(id: Int): FileEntity =
        fileDao.getFileById(id)

    override suspend fun insertFiles(files: List<FileEntity>) {
        fileDao.insertFiles(files)
    }
}
