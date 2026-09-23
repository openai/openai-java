// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VaultListPageResponseTest {

    @Test
    fun create() {
        val vaultListPageResponse =
            VaultListPageResponse.builder()
                .addData(
                    Vault.builder()
                        .id("id")
                        .createdAt(0L)
                        .metadata(
                            Vault.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .name("name")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(vaultListPageResponse.data())
            .containsExactly(
                Vault.builder()
                    .id("id")
                    .createdAt(0L)
                    .metadata(
                        Vault.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .name("name")
                    .build()
            )
        assertThat(vaultListPageResponse.firstId()).contains("first_id")
        assertThat(vaultListPageResponse.hasMore()).isEqualTo(true)
        assertThat(vaultListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vaultListPageResponse =
            VaultListPageResponse.builder()
                .addData(
                    Vault.builder()
                        .id("id")
                        .createdAt(0L)
                        .metadata(
                            Vault.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .name("name")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedVaultListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vaultListPageResponse),
                jacksonTypeRef<VaultListPageResponse>(),
            )

        assertThat(roundtrippedVaultListPageResponse).isEqualTo(vaultListPageResponse)
    }
}
