// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VaultDeletedTest {

    @Test
    fun create() {
        val vaultDeleted = VaultDeleted.builder().id("id").deleted(true).build()

        assertThat(vaultDeleted.id()).isEqualTo("id")
        assertThat(vaultDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vaultDeleted = VaultDeleted.builder().id("id").deleted(true).build()

        val roundtrippedVaultDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vaultDeleted),
                jacksonTypeRef<VaultDeleted>(),
            )

        assertThat(roundtrippedVaultDeleted).isEqualTo(vaultDeleted)
    }
}
