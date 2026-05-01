// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyListPageResponseTest {

    @Test
    fun create() {
        val apiKeyListPageResponse =
            ApiKeyListPageResponse.builder()
                .addData(
                    ProjectApiKey.builder()
                        .id("id")
                        .createdAt(0L)
                        .lastUsedAt(0L)
                        .name("name")
                        .owner(
                            ProjectApiKey.Owner.builder()
                                .serviceAccount(
                                    ProjectApiKey.Owner.ServiceAccount.builder()
                                        .id("id")
                                        .createdAt(0L)
                                        .name("name")
                                        .role("role")
                                        .build()
                                )
                                .type(ProjectApiKey.Owner.Type.USER)
                                .user(
                                    ProjectApiKey.Owner.User.builder()
                                        .id("id")
                                        .createdAt(0L)
                                        .email("email")
                                        .name("name")
                                        .role("role")
                                        .build()
                                )
                                .build()
                        )
                        .redactedValue("redacted_value")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(apiKeyListPageResponse.data())
            .containsExactly(
                ProjectApiKey.builder()
                    .id("id")
                    .createdAt(0L)
                    .lastUsedAt(0L)
                    .name("name")
                    .owner(
                        ProjectApiKey.Owner.builder()
                            .serviceAccount(
                                ProjectApiKey.Owner.ServiceAccount.builder()
                                    .id("id")
                                    .createdAt(0L)
                                    .name("name")
                                    .role("role")
                                    .build()
                            )
                            .type(ProjectApiKey.Owner.Type.USER)
                            .user(
                                ProjectApiKey.Owner.User.builder()
                                    .id("id")
                                    .createdAt(0L)
                                    .email("email")
                                    .name("name")
                                    .role("role")
                                    .build()
                            )
                            .build()
                    )
                    .redactedValue("redacted_value")
                    .build()
            )
        assertThat(apiKeyListPageResponse.hasMore()).isEqualTo(true)
        assertThat(apiKeyListPageResponse.firstId()).contains("first_id")
        assertThat(apiKeyListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiKeyListPageResponse =
            ApiKeyListPageResponse.builder()
                .addData(
                    ProjectApiKey.builder()
                        .id("id")
                        .createdAt(0L)
                        .lastUsedAt(0L)
                        .name("name")
                        .owner(
                            ProjectApiKey.Owner.builder()
                                .serviceAccount(
                                    ProjectApiKey.Owner.ServiceAccount.builder()
                                        .id("id")
                                        .createdAt(0L)
                                        .name("name")
                                        .role("role")
                                        .build()
                                )
                                .type(ProjectApiKey.Owner.Type.USER)
                                .user(
                                    ProjectApiKey.Owner.User.builder()
                                        .id("id")
                                        .createdAt(0L)
                                        .email("email")
                                        .name("name")
                                        .role("role")
                                        .build()
                                )
                                .build()
                        )
                        .redactedValue("redacted_value")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedApiKeyListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiKeyListPageResponse),
                jacksonTypeRef<ApiKeyListPageResponse>(),
            )

        assertThat(roundtrippedApiKeyListPageResponse).isEqualTo(apiKeyListPageResponse)
    }
}
