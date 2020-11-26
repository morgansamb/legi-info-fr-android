package com.example.data.source.deputy

import com.example.data.api.NosDeputesService
import com.example.data.db.dao.DeputyDao
import com.example.data.db.dao.DeputyDetailDao
import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.local.DeputyEntity
import com.example.data.model.remote.Deputy
import com.example.data.model.remote.DeputyFull

class RemoteDeputyDataSourceImpl(
    private val nosDeputesService: NosDeputesService
): RemoteDeputyDataSource {

    override suspend fun getCurrentDeputies(): List<Deputy> =
        nosDeputesService.getCurrentDeputies().deputies

    override suspend fun getDeputy(slug: String): DeputyFull =
        nosDeputesService.getDeputyInformation(slug)
}

class LocalDeputyDataSourceImpl(
    private val deputyDao: DeputyDao,
    private val deputyDetailDao: DeputyDetailDao
): LocalDeputyDataSource {

    override suspend fun getCurrentDeputies(): List<DeputyEntity> =
        deputyDao.getDeputies()

    override suspend fun insertDeputies(deputies: List<DeputyEntity>) {
        deputyDao.insertAll(deputies)
    }

    override suspend fun getDeputy(id: Int): DeputyDetailEntity =
        deputyDetailDao.getDeputy(id)

    override suspend fun insertDeputy(deputy: DeputyDetailEntity) {
        deputyDetailDao.insert(deputy)
    }
}
