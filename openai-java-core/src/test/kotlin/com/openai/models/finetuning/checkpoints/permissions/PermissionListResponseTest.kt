// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionListResponseTest {

    @Test
    fun create() {
        val permissionListResponse =
            PermissionListResponse.builder().id("id").createdAt(0L).projectId("project_id").build()

        assertThat(permissionListResponse.id()).isEqualTo("id")
        assertThat(permissionListResponse.createdAt()).isEqualTo(0L)
        assertThat(permissionListResponse.projectId()).isEqualTo("project_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionListResponse =
            PermissionListResponse.builder().id("id").createdAt(0L).projectId("project_id").build()

        val roundtrippedPermissionListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionListResponse),
                jacksonTypeRef<PermissionListResponse>(),
            )

        assertThat(roundtrippedPermissionListResponse).isEqualTo(permissionListResponse)
    }
}
