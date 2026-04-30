// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleDeleteResponseTest {

    @Test
    fun create() {
        val roleDeleteResponse = RoleDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(roleDeleteResponse.id()).isEqualTo("id")
        assertThat(roleDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val roleDeleteResponse = RoleDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedRoleDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(roleDeleteResponse),
                jacksonTypeRef<RoleDeleteResponse>(),
            )

        assertThat(roundtrippedRoleDeleteResponse).isEqualTo(roleDeleteResponse)
    }
}
