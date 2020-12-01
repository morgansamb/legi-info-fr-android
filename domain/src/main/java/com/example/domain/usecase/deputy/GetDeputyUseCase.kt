package com.example.domain.usecase.deputy

import com.example.data.preference.PrefsStore
import com.example.data.repository.deputy.DeputyRepository
import com.example.domain.model.mapper.toDomain
import com.example.domain.result.Result
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.ChronoUnit

class GetDeputyUseCase(
    private val deputyRepository: DeputyRepository,
    private val prefsStore: PrefsStore
) {
    suspend operator fun invoke(slug: String) = try {
        val deputyEntity = deputyRepository.getDeputy(slug)
        // Only refresh synthesis if no previous fetch or was executed more than one day
        val force = if (!prefsStore.lastActivityFetch.isNullOrEmpty()) {
            val dateNow = LocalDate.now()
            val dateLastFetch = LocalDate.parse(prefsStore.lastActivityFetch)
            val diff = ChronoUnit.DAYS.between(dateLastFetch, dateNow)
            diff >= 1

        } else {
            true
        }
        val synthesis = deputyRepository.getSynthesisByDeputy(deputyEntity.id, force)
        val deputy = deputyEntity.toDomain(synthesis)
        Result.Success(deputy)
    } catch (e: Exception) {
        Result.Error(e)
    }
}
