package com.example.data.model.remote.response

import com.example.data.model.remote.File
import com.squareup.moshi.Json

data class FileResponse(
    @field:Json(name = "sections") val files: List<File>
)