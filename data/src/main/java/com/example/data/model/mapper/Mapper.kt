package com.example.data.model.mapper

import com.example.data.model.local.DeputyDetailEntity
import com.example.data.model.local.DeputyEntity
import com.example.data.model.local.DeputySynthesisEntity
import com.example.data.model.local.OrganizationEntity
import com.example.data.model.remote.Deputy
import com.example.data.model.remote.DeputyFull
import com.example.data.model.remote.DeputySynthesis
import com.example.data.model.remote.Organization

fun Deputy.toEntity(): DeputyEntity = DeputyEntity(
        id = this.content.id,
        idAN = this.content.idAN,
        slug = this.content.slug,
        fullName = this.content.fullName,
        gender = this.content.sex,
        birthDate = this.content.dateOfBirth,
        mandateBeg = this.content.mandateBeg
)

fun DeputyFull.toEntity() = DeputyDetailEntity(
        id = this.content.id,
        idAN = this.content.idAN,
        name = this.content.fullName,
        gender = this.content.gender,
        slug = this.content.slug,
        job = this.content.job,
        districtName = this.content.districtName,
        districtNum = this.content.districtNum,
        birthDate = this.content.birthDate,
        numMandates = this.content.mandatesNumber,
        organization = this.content.group.name,
        orgStatus = this.content.group.role,
        orgDateMin = this.content.group.roleDateBeg,
        dateMandateMin = this.content.mandateBeg,
        otherMandates = this.content.otherMandates.map { it.mandate }
)

fun DeputySynthesis.toEntity() = DeputySynthesisEntity(
        id = this.content.id,
        weekAttendance = this.content.weekAttendance,
        committeeAttendance = this.content.committeeAttendance,
        committeeIntervention = this.content.committeeIntervention,
        report = this.content.report,
        amendmentAdopted = this.content.amendmentAdopted,
        amendmentProposed = this.content.amendmentProposed,
        amendmentSigned = this.content.amendmentSigned,
        hemicycleShortIntervention = this.content.hemicycleShortIntervention,
        hemicycleIntervention = this.content.hemicycleIntervention,
        writtenProposal = this.content.writtenProposal,
        signedProposal = this.content.signedProposal,
        writtenQuestion = this.content.writtenQuestion,
        oralQuestion = this.content.oralQuestion
)

fun Organization.toEntity() = OrganizationEntity(
        id = this.content.id,
        slug = this.content.slug,
        acronym = this.content.acronym,
        actualGroup = this.content.actualGroup,
        name = this.content.name,
        order = this.content.order,
)
