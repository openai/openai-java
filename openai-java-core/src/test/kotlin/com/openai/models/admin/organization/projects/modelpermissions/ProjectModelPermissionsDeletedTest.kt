// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.modelpermissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectModelPermissionsDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val projectModelPermissionsDeleted =
            ProjectModelPermissionsDeleted.builder().deleted(true).build()

        assertThat(projectModelPermissionsDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedProjectModelPermissionsDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectModelPermissionsDeleted),
                jacksonTypeRef<ProjectModelPermissionsDeleted>(),
            )

        assertThat(roundtrippedProjectModelPermissionsDeleted)
            .isEqualTo(projectModelPermissionsDeleted)
    }
}
