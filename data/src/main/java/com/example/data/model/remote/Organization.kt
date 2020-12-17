package com.example.data.model.remote

import com.squareup.moshi.Json

data class Organization(
    @field:Json(name = "organisme") val content: OrganizationContent
)

data class OrganizationContent(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "slug") val slug: String,
    @field:Json(name = "acronyme") val acronym: String,
    @field:Json(name = "groupe_actuel") val actualGroup: Boolean,
    @field:Json(name = "nom") val name: String,
    @field:Json(name = "order") val order: Int,
)

