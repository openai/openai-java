// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionRetrieveResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        val jsonMapper = jsonMapper()

        val roundtrippedPermissionRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionRetrieveResponse),
                jacksonTypeRef<PermissionRetrieveResponse>(),
            )

        assertThat(roundtrippedPermissionRetrieveResponse).isEqualTo(permissionRetrieveResponse)
    }
}
