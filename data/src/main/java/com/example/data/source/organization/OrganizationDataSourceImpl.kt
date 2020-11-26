package com.example.data.source.organization

import com.example.data.api.NosDeputesService
import com.example.data.db.dao.OrganizationDao
import com.example.data.model.local.OrganizationEntity
import com.example.data.model.remote.Organization

class RemoteOrganizationDataSourceImpl(
    private val nosDeputesService: NosDeputesService
): RemoteOrganizationDataSource {
    override suspend fun getOrganizations(): List<Organization> =
        nosDeputesService.getOrganizations().organizations
}

class LocalOrganizationDataSourceImpl(
    private val organizationDao: OrganizationDao
): LocalOrganizationDataSource {
    override suspend fun getOrganizations(): List<OrganizationEntity> =
        organizationDao.getOrganizations()

    override suspend fun insertOrganizations(organizations: List<OrganizationEntity>) {
        organizationDao.insertAll(organizations)
    }
}
