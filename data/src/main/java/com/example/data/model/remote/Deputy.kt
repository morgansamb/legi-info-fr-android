package com.example.data.model.remote

import com.squareup.moshi.Json
import java.io.Serializable

data class Deputy(
        @field:Json(name = "depute") val content: DeputyContent
): Serializable

data class DeputyContent(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "id_an") val idAN: Int,
    @field:Json(name = "slug") val slug: String,
    @field:Json(name = "nom") val fullName: String,
    @field:Json(name = "sexe") val sex: String,
    @field:Json(name = "date_naissance") val dateOfBirth: String,
    @field:Json(name = "mandat_debut") val mandateBeg: String,
    @field:Json(name = "groupe_sigle") val groupAcronym: String,
)
