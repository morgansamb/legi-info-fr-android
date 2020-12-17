package com.example.data.model.remote

import com.squareup.moshi.Json

data class File(
    @field:Json(name = "section") val content: FileContent
)

data class FileContent(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "id_dossier_institution") val idFile: String,
    @field:Json(name = "titre") val title: String,
    @field:Json(name = "min_date") val minDate: String,
    @field:Json(name = "max_date") val maxDate: String,
    @field:Json(name = "nb_interventions") val nbInterventions: String,
    @field:Json(name = "seances") val sessions: List<SessionContent>?,
    @field:Json(name = "documents") val documents: List<DocumentContent>?
)

data class SessionContent(
    @field:Json(name = "seance") val content: Session,
)

data class Session(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "type") val type: String,
    @field:Json(name = "date") val date: String,
    @field:Json(name = "heure") val hour: String,
    @field:Json(name = "session") val session: String,
    @field:Json(name = "organisme") val organism: String
)

data class DocumentContent(
    @field:Json(name = "document") val content: Document,
)

data class Document(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "numero") val number: Int,
    @field:Json(name = "type") val type: String,
    @field:Json(name = "titre") val title: String,
    @field:Json(name = "date") val date: String,
    @field:Json(name = "signataires") val signatories: String
)