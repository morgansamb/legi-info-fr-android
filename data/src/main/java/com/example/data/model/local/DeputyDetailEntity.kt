package com.example.data.model.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.TypeConverters
import com.example.data.db.converter.DeputyDetailConverter
import java.io.Serializable

@Entity(
    tableName = "deputy_detail",
    primaryKeys = ["id"],
    foreignKeys = [
        ForeignKey(entity = DeputyEntity::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
@TypeConverters(DeputyDetailConverter::class)
data class DeputyDetailEntity(
    val id: Int,
    val idAN: Int,
    val slug: String,
    val job: String,
    val name: String,
    val gender: String,
    val birthDate: String,
    val districtName: String,
    val districtNum: Int,
    val dateMandateMin: String,
    val numMandates: Int,
    val organization: String,
    val orgStatus: String,
    val orgDateMin: String,
    val otherMandates: List<String>
): Serializable
