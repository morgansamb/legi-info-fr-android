package com.example.data.model.local

import androidx.room.Entity

@Entity(
    tableName = "organization",
    primaryKeys = ["id"]
)
data class OrganizationEntity(
    val id: Int,
    val slug: String,
    val acronym: String,
    val actualGroup: Boolean,
    val name: String,
    val order: Int
)
