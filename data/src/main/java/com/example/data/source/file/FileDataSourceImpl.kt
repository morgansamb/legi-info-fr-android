package com.example.data.source.file

import com.example.data.api.NosDeputesService
import com.example.data.model.remote.File

class RemoteFileDataSourceImpl(
    private val nosDeputesService: NosDeputesService
): RemoteFileDataSource {

    override suspend fun getMostRecentFiles(): List<File> =
        nosDeputesService.getMostRecentFiles().files
}
