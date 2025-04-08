// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionCreateResponseTest {

    @Test
    fun create() {
        val permissionCreateResponse =
            PermissionCreateResponse.builder()
                .id("id")
                .createdAt(0L)
                .projectId("project_id")
                .build()

        assertThat(permissionCreateResponse.id()).isEqualTo("id")
        assertThat(permissionCreateResponse.createdAt()).isEqualTo(0L)
        assertThat(permissionCreateResponse.projectId()).isEqualTo("project_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionCreateResponse =
            PermissionCreateResponse.builder()
                .id("id")
                .createdAt(0L)
                .projectId("project_id")
                .build()

        val roundtrippedPermissionCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionCreateResponse),
                jacksonTypeRef<PermissionCreateResponse>(),
            )

        assertThat(roundtrippedPermissionCreateResponse).isEqualTo(permissionCreateResponse)
    }
}
