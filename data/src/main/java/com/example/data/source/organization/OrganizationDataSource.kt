package com.example.data.source.organization

import com.example.data.model.local.OrganizationEntity
import com.example.data.model.remote.Organization

interface OrganizationDataSource

interface RemoteOrganizationDataSource: OrganizationDataSource {
    suspend fun getOrganizations(): List<Organization>
}

interface LocalOrganizationDataSource: OrganizationDataSource {
    suspend fun getOrganizations(): List<OrganizationEntity>

    suspend fun insertOrganizations(organizations: List<OrganizationEntity>)
}