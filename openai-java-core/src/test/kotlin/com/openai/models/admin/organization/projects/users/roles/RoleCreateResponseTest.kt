// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.roles.Role
import com.openai.models.admin.organization.users.OrganizationUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleCreateResponseTest {

    @Test
    fun create() {
        val roleCreateResponse =
            RoleCreateResponse.builder()
                .role(
                    Role.builder()
                        .id("id")
                        .description("description")
                        .name("name")
                        .addPermission("string")
                        .predefinedRole(true)
                        .resourceType("resource_type")
                        .build()
                )
                .user(
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
                .build()

        assertThat(roleCreateResponse.role())
            .isEqualTo(
                Role.builder()
                    .id("id")
                    .description("description")
                    .name("name")
                    .addPermission("string")
                    .predefinedRole(true)
                    .resourceType("resource_type")
                    .build()
            )
        assertThat(roleCreateResponse.user())
            .isEqualTo(
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val roleCreateResponse =
            RoleCreateResponse.builder()
                .role(
                    Role.builder()
                        .id("id")
                        .description("description")
                        .name("name")
                        .addPermission("string")
                        .predefinedRole(true)
                        .resourceType("resource_type")
                        .build()
                )
                .user(
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
                .build()

        val roundtrippedRoleCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(roleCreateResponse),
                jacksonTypeRef<RoleCreateResponse>(),
            )

        assertThat(roundtrippedRoleCreateResponse).isEqualTo(roleCreateResponse)
    }
}
