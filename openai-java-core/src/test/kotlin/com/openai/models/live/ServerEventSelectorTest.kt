// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServerEventSelectorTest {

    @Test
    fun create() {
        val serverEventSelector =
            ServerEventSelector.builder().type("session.started").responseEvent("x").build()

        assertThat(serverEventSelector.type()).isEqualTo("session.started")
        assertThat(serverEventSelector.responseEvent()).contains("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val serverEventSelector =
            ServerEventSelector.builder().type("session.started").responseEvent("x").build()

        val roundtrippedServerEventSelector =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serverEventSelector),
                jacksonTypeRef<ServerEventSelector>(),
            )

        assertThat(roundtrippedServerEventSelector).isEqualTo(serverEventSelector)
    }
}
