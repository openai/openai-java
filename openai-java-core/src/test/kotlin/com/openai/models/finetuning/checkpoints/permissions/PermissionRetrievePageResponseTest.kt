// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionRetrievePageResponseTest {

    @Test
    fun create() {
        val permissionRetrievePageResponse =
            PermissionRetrievePageResponse.builder()
                .addData(
                    PermissionRetrieveResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(permissionRetrievePageResponse.data())
            .containsExactly(
                PermissionRetrieveResponse.builder()
                    .id("id")
                    .createdAt(0L)
                    .projectId("project_id")
                    .build()
            )
        assertThat(permissionRetrievePageResponse.hasMore()).isEqualTo(true)
        assertThat(permissionRetrievePageResponse.firstId()).contains("first_id")
        assertThat(permissionRetrievePageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionRetrievePageResponse =
            PermissionRetrievePageResponse.builder()
                .addData(
                    PermissionRetrieveResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedPermissionRetrievePageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionRetrievePageResponse),
                jacksonTypeRef<PermissionRetrievePageResponse>(),
            )

        assertThat(roundtrippedPermissionRetrievePageResponse)
            .isEqualTo(permissionRetrievePageResponse)
    }
}
