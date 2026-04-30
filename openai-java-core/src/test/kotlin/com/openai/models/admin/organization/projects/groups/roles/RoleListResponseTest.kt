// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.groups.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleListResponseTest {

    @Test
    fun create() {
        val roleListResponse =
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

        assertThat(roleListResponse.id()).isEqualTo("id")
        assertThat(roleListResponse.createdAt()).contains(0L)
        assertThat(roleListResponse.createdBy()).contains("created_by")
        assertThat(roleListResponse.createdByUserObj())
            .contains(
                RoleListResponse.CreatedByUserObj.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(roleListResponse.description()).contains("description")
        assertThat(roleListResponse.metadata())
            .contains(
                RoleListResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(roleListResponse.name()).isEqualTo("name")
        assertThat(roleListResponse.permissions()).containsExactly("string")
        assertThat(roleListResponse.predefinedRole()).isEqualTo(true)
        assertThat(roleListResponse.resourceType()).isEqualTo("resource_type")
        assertThat(roleListResponse.updatedAt()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val roleListResponse =
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

        val roundtrippedRoleListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(roleListResponse),
                jacksonTypeRef<RoleListResponse>(),
            )

        assertThat(roundtrippedRoleListResponse).isEqualTo(roleListResponse)
    }
}
