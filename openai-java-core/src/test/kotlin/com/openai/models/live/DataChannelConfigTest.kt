// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DataChannelConfigTest {

    @Test
    fun createAndRoundtrip() {
        val dataChannelConfig =
            DataChannelConfig.builder()
                .allowedClientEventsOfStrings(listOf("string"))
                .allowedServerEventsAll()
                .build()

        assertThat(dataChannelConfig.allowedClientEvents())
            .contains(DataChannelConfig.AllowedClientEvents.ofStrings(listOf("string")))
        assertThat(dataChannelConfig.allowedServerEvents())
            .contains(DataChannelConfig.AllowedServerEvents.ofAll())

        val jsonMapper = jsonMapper()

        val roundtrippedDataChannelConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dataChannelConfig),
                jacksonTypeRef<DataChannelConfig>(),
            )

        assertThat(roundtrippedDataChannelConfig).isEqualTo(dataChannelConfig)
    }
}
