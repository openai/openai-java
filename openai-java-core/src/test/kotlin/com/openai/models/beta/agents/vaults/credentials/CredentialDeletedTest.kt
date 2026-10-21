// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CredentialDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val credentialDeleted = CredentialDeleted.builder().id("id").deleted(true).build()

        assertThat(credentialDeleted.id()).isEqualTo("id")
        assertThat(credentialDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedCredentialDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialDeleted),
                jacksonTypeRef<CredentialDeleted>(),
            )

        assertThat(roundtrippedCredentialDeleted).isEqualTo(credentialDeleted)
    }
}
