// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionCreatePageResponseTest {

    @Test
    fun create() {
        val permissionCreatePageResponse =
            PermissionCreatePageResponse.builder()
                .addData(
                    PermissionCreateResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(permissionCreatePageResponse.data())
            .containsExactly(
                PermissionCreateResponse.builder()
                    .id("id")
                    .createdAt(0L)
                    .projectId("project_id")
                    .build()
            )
        assertThat(permissionCreatePageResponse.hasMore()).isEqualTo(true)
        assertThat(permissionCreatePageResponse.firstId()).contains("first_id")
        assertThat(permissionCreatePageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionCreatePageResponse =
            PermissionCreatePageResponse.builder()
                .addData(
                    PermissionCreateResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedPermissionCreatePageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionCreatePageResponse),
                jacksonTypeRef<PermissionCreatePageResponse>(),
            )

        assertThat(roundtrippedPermissionCreatePageResponse).isEqualTo(permissionCreatePageResponse)
    }
}
