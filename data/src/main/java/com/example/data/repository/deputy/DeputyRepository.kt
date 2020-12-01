package com.example.data.repository.deputy

import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.local.DeputyEntity
import com.example.data.model.local.DeputySynthesisEntity

interface DeputyRepository {
    suspend fun getDeputies(): List<DeputyEntity>
    suspend fun getDeputy(slug: String): DeputyDetailEntity
    suspend fun getSynthesisByDeputy(id: Int, force: Boolean = false): DeputySynthesisEntity
}
