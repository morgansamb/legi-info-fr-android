package com.example.data.model.local

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "deputy_synthesis",
    primaryKeys = ["id"],
    foreignKeys = [ForeignKey(
        entity = DeputyEntity::class,
        parentColumns = ["id"],
        childColumns = ["id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class DeputySynthesisEntity(
    val id: Int,
    val weekAttendance: Int,
    val committeeAttendance: Int,
    val committeeIntervention: Int,
    val hemicycleIntervention: Int,
    val hemicycleShortIntervention: Int,
    val amendmentProposed: Int,
    val amendmentSigned: Int,
    val amendmentAdopted: Int,
    val report: Int,
    val writtenProposal: Int,
    val signedProposal: Int,
    val writtenQuestion: Int,
    val oralQuestion: Int
)
