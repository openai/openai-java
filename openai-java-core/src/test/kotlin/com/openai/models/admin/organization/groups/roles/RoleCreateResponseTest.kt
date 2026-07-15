// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.admin.organization.roles.Role
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleCreateResponseTest {

    @Test
    fun create() {
        val roleCreateResponse =
            RoleCreateResponse.builder()
                .group(
                    RoleCreateResponse.Group.builder()
                        .id("id")
                        .createdAt(0L)
                        .name("name")
                        .scimManaged(true)
                        .build()
                )
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
                .build()

        assertThat(roleCreateResponse.group())
            .isEqualTo(
                RoleCreateResponse.Group.builder()
                    .id("id")
                    .createdAt(0L)
                    .name("name")
                    .scimManaged(true)
                    .build()
            )
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val roleCreateResponse =
            RoleCreateResponse.builder()
                .group(
                    RoleCreateResponse.Group.builder()
                        .id("id")
                        .createdAt(0L)
                        .name("name")
                        .scimManaged(true)
                        .build()
                )
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
                .build()

        val roundtrippedRoleCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(roleCreateResponse),
                jacksonTypeRef<RoleCreateResponse>(),
            )

        assertThat(roundtrippedRoleCreateResponse).isEqualTo(roleCreateResponse)
    }
}
