package com.example.data.source.deputy

import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.remote.Deputy
import com.example.data.model.remote.DeputyFull
import com.example.data.model.local.DeputyEntity
import com.example.data.model.local.DeputySynthesisEntity
import com.example.data.model.remote.DeputySynthesis

interface DeputyDataSource

interface RemoteDeputyDataSource: DeputyDataSource {
    suspend fun getCurrentDeputies(): List<Deputy>
    suspend fun getDeputy(slug: String): DeputyFull
    suspend fun getSynthesisAllTime(): List<DeputySynthesis>
}

interface LocalDeputyDataSource {
    suspend fun getCurrentDeputies(): List<DeputyEntity>
    suspend fun getDeputy(id: Int): DeputyDetailEntity
    suspend fun insertDeputies(deputies: List<DeputyEntity>)
    suspend fun insertDeputy(deputy: DeputyDetailEntity)
    suspend fun insertAllSynthesis(synthesis: List<DeputySynthesisEntity>)
    suspend fun getSynthesisByDeputy(id: Int): DeputySynthesisEntity
    suspend fun search(query: String): List<DeputyEntity>
}