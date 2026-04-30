// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationUserTest {

    @Test
    fun create() {
        val organizationUser =
            OrganizationUser.builder()
                .id("id")
                .addedAt(0L)
                .email("email")
                .name("name")
                .role(OrganizationUser.Role.OWNER)
                .build()

        assertThat(organizationUser.id()).isEqualTo("id")
        assertThat(organizationUser.addedAt()).isEqualTo(0L)
        assertThat(organizationUser.email()).isEqualTo("email")
        assertThat(organizationUser.name()).isEqualTo("name")
        assertThat(organizationUser.role()).isEqualTo(OrganizationUser.Role.OWNER)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationUser =
            OrganizationUser.builder()
                .id("id")
                .addedAt(0L)
                .email("email")
                .name("name")
                .role(OrganizationUser.Role.OWNER)
                .build()

        val roundtrippedOrganizationUser =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationUser),
                jacksonTypeRef<OrganizationUser>(),
            )

        assertThat(roundtrippedOrganizationUser).isEqualTo(organizationUser)
    }
}
