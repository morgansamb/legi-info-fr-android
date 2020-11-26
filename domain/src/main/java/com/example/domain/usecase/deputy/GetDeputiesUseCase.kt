package com.example.domain.usecase.deputy

import com.example.data.model.local.DeputyEntity
import com.example.data.repository.deputy.DeputyRepository
import com.example.domain.result.Result
import java.lang.Exception

class GetDeputiesUseCase(
    private val deputyRepository: DeputyRepository
) {
    suspend operator fun invoke(): Result<List<DeputyEntity>> {
        return try {
            val deputies = deputyRepository.getDeputies()
            return Result.Success(deputies)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
