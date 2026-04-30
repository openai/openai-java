// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
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
                        .lastUsedAt(1711471534L)
                        .name("Administration Key")
                        .object_("organization.admin_api_key")
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
                )
                .firstId("key_abc")
                .hasMore(false)
                .lastId("key_xyz")
                .object_("list")
                .build()

        assertThat(adminApiKeyListPageResponse.data().getOrNull())
            .containsExactly(
                AdminApiKey.builder()
                    .id("key_abc")
                    .createdAt(1711471533L)
                    .lastUsedAt(1711471534L)
                    .name("Administration Key")
                    .object_("organization.admin_api_key")
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
            )
        assertThat(adminApiKeyListPageResponse.firstId()).contains("key_abc")
        assertThat(adminApiKeyListPageResponse.hasMore()).contains(false)
        assertThat(adminApiKeyListPageResponse.lastId()).contains("key_xyz")
        assertThat(adminApiKeyListPageResponse.object_()).contains("list")
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
                        .lastUsedAt(1711471534L)
                        .name("Administration Key")
                        .object_("organization.admin_api_key")
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
                )
                .firstId("key_abc")
                .hasMore(false)
                .lastId("key_xyz")
                .object_("list")
                .build()

        val roundtrippedAdminApiKeyListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(adminApiKeyListPageResponse),
                jacksonTypeRef<AdminApiKeyListPageResponse>(),
            )

        assertThat(roundtrippedAdminApiKeyListPageResponse).isEqualTo(adminApiKeyListPageResponse)
    }
}
