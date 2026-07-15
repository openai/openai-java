// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleListPageResponseTest {

    @Test
    fun create() {
        val roleListPageResponse =
            RoleListPageResponse.builder()
                .addData(
                    Role.builder()
                        .id("id")
                        .description("description")
                        .name("name")
                        .addPermission("string")
                        .predefinedRole(true)
                        .resourceType("resource_type")
                        .build()
                )
                .hasMore(true)
                .next("next")
                .build()

        assertThat(roleListPageResponse.data())
            .containsExactly(
                Role.builder()
                    .id("id")
                    .description("description")
                    .name("name")
                    .addPermission("string")
                    .predefinedRole(true)
                    .resourceType("resource_type")
                    .build()
            )
        assertThat(roleListPageResponse.hasMore()).isEqualTo(true)
        assertThat(roleListPageResponse.next()).contains("next")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val roleListPageResponse =
            RoleListPageResponse.builder()
                .addData(
                    Role.builder()
                        .id("id")
                        .description("description")
                        .name("name")
                        .addPermission("string")
                        .predefinedRole(true)
                        .resourceType("resource_type")
                        .build()
                )
                .hasMore(true)
                .next("next")
                .build()

        val roundtrippedRoleListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(roleListPageResponse),
                jacksonTypeRef<RoleListPageResponse>(),
            )

        assertThat(roundtrippedRoleListPageResponse).isEqualTo(roleListPageResponse)
    }
}
