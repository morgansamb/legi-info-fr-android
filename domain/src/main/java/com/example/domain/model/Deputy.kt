package com.example.domain.model

import java.io.Serializable

data class Deputy(
    val id: Int,
    val idAN: Int,
    val slug: String,
    val name: String,
    val birthDate: String,
    val job: String? = null,
    val gender: String,
    val districtName: String,
    val districtNum: Int,
    val dateMandateMin: String,
    val numMandates: Int,
    val organization: String,
    val orgStatus: String,
    val orgDateMin: String,
    val otherMandates: List<String>,
    val weekAttendance: Int,
    val committeeAttendance: Int,
    val committeeIntervention: Int,
    val hemicycleIntervention: Int,
    val hemicycleShortIntervention: Int,
    val amendmentProposed: Int,
    val amendmentSigned: Int,
    val amendmentAdopted: Int,
    val report: Int,
    val writtenProposal: Int,
    val signedProposal: Int,
    val writtenQuestion: Int,
    val oralQuestion: Int,
): Serializable
