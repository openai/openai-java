// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionUpdateConfigTest {

    @Test
    fun create() {
        val sessionUpdateConfig =
            SessionUpdateConfig.builder().delegation(ClientDelegation.builder().build()).build()

        assertThat(sessionUpdateConfig.delegation())
            .contains(SessionUpdateConfig.Delegation.ofClient(ClientDelegation.builder().build()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionUpdateConfig =
            SessionUpdateConfig.builder().delegation(ClientDelegation.builder().build()).build()

        val roundtrippedSessionUpdateConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionUpdateConfig),
                jacksonTypeRef<SessionUpdateConfig>(),
            )

        assertThat(roundtrippedSessionUpdateConfig).isEqualTo(sessionUpdateConfig)
    }
}
