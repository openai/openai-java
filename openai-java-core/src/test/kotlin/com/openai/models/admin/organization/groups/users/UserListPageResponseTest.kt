// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListPageResponseTest {

    @Test
    fun create() {
        val userListPageResponse =
            UserListPageResponse.builder()
                .addData(
                    OrganizationGroupUser.builder().id("id").email("email").name("name").build()
                )
                .hasMore(true)
                .next("next")
                .build()

        assertThat(userListPageResponse.data())
            .containsExactly(
                OrganizationGroupUser.builder().id("id").email("email").name("name").build()
            )
        assertThat(userListPageResponse.hasMore()).isEqualTo(true)
        assertThat(userListPageResponse.next()).contains("next")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userListPageResponse =
            UserListPageResponse.builder()
                .addData(
                    OrganizationGroupUser.builder().id("id").email("email").name("name").build()
                )
                .hasMore(true)
                .next("next")
                .build()

        val roundtrippedUserListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userListPageResponse),
                jacksonTypeRef<UserListPageResponse>(),
            )

        assertThat(roundtrippedUserListPageResponse).isEqualTo(userListPageResponse)
    }
}
