// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users

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
                    OrganizationUser.builder()
                        .id("id")
                        .addedAt(0L)
                        .email("email")
                        .name("name")
                        .role(OrganizationUser.Role.OWNER)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
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
        assertThat(userListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(userListPageResponse.hasMore()).isEqualTo(true)
        assertThat(userListPageResponse.lastId()).isEqualTo("last_id")
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
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedUserListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userListPageResponse),
                jacksonTypeRef<UserListPageResponse>(),
            )

        assertThat(roundtrippedUserListPageResponse).isEqualTo(userListPageResponse)
    }
}
