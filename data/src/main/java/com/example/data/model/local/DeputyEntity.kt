package com.example.data.model.local

import androidx.room.Entity
import java.io.Serializable

@Entity(
    tableName = "deputy",
    primaryKeys = ["id"]
)
data class DeputyEntity(
    val id: Int,
    val idAN: Int,
    val slug: String,
    val fullName: String,
    val gender: String,
    val birthDate: String,
    val mandateBeg: String
): Serializable
