package com.example.data.repository.deputy

import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.local.DeputyEntity
import com.example.data.model.local.DeputySynthesisEntity
import com.example.data.model.mapper.toEntity
import com.example.data.source.deputy.LocalDeputyDataSource
import com.example.data.source.deputy.RemoteDeputyDataSource

class DeputyRepositoryImpl(
    private val remoteSource: RemoteDeputyDataSource,
    private val localSource: LocalDeputyDataSource
): DeputyRepository {

    override suspend fun getDeputies(): List<DeputyEntity> {
        val deputies = remoteSource.getCurrentDeputies()
        val entities = deputies.map { it.toEntity() }
        localSource.insertDeputies(entities)

        return localSource.getCurrentDeputies()
    }

    override suspend fun getDeputy(slug: String): DeputyDetailEntity {
        val deputyEntity = remoteSource.getDeputy(slug).toEntity()
        localSource.insertDeputy(deputyEntity)

        return localSource.getDeputy(deputyEntity.id)
    }

    override suspend fun getSynthesisByDeputy(id: Int, force: Boolean): DeputySynthesisEntity {
        if (force) {
            val synthesis = remoteSource.getSynthesisAllTime().map { it.toEntity() }
            localSource.insertAllSynthesis(synthesis)
        }

        return localSource.getSynthesisByDeputy(id)
    }
}
