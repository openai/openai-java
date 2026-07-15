// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleTest {

    @Test
    fun create() {
        val role =
            Role.builder()
                .id("id")
                .description("description")
                .name("name")
                .addPermission("string")
                .predefinedRole(true)
                .resourceType("resource_type")
                .build()

        assertThat(role.id()).isEqualTo("id")
        assertThat(role.description()).contains("description")
        assertThat(role.name()).isEqualTo("name")
        assertThat(role.permissions()).containsExactly("string")
        assertThat(role.predefinedRole()).isEqualTo(true)
        assertThat(role.resourceType()).isEqualTo("resource_type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val role =
            Role.builder()
                .id("id")
                .description("description")
                .name("name")
                .addPermission("string")
                .predefinedRole(true)
                .resourceType("resource_type")
                .build()

        val roundtrippedRole =
            jsonMapper.readValue(jsonMapper.writeValueAsString(role), jacksonTypeRef<Role>())

        assertThat(roundtrippedRole).isEqualTo(role)
    }
}
