package com.example.domain.usecase.deputy

import com.example.data.repository.deputy.DeputyRepository
import com.example.domain.result.Result

class GetDeputyUseCase(
    private val deputyRepository: DeputyRepository
) {
    suspend operator fun invoke(slug: String) = try {
        val deputy = deputyRepository.getDeputy(slug)
        Result.Success(deputy)
    } catch (e: Exception) {
        Result.Error(e)
    }
}
