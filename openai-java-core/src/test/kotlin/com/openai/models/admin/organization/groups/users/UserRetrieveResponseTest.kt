// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveResponseTest {

    @Test
    fun create() {
        val userRetrieveResponse =
            UserRetrieveResponse.builder()
                .id("id")
                .email("email")
                .isServiceAccount(true)
                .name("name")
                .picture("picture")
                .userType(UserRetrieveResponse.UserType.USER)
                .build()

        assertThat(userRetrieveResponse.id()).isEqualTo("id")
        assertThat(userRetrieveResponse.email()).contains("email")
        assertThat(userRetrieveResponse.isServiceAccount()).contains(true)
        assertThat(userRetrieveResponse.name()).isEqualTo("name")
        assertThat(userRetrieveResponse.picture()).contains("picture")
        assertThat(userRetrieveResponse.userType()).isEqualTo(UserRetrieveResponse.UserType.USER)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userRetrieveResponse =
            UserRetrieveResponse.builder()
                .id("id")
                .email("email")
                .isServiceAccount(true)
                .name("name")
                .picture("picture")
                .userType(UserRetrieveResponse.UserType.USER)
                .build()

        val roundtrippedUserRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveResponse),
                jacksonTypeRef<UserRetrieveResponse>(),
            )

        assertThat(roundtrippedUserRetrieveResponse).isEqualTo(userRetrieveResponse)
    }
}
