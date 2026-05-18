// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.modelpermissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectModelPermissionsTest {

    @Test
    fun create() {
        val projectModelPermissions =
            ProjectModelPermissions.builder()
                .mode(ProjectModelPermissions.Mode.ALLOW_LIST)
                .addModelId("string")
                .build()

        assertThat(projectModelPermissions.mode())
            .isEqualTo(ProjectModelPermissions.Mode.ALLOW_LIST)
        assertThat(projectModelPermissions.modelIds()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectModelPermissions =
            ProjectModelPermissions.builder()
                .mode(ProjectModelPermissions.Mode.ALLOW_LIST)
                .addModelId("string")
                .build()

        val roundtrippedProjectModelPermissions =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectModelPermissions),
                jacksonTypeRef<ProjectModelPermissions>(),
            )

        assertThat(roundtrippedProjectModelPermissions).isEqualTo(projectModelPermissions)
    }
}
