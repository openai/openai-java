// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users

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
                    ProjectUser.builder()
                        .id("id")
                        .addedAt(0L)
                        .role("role")
                        .email("email")
                        .name("name")
                        .build()
                )
                .hasMore(true)
                .object_("object")
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(userListPageResponse.data())
            .containsExactly(
                ProjectUser.builder()
                    .id("id")
                    .addedAt(0L)
                    .role("role")
                    .email("email")
                    .name("name")
                    .build()
            )
        assertThat(userListPageResponse.hasMore()).isEqualTo(true)
        assertThat(userListPageResponse.object_()).isEqualTo("object")
        assertThat(userListPageResponse.firstId()).contains("first_id")
        assertThat(userListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userListPageResponse =
            UserListPageResponse.builder()
                .addData(
                    ProjectUser.builder()
                        .id("id")
                        .addedAt(0L)
                        .role("role")
                        .email("email")
                        .name("name")
                        .build()
                )
                .hasMore(true)
                .object_("object")
                .firstId("first_id")
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
