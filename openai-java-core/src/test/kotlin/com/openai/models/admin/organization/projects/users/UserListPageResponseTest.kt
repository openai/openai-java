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
                        .email("email")
                        .name("name")
                        .role(ProjectUser.Role.OWNER)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .object_("object")
                .build()

        assertThat(userListPageResponse.data())
            .containsExactly(
                ProjectUser.builder()
                    .id("id")
                    .addedAt(0L)
                    .email("email")
                    .name("name")
                    .role(ProjectUser.Role.OWNER)
                    .build()
            )
        assertThat(userListPageResponse.firstId()).isEqualTo("first_id")
        assertThat(userListPageResponse.hasMore()).isEqualTo(true)
        assertThat(userListPageResponse.lastId()).isEqualTo("last_id")
        assertThat(userListPageResponse.object_()).isEqualTo("object")
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
                        .email("email")
                        .name("name")
                        .role(ProjectUser.Role.OWNER)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .object_("object")
                .build()

        val roundtrippedUserListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userListPageResponse),
                jacksonTypeRef<UserListPageResponse>(),
            )

        assertThat(roundtrippedUserListPageResponse).isEqualTo(userListPageResponse)
    }
}
