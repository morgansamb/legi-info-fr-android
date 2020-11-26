package com.example.data.model.remote

import com.squareup.moshi.Json
import java.io.Serializable

data class DeputyFull(
    @field:Json(name = "depute") val content: DeputyFullContent
): Serializable

data class DeputyFullContent(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "id_an") val idAN: Int,
    @field:Json(name = "slug") val slug: String,
    @field:Json(name = "nom") val fullName: String,
    @field:Json(name = "sexe") val gender: String,
    @field:Json(name = "date_naissance") val birthDate: String,
    @field:Json(name = "nom_circo") val districtName: String,
    @field:Json(name = "num_circo") val districtNum: Int,
    @field:Json(name = "mandat_debut") val mandateBeg: String,
    @field:Json(name = "nb_mandats") val mandatesNumber: Int,
    @field:Json(name = "groupe") val group: DeputyOrganization,
    @field:Json(name = "profession") val job: String,
    @field:Json(name = "autres_mandats") val otherMandates: List<DeputyMandate>,
)

data class DeputyOrganization(
    @field:Json(name = "organisme") val name: String,
    @field:Json(name = "fonction") val role: String,
    @field:Json(name = "debut_fonction") val roleDateBeg: String,
)

data class DeputyMandate(
    @field:Json(name = "mandat") val mandate: String
)
