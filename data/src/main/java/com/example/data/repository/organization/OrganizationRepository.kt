package com.example.data.repository.organization

import com.example.data.model.local.OrganizationEntity

interface OrganizationRepository {
    suspend fun getOrganizations(): List<OrganizationEntity>
}
