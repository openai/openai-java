// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceAccountListPageResponseTest {

    @Test
    fun create() {
        val serviceAccountListPageResponse =
            ServiceAccountListPageResponse.builder()
                .addData(
                    ProjectServiceAccount.builder()
                        .id("id")
                        .createdAt(0L)
                        .name("name")
                        .role(ProjectServiceAccount.Role.OWNER)
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(serviceAccountListPageResponse.data())
            .containsExactly(
                ProjectServiceAccount.builder()
                    .id("id")
                    .createdAt(0L)
                    .name("name")
                    .role(ProjectServiceAccount.Role.OWNER)
                    .build()
            )
        assertThat(serviceAccountListPageResponse.hasMore()).isEqualTo(true)
        assertThat(serviceAccountListPageResponse.firstId()).contains("first_id")
        assertThat(serviceAccountListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val serviceAccountListPageResponse =
            ServiceAccountListPageResponse.builder()
                .addData(
                    ProjectServiceAccount.builder()
                        .id("id")
                        .createdAt(0L)
                        .name("name")
                        .role(ProjectServiceAccount.Role.OWNER)
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedServiceAccountListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serviceAccountListPageResponse),
                jacksonTypeRef<ServiceAccountListPageResponse>(),
            )

        assertThat(roundtrippedServiceAccountListPageResponse)
            .isEqualTo(serviceAccountListPageResponse)
    }
}
