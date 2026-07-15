// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleDeleteResponseTest {

    @Test
    fun create() {
        val roleDeleteResponse =
            RoleDeleteResponse.builder().deleted(true).object_("object").build()

        assertThat(roleDeleteResponse.deleted()).isEqualTo(true)
        assertThat(roleDeleteResponse.object_()).isEqualTo("object")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val roleDeleteResponse =
            RoleDeleteResponse.builder().deleted(true).object_("object").build()

        val roundtrippedRoleDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(roleDeleteResponse),
                jacksonTypeRef<RoleDeleteResponse>(),
            )

        assertThat(roundtrippedRoleDeleteResponse).isEqualTo(roleDeleteResponse)
    }
}
