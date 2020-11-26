package com.example.data.repository.deputy

import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.local.DeputyEntity

interface DeputyRepository {
    suspend fun getDeputies(): List<DeputyEntity>
    suspend fun getDeputy(slug: String): DeputyDetailEntity
}
