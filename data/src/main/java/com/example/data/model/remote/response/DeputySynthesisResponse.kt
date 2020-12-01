package com.example.data.model.remote.response

import com.example.data.model.remote.DeputySynthesis
import com.squareup.moshi.Json

data class DeputySynthesisResponse(
    @field: Json(name = "deputes") val deputies: List<DeputySynthesis>
)
