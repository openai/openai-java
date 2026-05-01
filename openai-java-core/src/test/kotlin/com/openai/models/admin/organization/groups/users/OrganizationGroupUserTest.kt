// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationGroupUserTest {

    @Test
    fun create() {
        val organizationGroupUser =
            OrganizationGroupUser.builder().id("id").email("email").name("name").build()

        assertThat(organizationGroupUser.id()).isEqualTo("id")
        assertThat(organizationGroupUser.email()).contains("email")
        assertThat(organizationGroupUser.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationGroupUser =
            OrganizationGroupUser.builder().id("id").email("email").name("name").build()

        val roundtrippedOrganizationGroupUser =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationGroupUser),
                jacksonTypeRef<OrganizationGroupUser>(),
            )

        assertThat(roundtrippedOrganizationGroupUser).isEqualTo(organizationGroupUser)
    }
}
