package com.example.data.api

import com.example.data.model.remote.DeputyFull
import com.example.data.model.remote.File
import com.example.data.model.remote.response.DeputyResponse
import com.example.data.model.remote.response.DeputySynthesisResponse
import com.example.data.model.remote.response.FileResponse
import com.example.data.model.remote.response.OrganizationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NosDeputesService {

    @GET("deputes/enmandat/json")
    suspend fun getCurrentDeputies(): DeputyResponse

    @GET("{slug}/json")
    suspend fun getDeputyInformation(
        @Path("slug") slug: String
    ): DeputyFull

    @GET("organismes/groupe/json")
    suspend fun getOrganizations(): OrganizationResponse

    @GET("15/dossiers/date/json")
    suspend fun getMostRecentFiles(): FileResponse

    @GET("15/dossier/{id}/json")
    suspend fun getFileById(
        @Path("id") id: Int
    ): File

    @GET("synthese/data/json")
    suspend fun getDeputiesSynthesisAllTime(): DeputySynthesisResponse
}
