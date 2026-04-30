// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectServiceAccountTest {

    @Test
    fun create() {
        val projectServiceAccount =
            ProjectServiceAccount.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .role(ProjectServiceAccount.Role.OWNER)
                .build()

        assertThat(projectServiceAccount.id()).isEqualTo("id")
        assertThat(projectServiceAccount.createdAt()).isEqualTo(0L)
        assertThat(projectServiceAccount.name()).isEqualTo("name")
        assertThat(projectServiceAccount.role()).isEqualTo(ProjectServiceAccount.Role.OWNER)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectServiceAccount =
            ProjectServiceAccount.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .role(ProjectServiceAccount.Role.OWNER)
                .build()

        val roundtrippedProjectServiceAccount =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectServiceAccount),
                jacksonTypeRef<ProjectServiceAccount>(),
            )

        assertThat(roundtrippedProjectServiceAccount).isEqualTo(projectServiceAccount)
    }
}
