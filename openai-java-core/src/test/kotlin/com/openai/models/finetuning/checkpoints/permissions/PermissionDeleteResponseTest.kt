// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionDeleteResponseTest {

    @Test
    fun create() {
        val permissionDeleteResponse =
            PermissionDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(permissionDeleteResponse.id()).isEqualTo("id")
        assertThat(permissionDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val permissionDeleteResponse =
            PermissionDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedPermissionDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionDeleteResponse),
                jacksonTypeRef<PermissionDeleteResponse>(),
            )

        assertThat(roundtrippedPermissionDeleteResponse).isEqualTo(permissionDeleteResponse)
    }
}
