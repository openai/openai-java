// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VaultTest {

    @Test
    fun create() {
        val vault =
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

        assertThat(vault.id()).isEqualTo("id")
        assertThat(vault.createdAt()).isEqualTo(0L)
        assertThat(vault.metadata())
            .isEqualTo(
                Vault.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(vault.name()).contains("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vault =
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

        val roundtrippedVault =
            jsonMapper.readValue(jsonMapper.writeValueAsString(vault), jacksonTypeRef<Vault>())

        assertThat(roundtrippedVault).isEqualTo(vault)
    }
}
