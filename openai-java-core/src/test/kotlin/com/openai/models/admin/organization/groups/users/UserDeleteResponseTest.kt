// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserDeleteResponseTest {

    @Test
    fun create() {
        val userDeleteResponse = UserDeleteResponse.builder().deleted(true).build()

        assertThat(userDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userDeleteResponse = UserDeleteResponse.builder().deleted(true).build()

        val roundtrippedUserDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userDeleteResponse),
                jacksonTypeRef<UserDeleteResponse>(),
            )

        assertThat(roundtrippedUserDeleteResponse).isEqualTo(userDeleteResponse)
    }
}
