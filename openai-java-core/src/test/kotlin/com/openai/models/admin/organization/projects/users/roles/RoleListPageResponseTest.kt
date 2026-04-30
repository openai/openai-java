// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleListPageResponseTest {

    @Test
    fun create() {
        val roleListPageResponse =
            RoleListPageResponse.builder()
                .addData(
                    RoleListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .createdBy("created_by")
                        .createdByUserObj(
                            RoleListResponse.CreatedByUserObj.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .metadata(
                            RoleListResponse.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .name("name")
                        .addPermission("string")
                        .predefinedRole(true)
                        .resourceType("resource_type")
                        .updatedAt(0L)
                        .build()
                )
                .hasMore(true)
                .next("next")
                .build()

        assertThat(roleListPageResponse.data())
            .containsExactly(
                RoleListResponse.builder()
                    .id("id")
                    .createdAt(0L)
                    .createdBy("created_by")
                    .createdByUserObj(
                        RoleListResponse.CreatedByUserObj.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .description("description")
                    .metadata(
                        RoleListResponse.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .name("name")
                    .addPermission("string")
                    .predefinedRole(true)
                    .resourceType("resource_type")
                    .updatedAt(0L)
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
                    RoleListResponse.builder()
                        .id("id")
                        .createdAt(0L)
                        .createdBy("created_by")
                        .createdByUserObj(
                            RoleListResponse.CreatedByUserObj.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .description("description")
                        .metadata(
                            RoleListResponse.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .name("name")
                        .addPermission("string")
                        .predefinedRole(true)
                        .resourceType("resource_type")
                        .updatedAt(0L)
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
