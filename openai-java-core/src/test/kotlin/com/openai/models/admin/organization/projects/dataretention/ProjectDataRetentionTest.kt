// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.dataretention

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectDataRetentionTest {

    @Test
    fun create() {
        val projectDataRetention =
            ProjectDataRetention.builder()
                .type(ProjectDataRetention.Type.ORGANIZATION_DEFAULT)
                .build()

        assertThat(projectDataRetention.type())
            .isEqualTo(ProjectDataRetention.Type.ORGANIZATION_DEFAULT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectDataRetention =
            ProjectDataRetention.builder()
                .type(ProjectDataRetention.Type.ORGANIZATION_DEFAULT)
                .build()

        val roundtrippedProjectDataRetention =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectDataRetention),
                jacksonTypeRef<ProjectDataRetention>(),
            )

        assertThat(roundtrippedProjectDataRetention).isEqualTo(projectDataRetention)
    }
}
