package com.example.domain.model.mapper

import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.local.DeputySynthesisEntity
import com.example.domain.model.Deputy

fun DeputyDetailEntity.toDomain(synthesis: DeputySynthesisEntity) = Deputy(
    id = this.id,
    idAN = this.idAN,
    slug = this.slug,
    name = this.name,
    birthDate = this.birthDate,
    job = this.job,
    gender = this.gender,
    districtName = this.districtName,
    districtNum = this.districtNum,
    dateMandateMin = this.dateMandateMin,
    numMandates = this.numMandates,
    organization = this.organization,
    orgStatus = this.orgStatus,
    orgDateMin = this.orgDateMin,
    otherMandates = this.otherMandates,
    weekAttendance = synthesis.weekAttendance,
    committeeAttendance = synthesis.committeeAttendance,
    committeeIntervention = synthesis.committeeIntervention,
    hemicycleIntervention = synthesis.hemicycleIntervention,
    hemicycleShortIntervention = synthesis.hemicycleShortIntervention,
    amendmentProposed = synthesis.amendmentProposed,
    amendmentSigned = synthesis.amendmentSigned,
    amendmentAdopted = synthesis.amendmentAdopted,
    report = synthesis.report,
    writtenProposal = synthesis.writtenProposal,
    signedProposal = synthesis.signedProposal,
    writtenQuestion = synthesis.writtenQuestion,
    oralQuestion = synthesis.oralQuestion,
)