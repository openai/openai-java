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
                .id("id")
                .createdAt(0L)
                .projectId("project_id")
                .build()

        assertThat(permissionRetrieveResponse.id()).isEqualTo("id")
        assertThat(permissionRetrieveResponse.createdAt()).isEqualTo(0L)
        assertThat(permissionRetrieveResponse.projectId()).isEqualTo("project_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionRetrieveResponse =
            PermissionRetrieveResponse.builder()
                .id("id")
                .createdAt(0L)
                .projectId("project_id")
                .build()

        val roundtrippedPermissionRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionRetrieveResponse),
                jacksonTypeRef<PermissionRetrieveResponse>(),
            )

        assertThat(roundtrippedPermissionRetrieveResponse).isEqualTo(permissionRetrieveResponse)
    }
}
