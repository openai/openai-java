// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectListPageResponseTest {

    @Test
    fun create() {
        val projectListPageResponse =
            ProjectListPageResponse.builder()
                .addData(
                    Project.builder()
                        .id("id")
                        .createdAt(0L)
                        .archivedAt(0L)
                        .externalKeyId("external_key_id")
                        .name("name")
                        .status("status")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(projectListPageResponse.data())
            .containsExactly(
                Project.builder()
                    .id("id")
                    .createdAt(0L)
                    .archivedAt(0L)
                    .externalKeyId("external_key_id")
                    .name("name")
                    .status("status")
                    .build()
            )
        assertThat(projectListPageResponse.hasMore()).isEqualTo(true)
        assertThat(projectListPageResponse.firstId()).contains("first_id")
        assertThat(projectListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectListPageResponse =
            ProjectListPageResponse.builder()
                .addData(
                    Project.builder()
                        .id("id")
                        .createdAt(0L)
                        .archivedAt(0L)
                        .externalKeyId("external_key_id")
                        .name("name")
                        .status("status")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedProjectListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectListPageResponse),
                jacksonTypeRef<ProjectListPageResponse>(),
            )

        assertThat(roundtrippedProjectListPageResponse).isEqualTo(projectListPageResponse)
    }
}
