// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminApiKeyTest {

    @Test
    fun create() {
        val adminApiKey =
            AdminApiKey.builder()
                .id("key_abc")
                .createdAt(1711471533L)
                .lastUsedAt(1711471534L)
                .name("Administration Key")
                .owner(
                    AdminApiKey.Owner.builder()
                        .id("sa_456")
                        .createdAt(1711471533L)
                        .name("My Service Account")
                        .object_("organization.user")
                        .role("owner")
                        .type("user")
                        .build()
                )
                .redactedValue("sk-admin...def")
                .value("sk-admin-1234abcd")
                .build()

        assertThat(adminApiKey.id()).isEqualTo("key_abc")
        assertThat(adminApiKey.createdAt()).isEqualTo(1711471533L)
        assertThat(adminApiKey.lastUsedAt()).contains(1711471534L)
        assertThat(adminApiKey.name()).isEqualTo("Administration Key")
        assertThat(adminApiKey.owner())
            .isEqualTo(
                AdminApiKey.Owner.builder()
                    .id("sa_456")
                    .createdAt(1711471533L)
                    .name("My Service Account")
                    .object_("organization.user")
                    .role("owner")
                    .type("user")
                    .build()
            )
        assertThat(adminApiKey.redactedValue()).isEqualTo("sk-admin...def")
        assertThat(adminApiKey.value()).contains("sk-admin-1234abcd")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val adminApiKey =
            AdminApiKey.builder()
                .id("key_abc")
                .createdAt(1711471533L)
                .lastUsedAt(1711471534L)
                .name("Administration Key")
                .owner(
                    AdminApiKey.Owner.builder()
                        .id("sa_456")
                        .createdAt(1711471533L)
                        .name("My Service Account")
                        .object_("organization.user")
                        .role("owner")
                        .type("user")
                        .build()
                )
                .redactedValue("sk-admin...def")
                .value("sk-admin-1234abcd")
                .build()

        val roundtrippedAdminApiKey =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(adminApiKey),
                jacksonTypeRef<AdminApiKey>(),
            )

        assertThat(roundtrippedAdminApiKey).isEqualTo(adminApiKey)
    }
}
