package com.example.domain.usecase.deputy

import com.example.data.model.local.DeputyEntity
import com.example.data.repository.deputy.DeputyRepository
import com.example.domain.result.Result
import java.lang.Exception

class SearchDeputyUseCase(
    private val deputyRepository: DeputyRepository
) {
    suspend operator fun invoke(query: String?): Result<List<DeputyEntity>> = try {
        val like = "%$query%"
        val result = if (query.isNullOrEmpty()) deputyRepository.getDeputies()
        else deputyRepository.searchAllDeputies(like)
        Result.Success(result)
    } catch (e: Exception) {
        Result.Error(e)
    }
}
