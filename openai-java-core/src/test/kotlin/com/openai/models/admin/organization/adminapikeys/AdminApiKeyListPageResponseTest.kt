// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AdminApiKeyListPageResponseTest {

    @Test
    fun create() {
        val adminApiKeyListPageResponse =
            AdminApiKeyListPageResponse.builder()
                .addData(
                    AdminApiKey.builder()
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
                        .build()
                )
                .hasMore(false)
                .firstId("key_abc")
                .lastId("key_xyz")
                .build()

        assertThat(adminApiKeyListPageResponse.data())
            .containsExactly(
                AdminApiKey.builder()
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
                    .build()
            )
        assertThat(adminApiKeyListPageResponse.hasMore()).isEqualTo(false)
        assertThat(adminApiKeyListPageResponse.firstId()).contains("key_abc")
        assertThat(adminApiKeyListPageResponse.lastId()).contains("key_xyz")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val adminApiKeyListPageResponse =
            AdminApiKeyListPageResponse.builder()
                .addData(
                    AdminApiKey.builder()
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
                        .build()
                )
                .hasMore(false)
                .firstId("key_abc")
                .lastId("key_xyz")
                .build()

        val roundtrippedAdminApiKeyListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(adminApiKeyListPageResponse),
                jacksonTypeRef<AdminApiKeyListPageResponse>(),
            )

        assertThat(roundtrippedAdminApiKeyListPageResponse).isEqualTo(adminApiKeyListPageResponse)
    }
}
