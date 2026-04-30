// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.users.OrganizationUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListPageResponseTest {

    @Test
    fun create() {
        val userListPageResponse =
            UserListPageResponse.builder()
                .addData(
                    OrganizationUser.builder()
                        .id("id")
                        .addedAt(0L)
                        .email("email")
                        .name("name")
                        .role(OrganizationUser.Role.OWNER)
                        .build()
                )
                .hasMore(true)
                .next("next")
                .build()

        assertThat(userListPageResponse.data())
            .containsExactly(
                OrganizationUser.builder()
                    .id("id")
                    .addedAt(0L)
                    .email("email")
                    .name("name")
                    .role(OrganizationUser.Role.OWNER)
                    .build()
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
                    OrganizationUser.builder()
                        .id("id")
                        .addedAt(0L)
                        .email("email")
                        .name("name")
                        .role(OrganizationUser.Role.OWNER)
                        .build()
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
