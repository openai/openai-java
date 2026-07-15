// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserCreateResponseTest {

    @Test
    fun create() {
        val userCreateResponse =
            UserCreateResponse.builder().groupId("group_id").userId("user_id").build()

        assertThat(userCreateResponse.groupId()).isEqualTo("group_id")
        assertThat(userCreateResponse.userId()).isEqualTo("user_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userCreateResponse =
            UserCreateResponse.builder().groupId("group_id").userId("user_id").build()

        val roundtrippedUserCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userCreateResponse),
                jacksonTypeRef<UserCreateResponse>(),
            )

        assertThat(roundtrippedUserCreateResponse).isEqualTo(userCreateResponse)
    }
}
