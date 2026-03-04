// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionListPageResponseTest {

    @Test
    fun create() {
        val permissionListPageResponse =
            PermissionListPageResponse.builder()
                .addData(
                    PermissionListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(permissionListPageResponse.data())
            .containsExactly(
                PermissionListResponse.builder()
                    .id("id")
                    .createdAt(0L)
                    .projectId("project_id")
                    .build()
            )
        assertThat(permissionListPageResponse.hasMore()).isEqualTo(true)
        assertThat(permissionListPageResponse.firstId()).contains("first_id")
        assertThat(permissionListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionListPageResponse =
            PermissionListPageResponse.builder()
                .addData(
                    PermissionListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedPermissionListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionListPageResponse),
                jacksonTypeRef<PermissionListPageResponse>(),
            )

        assertThat(roundtrippedPermissionListPageResponse).isEqualTo(permissionListPageResponse)
    }
}
