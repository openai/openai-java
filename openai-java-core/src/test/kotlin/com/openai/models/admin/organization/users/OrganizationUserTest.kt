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
                .apiKeyLastUsedAt(0L)
                .created(0L)
                .developerPersona("developer_persona")
                .email("email")
                .isDefault(true)
                .isScaleTierAuthorizedPurchaser(true)
                .isScimManaged(true)
                .isServiceAccount(true)
                .name("name")
                .projects(
                    OrganizationUser.Projects.builder()
                        .addData(
                            OrganizationUser.Projects.Data.builder()
                                .id("id")
                                .name("name")
                                .role("role")
                                .build()
                        )
                        .build()
                )
                .role("role")
                .technicalLevel("technical_level")
                .user(
                    OrganizationUser.User.builder()
                        .id("id")
                        .banned(true)
                        .bannedAt(0L)
                        .email("email")
                        .enabled(true)
                        .name("name")
                        .picture("picture")
                        .build()
                )
                .build()

        assertThat(organizationUser.id()).isEqualTo("id")
        assertThat(organizationUser.addedAt()).isEqualTo(0L)
        assertThat(organizationUser.apiKeyLastUsedAt()).contains(0L)
        assertThat(organizationUser.created()).contains(0L)
        assertThat(organizationUser.developerPersona()).contains("developer_persona")
        assertThat(organizationUser.email()).contains("email")
        assertThat(organizationUser.isDefault()).contains(true)
        assertThat(organizationUser.isScaleTierAuthorizedPurchaser()).contains(true)
        assertThat(organizationUser.isScimManaged()).contains(true)
        assertThat(organizationUser.isServiceAccount()).contains(true)
        assertThat(organizationUser.name()).contains("name")
        assertThat(organizationUser.projects())
            .contains(
                OrganizationUser.Projects.builder()
                    .addData(
                        OrganizationUser.Projects.Data.builder()
                            .id("id")
                            .name("name")
                            .role("role")
                            .build()
                    )
                    .build()
            )
        assertThat(organizationUser.role()).contains("role")
        assertThat(organizationUser.technicalLevel()).contains("technical_level")
        assertThat(organizationUser.user())
            .contains(
                OrganizationUser.User.builder()
                    .id("id")
                    .banned(true)
                    .bannedAt(0L)
                    .email("email")
                    .enabled(true)
                    .name("name")
                    .picture("picture")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationUser =
            OrganizationUser.builder()
                .id("id")
                .addedAt(0L)
                .apiKeyLastUsedAt(0L)
                .created(0L)
                .developerPersona("developer_persona")
                .email("email")
                .isDefault(true)
                .isScaleTierAuthorizedPurchaser(true)
                .isScimManaged(true)
                .isServiceAccount(true)
                .name("name")
                .projects(
                    OrganizationUser.Projects.builder()
                        .addData(
                            OrganizationUser.Projects.Data.builder()
                                .id("id")
                                .name("name")
                                .role("role")
                                .build()
                        )
                        .build()
                )
                .role("role")
                .technicalLevel("technical_level")
                .user(
                    OrganizationUser.User.builder()
                        .id("id")
                        .banned(true)
                        .bannedAt(0L)
                        .email("email")
                        .enabled(true)
                        .name("name")
                        .picture("picture")
                        .build()
                )
                .build()

        val roundtrippedOrganizationUser =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationUser),
                jacksonTypeRef<OrganizationUser>(),
            )

        assertThat(roundtrippedOrganizationUser).isEqualTo(organizationUser)
    }
}
