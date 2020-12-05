package com.example.data.source.deputy

import com.example.data.api.NosDeputesService
import com.example.data.db.dao.DeputyDao
import com.example.data.db.dao.DeputyDetailDao
import com.example.data.db.dao.DeputySynthesisDao
import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.local.DeputyEntity
import com.example.data.model.local.DeputySynthesisEntity
import com.example.data.model.remote.Deputy
import com.example.data.model.remote.DeputyFull
import com.example.data.model.remote.DeputySynthesis

class RemoteDeputyDataSourceImpl(
    private val nosDeputesService: NosDeputesService
): RemoteDeputyDataSource {

    override suspend fun getCurrentDeputies(): List<Deputy> =
        nosDeputesService.getCurrentDeputies().deputies

    override suspend fun getDeputy(slug: String): DeputyFull =
        nosDeputesService.getDeputyInformation(slug)

    override suspend fun getSynthesisAllTime() =
        nosDeputesService.getDeputiesSynthesisAllTime().deputies
}

class LocalDeputyDataSourceImpl(
    private val deputyDao: DeputyDao,
    private val deputyDetailDao: DeputyDetailDao,
    private val deputySynthesisDao: DeputySynthesisDao
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

    override suspend fun insertAllSynthesis(synthesis: List<DeputySynthesisEntity>) {
        deputySynthesisDao.insertAll(synthesis)
    }

    override suspend fun getSynthesisByDeputy(id: Int) =
        deputySynthesisDao.getSynthesisByDeputy(id)

    override suspend fun search(query: String) =
        deputyDao.search(query)
}
