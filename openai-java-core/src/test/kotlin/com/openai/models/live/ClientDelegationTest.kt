// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClientDelegationTest {

    @Test
    fun createAndRoundtrip() {
        val clientDelegation = ClientDelegation.builder().acknowledgementDelayMs(0L).build()

        assertThat(clientDelegation.acknowledgementDelayMs()).contains(0L)

        val jsonMapper = jsonMapper()

        val roundtrippedClientDelegation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientDelegation),
                jacksonTypeRef<ClientDelegation>(),
            )

        assertThat(roundtrippedClientDelegation).isEqualTo(clientDelegation)
    }
}
