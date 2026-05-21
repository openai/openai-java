// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.groups.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleRetrieveResponseTest {

    @Test
    fun create() {
        val roleRetrieveResponse =
            RoleRetrieveResponse.builder()
                .id("id")
                .addAssignmentSource(
                    RoleRetrieveResponse.AssignmentSource.builder()
                        .principalId("principal_id")
                        .principalType("principal_type")
                        .build()
                )
                .createdAt(0L)
                .createdBy("created_by")
                .createdByUserObj(
                    RoleRetrieveResponse.CreatedByUserObj.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .metadata(
                    RoleRetrieveResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .name("name")
                .addPermission("string")
                .predefinedRole(true)
                .resourceType("resource_type")
                .updatedAt(0L)
                .build()

        assertThat(roleRetrieveResponse.id()).isEqualTo("id")
        assertThat(roleRetrieveResponse.assignmentSources().getOrNull())
            .containsExactly(
                RoleRetrieveResponse.AssignmentSource.builder()
                    .principalId("principal_id")
                    .principalType("principal_type")
                    .build()
            )
        assertThat(roleRetrieveResponse.createdAt()).contains(0L)
        assertThat(roleRetrieveResponse.createdBy()).contains("created_by")
        assertThat(roleRetrieveResponse.createdByUserObj())
            .contains(
                RoleRetrieveResponse.CreatedByUserObj.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(roleRetrieveResponse.description()).contains("description")
        assertThat(roleRetrieveResponse.metadata())
            .contains(
                RoleRetrieveResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(roleRetrieveResponse.name()).isEqualTo("name")
        assertThat(roleRetrieveResponse.permissions()).containsExactly("string")
        assertThat(roleRetrieveResponse.predefinedRole()).isEqualTo(true)
        assertThat(roleRetrieveResponse.resourceType()).isEqualTo("resource_type")
        assertThat(roleRetrieveResponse.updatedAt()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val roleRetrieveResponse =
            RoleRetrieveResponse.builder()
                .id("id")
                .addAssignmentSource(
                    RoleRetrieveResponse.AssignmentSource.builder()
                        .principalId("principal_id")
                        .principalType("principal_type")
                        .build()
                )
                .createdAt(0L)
                .createdBy("created_by")
                .createdByUserObj(
                    RoleRetrieveResponse.CreatedByUserObj.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .description("description")
                .metadata(
                    RoleRetrieveResponse.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .name("name")
                .addPermission("string")
                .predefinedRole(true)
                .resourceType("resource_type")
                .updatedAt(0L)
                .build()

        val roundtrippedRoleRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(roleRetrieveResponse),
                jacksonTypeRef<RoleRetrieveResponse>(),
            )

        assertThat(roundtrippedRoleRetrieveResponse).isEqualTo(roleRetrieveResponse)
    }
}
