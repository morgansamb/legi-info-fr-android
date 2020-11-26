package com.example.domain.usecase.organization

import com.example.data.repository.organization.OrganizationRepository
import com.example.domain.result.Result
import java.lang.Exception

class GetOrganizationsUseCase(
    private val organizationRepository: OrganizationRepository
) {

    suspend operator fun invoke() = try {
        val organizations = organizationRepository.getOrganizations()
        Result.Success(organizations)
    } catch (e: Exception) {
        Result.Error(e)
    }
}
