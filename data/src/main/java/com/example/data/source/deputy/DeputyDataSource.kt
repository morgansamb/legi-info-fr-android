package com.example.data.source.deputy

import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.remote.Deputy
import com.example.data.model.remote.DeputyFull
import com.example.data.model.local.DeputyEntity

interface DeputyDataSource

interface RemoteDeputyDataSource: DeputyDataSource {
    suspend fun getCurrentDeputies(): List<Deputy>
    suspend fun getDeputy(slug: String): DeputyFull
}

interface LocalDeputyDataSource {
    suspend fun getCurrentDeputies(): List<DeputyEntity>
    suspend fun getDeputy(id: Int): DeputyDetailEntity
    suspend fun insertDeputies(deputies: List<DeputyEntity>)
    suspend fun insertDeputy(deputy: DeputyDetailEntity)
}