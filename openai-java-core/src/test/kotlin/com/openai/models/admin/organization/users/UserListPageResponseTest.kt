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
                        .apiKeyLastUsedAt(0L)
                        .created(0L)
                        .developerPersona("developer_persona")
                        .email("email")
                        .isDefault(true)
                        .isScaleTierAuthorizedPurchaser(true)
                        .isScimManaged(true)
                        .isServiceAccount(true)
                        .name("name")
                        .projects(
                            OrganizationUser.Projects.builder()
                                .addData(
                                    OrganizationUser.Projects.Data.builder()
                                        .id("id")
                                        .name("name")
                                        .role("role")
                                        .build()
                                )
                                .build()
                        )
                        .role("role")
                        .technicalLevel("technical_level")
                        .user(
                            OrganizationUser.User.builder()
                                .id("id")
                                .banned(true)
                                .bannedAt(0L)
                                .email("email")
                                .enabled(true)
                                .name("name")
                                .picture("picture")
                                .build()
                        )
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(userListPageResponse.data())
            .containsExactly(
                OrganizationUser.builder()
                    .id("id")
                    .addedAt(0L)
                    .apiKeyLastUsedAt(0L)
                    .created(0L)
                    .developerPersona("developer_persona")
                    .email("email")
                    .isDefault(true)
                    .isScaleTierAuthorizedPurchaser(true)
                    .isScimManaged(true)
                    .isServiceAccount(true)
                    .name("name")
                    .projects(
                        OrganizationUser.Projects.builder()
                            .addData(
                                OrganizationUser.Projects.Data.builder()
                                    .id("id")
                                    .name("name")
                                    .role("role")
                                    .build()
                            )
                            .build()
                    )
                    .role("role")
                    .technicalLevel("technical_level")
                    .user(
                        OrganizationUser.User.builder()
                            .id("id")
                            .banned(true)
                            .bannedAt(0L)
                            .email("email")
                            .enabled(true)
                            .name("name")
                            .picture("picture")
                            .build()
                    )
                    .build()
            )
        assertThat(userListPageResponse.hasMore()).isEqualTo(true)
        assertThat(userListPageResponse.firstId()).contains("first_id")
        assertThat(userListPageResponse.lastId()).contains("last_id")
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
                        .apiKeyLastUsedAt(0L)
                        .created(0L)
                        .developerPersona("developer_persona")
                        .email("email")
                        .isDefault(true)
                        .isScaleTierAuthorizedPurchaser(true)
                        .isScimManaged(true)
                        .isServiceAccount(true)
                        .name("name")
                        .projects(
                            OrganizationUser.Projects.builder()
                                .addData(
                                    OrganizationUser.Projects.Data.builder()
                                        .id("id")
                                        .name("name")
                                        .role("role")
                                        .build()
                                )
                                .build()
                        )
                        .role("role")
                        .technicalLevel("technical_level")
                        .user(
                            OrganizationUser.User.builder()
                                .id("id")
                                .banned(true)
                                .bannedAt(0L)
                                .email("email")
                                .enabled(true)
                                .name("name")
                                .picture("picture")
                                .build()
                        )
                        .build()
                )
                .hasMore(true)
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
