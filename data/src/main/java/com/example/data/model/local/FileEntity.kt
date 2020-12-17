package com.example.data.model.local

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.data.db.converter.FileConverter
import java.io.Serializable

@Entity(
    tableName = "file",
    primaryKeys = ["id"]
)
@TypeConverters(FileConverter::class)
data class FileEntity(
    val id: Int,
    val idFile: String,
    val title: String,
    val minDate: String,
    val maxDate: String,
    val nbInterventions: String,
    val sessions: List<Session>?,
    val documents: List<Document>?
): Serializable

data class Session(
    val id: String,
    val type: String,
    val date: String,
    val hour: String,
    val session: String,
    val organism: String
)

data class Document(
    val id: String,
    val number: Int,
    val type: String,
    val title: String,
    val date: String,
    val signatories: String
)
