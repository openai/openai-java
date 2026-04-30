// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectUserTest {

    @Test
    fun create() {
        val projectUser =
            ProjectUser.builder()
                .id("id")
                .addedAt(0L)
                .email("email")
                .name("name")
                .role(ProjectUser.Role.OWNER)
                .build()

        assertThat(projectUser.id()).isEqualTo("id")
        assertThat(projectUser.addedAt()).isEqualTo(0L)
        assertThat(projectUser.email()).isEqualTo("email")
        assertThat(projectUser.name()).isEqualTo("name")
        assertThat(projectUser.role()).isEqualTo(ProjectUser.Role.OWNER)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectUser =
            ProjectUser.builder()
                .id("id")
                .addedAt(0L)
                .email("email")
                .name("name")
                .role(ProjectUser.Role.OWNER)
                .build()

        val roundtrippedProjectUser =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectUser),
                jacksonTypeRef<ProjectUser>(),
            )

        assertThat(roundtrippedProjectUser).isEqualTo(projectUser)
    }
}
