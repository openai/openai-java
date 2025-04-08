// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionRetrieveResponseTest {

    @Test
    fun create() {
        val permissionRetrieveResponse =
            PermissionRetrieveResponse.builder()
                .addData(
                    PermissionRetrieveResponse.Data.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(permissionRetrieveResponse.data())
            .containsExactly(
                PermissionRetrieveResponse.Data.builder()
                    .id("id")
                    .createdAt(0L)
                    .projectId("project_id")
                    .build()
            )
        assertThat(permissionRetrieveResponse.hasMore()).isEqualTo(true)
        assertThat(permissionRetrieveResponse.firstId()).contains("first_id")
        assertThat(permissionRetrieveResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionRetrieveResponse =
            PermissionRetrieveResponse.builder()
                .addData(
                    PermissionRetrieveResponse.Data.builder()
                        .id("id")
                        .createdAt(0L)
                        .projectId("project_id")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        val roundtrippedPermissionRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionRetrieveResponse),
                jacksonTypeRef<PermissionRetrieveResponse>(),
            )

        assertThat(roundtrippedPermissionRetrieveResponse).isEqualTo(permissionRetrieveResponse)
    }
}
