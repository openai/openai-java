// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClientConfigTest {

    @Test
    fun create() {
        val clientConfig =
            ClientConfig.builder()
                .dataChannel(
                    DataChannelConfig.builder()
                        .allowedClientEventsOfStrings(listOf("string"))
                        .allowedServerEventsAll()
                        .build()
                )
                .build()

        assertThat(clientConfig.dataChannel())
            .isEqualTo(
                DataChannelConfig.builder()
                    .allowedClientEventsOfStrings(listOf("string"))
                    .allowedServerEventsAll()
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val clientConfig =
            ClientConfig.builder()
                .dataChannel(
                    DataChannelConfig.builder()
                        .allowedClientEventsOfStrings(listOf("string"))
                        .allowedServerEventsAll()
                        .build()
                )
                .build()

        val roundtrippedClientConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientConfig),
                jacksonTypeRef<ClientConfig>(),
            )

        assertThat(roundtrippedClientConfig).isEqualTo(clientConfig)
    }
}
