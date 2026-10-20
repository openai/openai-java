// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClientDelegationTest {

    @Test
    fun create() {
        val clientDelegation = ClientDelegation.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val clientDelegation = ClientDelegation.builder().build()

        val roundtrippedClientDelegation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientDelegation),
                jacksonTypeRef<ClientDelegation>(),
            )

        assertThat(roundtrippedClientDelegation).isEqualTo(clientDelegation)
    }
}
