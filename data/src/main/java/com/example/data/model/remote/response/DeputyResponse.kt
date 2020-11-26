package com.example.data.model.remote.response


import com.example.data.model.remote.Deputy
import com.squareup.moshi.Json


data class DeputyResponse(
    @field:Json(name = "deputes") val deputies: List<Deputy>
)