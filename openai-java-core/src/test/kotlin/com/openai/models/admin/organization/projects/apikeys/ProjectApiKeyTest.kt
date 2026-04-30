// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.projects.serviceaccounts.ProjectServiceAccount
import com.openai.models.admin.organization.projects.users.ProjectUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectApiKeyTest {

    @Test
    fun create() {
        val projectApiKey =
            ProjectApiKey.builder()
                .id("id")
                .createdAt(0L)
                .lastUsedAt(0L)
                .name("name")
                .owner(
                    ProjectApiKey.Owner.builder()
                        .serviceAccount(
                            ProjectServiceAccount.builder()
                                .id("id")
                                .createdAt(0L)
                                .name("name")
                                .role(ProjectServiceAccount.Role.OWNER)
                                .build()
                        )
                        .type(ProjectApiKey.Owner.Type.USER)
                        .user(
                            ProjectUser.builder()
                                .id("id")
                                .addedAt(0L)
                                .email("email")
                                .name("name")
                                .role(ProjectUser.Role.OWNER)
                                .build()
                        )
                        .build()
                )
                .redactedValue("redacted_value")
                .build()

        assertThat(projectApiKey.id()).isEqualTo("id")
        assertThat(projectApiKey.createdAt()).isEqualTo(0L)
        assertThat(projectApiKey.lastUsedAt()).isEqualTo(0L)
        assertThat(projectApiKey.name()).isEqualTo("name")
        assertThat(projectApiKey.owner())
            .isEqualTo(
                ProjectApiKey.Owner.builder()
                    .serviceAccount(
                        ProjectServiceAccount.builder()
                            .id("id")
                            .createdAt(0L)
                            .name("name")
                            .role(ProjectServiceAccount.Role.OWNER)
                            .build()
                    )
                    .type(ProjectApiKey.Owner.Type.USER)
                    .user(
                        ProjectUser.builder()
                            .id("id")
                            .addedAt(0L)
                            .email("email")
                            .name("name")
                            .role(ProjectUser.Role.OWNER)
                            .build()
                    )
                    .build()
            )
        assertThat(projectApiKey.redactedValue()).isEqualTo("redacted_value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectApiKey =
            ProjectApiKey.builder()
                .id("id")
                .createdAt(0L)
                .lastUsedAt(0L)
                .name("name")
                .owner(
                    ProjectApiKey.Owner.builder()
                        .serviceAccount(
                            ProjectServiceAccount.builder()
                                .id("id")
                                .createdAt(0L)
                                .name("name")
                                .role(ProjectServiceAccount.Role.OWNER)
                                .build()
                        )
                        .type(ProjectApiKey.Owner.Type.USER)
                        .user(
                            ProjectUser.builder()
                                .id("id")
                                .addedAt(0L)
                                .email("email")
                                .name("name")
                                .role(ProjectUser.Role.OWNER)
                                .build()
                        )
                        .build()
                )
                .redactedValue("redacted_value")
                .build()

        val roundtrippedProjectApiKey =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectApiKey),
                jacksonTypeRef<ProjectApiKey>(),
            )

        assertThat(roundtrippedProjectApiKey).isEqualTo(projectApiKey)
    }
}
