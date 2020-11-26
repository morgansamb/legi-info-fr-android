package com.example.data.model.remote.response

import com.example.data.model.remote.Organization
import com.squareup.moshi.Json

data class OrganizationResponse(
    @field:Json(name = "organismes") val organizations: List<Organization>
)