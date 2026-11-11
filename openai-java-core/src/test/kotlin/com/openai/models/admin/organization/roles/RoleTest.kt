// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.roles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleTest {

    @Test
    fun createAndRoundtrip() {
        val role =
            Role.builder()
                .id("id")
                .description("description")
                .name("name")
                .addPermission("string")
                .predefinedRole(true)
                .resourceType("resource_type")
                .build()

        assertThat(role.id()).contains("id")
        assertThat(role.description()).contains("description")
        assertThat(role.name()).contains("name")
        assertThat(role.permissions().getOrNull()).containsExactly("string")
        assertThat(role.predefinedRole()).contains(true)
        assertThat(role.resourceType()).contains("resource_type")

        val jsonMapper = jsonMapper()

        val roundtrippedRole =
            jsonMapper.readValue(jsonMapper.writeValueAsString(role), jacksonTypeRef<Role>())

        assertThat(roundtrippedRole).isEqualTo(role)
    }
}
