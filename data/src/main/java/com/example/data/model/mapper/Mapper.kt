package com.example.data.model.mapper

import com.example.data.model.local.*
import com.example.data.model.local.Document
import com.example.data.model.local.Session
import com.example.data.model.remote.*

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

fun File.toEntity() = FileEntity(
        id = this.content.id,
        idFile = this.content.idFile,
        title = this.content.title,
        minDate = this.content.minDate,
        maxDate = this.content.maxDate,
        nbInterventions = this.content.nbInterventions,
        sessions = this.content.sessions?.map { s -> Session(
                id = s.content.id,
                type = s.content.type,
                date = s.content.date,
                hour = s.content.hour,
                session = s.content.session,
                organism = s.content.organism
        ) },
        documents = this.content.documents?.map { d -> Document(
                id = d.content.id,
                number = d.content.number,
                type = d.content.type,
                title = d.content.title,
                date = d.content.date,
                signatories = d.content.signatories,
        ) }
)
