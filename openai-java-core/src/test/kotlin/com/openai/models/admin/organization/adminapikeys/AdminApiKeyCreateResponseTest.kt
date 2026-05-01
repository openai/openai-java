// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminApiKeyCreateResponseTest {

    @Test
    fun create() {
        val adminApiKeyCreateResponse =
            AdminApiKeyCreateResponse.builder()
                .id("key_abc")
                .createdAt(1711471533L)
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
                .lastUsedAt(1711471534L)
                .name("Administration Key")
                .value("sk-admin-1234abcd")
                .build()

        assertThat(adminApiKeyCreateResponse.id()).isEqualTo("key_abc")
        assertThat(adminApiKeyCreateResponse.createdAt()).isEqualTo(1711471533L)
        assertThat(adminApiKeyCreateResponse.owner())
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
        assertThat(adminApiKeyCreateResponse.redactedValue()).isEqualTo("sk-admin...def")
        assertThat(adminApiKeyCreateResponse.lastUsedAt()).contains(1711471534L)
        assertThat(adminApiKeyCreateResponse.name()).contains("Administration Key")
        assertThat(adminApiKeyCreateResponse.value()).isEqualTo("sk-admin-1234abcd")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val adminApiKeyCreateResponse =
            AdminApiKeyCreateResponse.builder()
                .id("key_abc")
                .createdAt(1711471533L)
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
                .lastUsedAt(1711471534L)
                .name("Administration Key")
                .value("sk-admin-1234abcd")
                .build()

        val roundtrippedAdminApiKeyCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(adminApiKeyCreateResponse),
                jacksonTypeRef<AdminApiKeyCreateResponse>(),
            )

        assertThat(roundtrippedAdminApiKeyCreateResponse).isEqualTo(adminApiKeyCreateResponse)
    }
}
