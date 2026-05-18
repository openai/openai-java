// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.modelpermissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectModelPermissionsDeletedTest {

    @Test
    fun create() {
        val projectModelPermissionsDeleted =
            ProjectModelPermissionsDeleted.builder().deleted(true).build()

        assertThat(projectModelPermissionsDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectModelPermissionsDeleted =
            ProjectModelPermissionsDeleted.builder().deleted(true).build()

        val roundtrippedProjectModelPermissionsDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectModelPermissionsDeleted),
                jacksonTypeRef<ProjectModelPermissionsDeleted>(),
            )

        assertThat(roundtrippedProjectModelPermissionsDeleted)
            .isEqualTo(projectModelPermissionsDeleted)
    }
}
