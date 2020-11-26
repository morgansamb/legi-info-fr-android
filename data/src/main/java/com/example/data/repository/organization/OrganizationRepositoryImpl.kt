package com.example.data.repository.organization

import com.example.data.model.local.OrganizationEntity
import com.example.data.model.mapper.toEntity
import com.example.data.source.organization.LocalOrganizationDataSource
import com.example.data.source.organization.RemoteOrganizationDataSource

class OrganizationRepositoryImpl(
    private val remoteSource: RemoteOrganizationDataSource,
    private val localSource: LocalOrganizationDataSource
): OrganizationRepository {

    override suspend fun getOrganizations(): List<OrganizationEntity> {
        val orgs = remoteSource.getOrganizations().map { it.toEntity() }
        localSource.insertOrganizations(orgs)

        return localSource.getOrganizations()
    }
}
