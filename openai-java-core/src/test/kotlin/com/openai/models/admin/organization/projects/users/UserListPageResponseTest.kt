// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
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

        assertThat(userListPageResponse.data().getOrNull())
            .containsExactly(
                ProjectUser.builder()
                    .id("id")
                    .addedAt(0L)
                    .role("role")
                    .email("email")
                    .name("name")
                    .build()
            )
        assertThat(userListPageResponse.hasMore()).contains(true)
        assertThat(userListPageResponse.object_()).contains("object")
        assertThat(userListPageResponse.firstId()).contains("first_id")
        assertThat(userListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedUserListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userListPageResponse),
                jacksonTypeRef<UserListPageResponse>(),
            )

        assertThat(roundtrippedUserListPageResponse).isEqualTo(userListPageResponse)
    }
}
