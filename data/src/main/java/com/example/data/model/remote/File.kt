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
    @field:Json(name = "nb_interventions") val nbInterventions: String
)