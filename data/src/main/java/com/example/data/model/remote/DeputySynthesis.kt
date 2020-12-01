package com.example.data.model.remote

import com.squareup.moshi.Json

data class DeputySynthesis(
    @field:Json(name = "depute") val content: DeputySynthesisContent
)

data class DeputySynthesisContent(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "semaines_presence") val weekAttendance: Int,
    @field:Json(name = "commission_presences") val committeeAttendance: Int,
    @field:Json(name = "commission_interventions") val committeeIntervention: Int,
    @field:Json(name = "hemicycle_interventions") val hemicycleIntervention: Int,
    @field:Json(name = "hemicycle_interventions_courtes") val hemicycleShortIntervention: Int,
    @field:Json(name = "amendements_proposes") val amendmentProposed: Int,
    @field:Json(name = "amendements_signes") val amendmentSigned: Int,
    @field:Json(name = "amendements_adoptes") val amendmentAdopted: Int,
    @field:Json(name = "rapports") val report: Int,
    @field:Json(name = "propositions_ecrites") val writtenProposal: Int,
    @field:Json(name = "propositions_signees") val signedProposal: Int,
    @field:Json(name = "questions_ecrites") val writtenQuestion: Int,
    @field:Json(name = "questions_orales") val oralQuestion: Int
)
