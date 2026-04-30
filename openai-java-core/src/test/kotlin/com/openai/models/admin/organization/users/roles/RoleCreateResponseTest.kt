// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users.roles

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
                        .email("email")
                        .name("name")
                        .role(OrganizationUser.Role.OWNER)
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
                    .email("email")
                    .name("name")
                    .role(OrganizationUser.Role.OWNER)
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
                        .email("email")
                        .name("name")
                        .role(OrganizationUser.Role.OWNER)
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
