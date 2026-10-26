// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.checkpoints.permissions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val permissionDeleteResponse =
            PermissionDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(permissionDeleteResponse.id()).isEqualTo("id")
        assertThat(permissionDeleteResponse.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedPermissionDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(permissionDeleteResponse),
                jacksonTypeRef<PermissionDeleteResponse>(),
            )

        assertThat(roundtrippedPermissionDeleteResponse).isEqualTo(permissionDeleteResponse)
    }
}
