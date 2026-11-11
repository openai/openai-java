// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.modelpermissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectModelPermissionsTest {

    @Test
    fun createAndRoundtrip() {
        val projectModelPermissions =
            ProjectModelPermissions.builder()
                .mode(ProjectModelPermissions.Mode.ALLOW_LIST)
                .addModelId("string")
                .build()

        assertThat(projectModelPermissions.mode()).contains(ProjectModelPermissions.Mode.ALLOW_LIST)
        assertThat(projectModelPermissions.modelIds().getOrNull()).containsExactly("string")

        val jsonMapper = jsonMapper()

        val roundtrippedProjectModelPermissions =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectModelPermissions),
                jacksonTypeRef<ProjectModelPermissions>(),
            )

        assertThat(roundtrippedProjectModelPermissions).isEqualTo(projectModelPermissions)
    }
}
