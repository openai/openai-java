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
                        .name("name")
                        .status(Project.Status.ACTIVE)
                        .archivedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(projectListPageResponse.data())
            .containsExactly(
                Project.builder()
                    .id("id")
                    .createdAt(0L)
                    .name("name")
                    .status(Project.Status.ACTIVE)
                    .archivedAt(0L)
                    .build()
            )
        assertThat(projectListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(projectListPageResponse.hasMore()).isEqualTo(true)
        assertThat(projectListPageResponse.lastId()).isEqualTo("last_id")
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
                        .name("name")
                        .status(Project.Status.ACTIVE)
                        .archivedAt(0L)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
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
