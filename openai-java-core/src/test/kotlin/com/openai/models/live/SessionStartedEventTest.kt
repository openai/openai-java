// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionStartedEventTest {

    @Test
    fun create() {
        val sessionStartedEvent =
            SessionStartedEvent.builder()
                .eventId("evt_started_001")
                .session(
                    SessionResource.builder()
                        .id("live_abc123")
                        .expiresAt(1788555600L)
                        .model(SessionResource.Model.GPT_LIVE_1)
                        .audio(
                            SessionResource.Audio.builder()
                                .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                .output(
                                    SessionResource.Audio.Output.builder()
                                        .voice(BuiltInVoice.MARIN)
                                        .build()
                                )
                                .build()
                        )
                        .client(
                            ClientConfig.builder()
                                .dataChannel(
                                    DataChannelConfig.builder()
                                        .allowedClientEventsOfStrings(listOf("string"))
                                        .allowedServerEventsAll()
                                        .build()
                                )
                                .build()
                        )
                        .delegation(ClientDelegation.builder().build())
                        .input(listOf())
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .build()
                )
                .clientEventId("evt_start_001")
                .build()

        assertThat(sessionStartedEvent.eventId()).isEqualTo("evt_started_001")
        assertThat(sessionStartedEvent.session())
            .isEqualTo(
                SessionResource.builder()
                    .id("live_abc123")
                    .expiresAt(1788555600L)
                    .model(SessionResource.Model.GPT_LIVE_1)
                    .audio(
                        SessionResource.Audio.builder()
                            .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                            .output(
                                SessionResource.Audio.Output.builder()
                                    .voice(BuiltInVoice.MARIN)
                                    .build()
                            )
                            .build()
                    )
                    .client(
                        ClientConfig.builder()
                            .dataChannel(
                                DataChannelConfig.builder()
                                    .allowedClientEventsOfStrings(listOf("string"))
                                    .allowedServerEventsAll()
                                    .build()
                            )
                            .build()
                    )
                    .delegation(ClientDelegation.builder().build())
                    .input(listOf())
                    .instructions(
                        "Help the caller plan a restaurant reservation. Confirm details before booking."
                    )
                    .store(true)
                    .build()
            )
        assertThat(sessionStartedEvent.clientEventId()).contains("evt_start_001")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionStartedEvent =
            SessionStartedEvent.builder()
                .eventId("evt_started_001")
                .session(
                    SessionResource.builder()
                        .id("live_abc123")
                        .expiresAt(1788555600L)
                        .model(SessionResource.Model.GPT_LIVE_1)
                        .audio(
                            SessionResource.Audio.builder()
                                .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                .output(
                                    SessionResource.Audio.Output.builder()
                                        .voice(BuiltInVoice.MARIN)
                                        .build()
                                )
                                .build()
                        )
                        .client(
                            ClientConfig.builder()
                                .dataChannel(
                                    DataChannelConfig.builder()
                                        .allowedClientEventsOfStrings(listOf("string"))
                                        .allowedServerEventsAll()
                                        .build()
                                )
                                .build()
                        )
                        .delegation(ClientDelegation.builder().build())
                        .input(listOf())
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .build()
                )
                .clientEventId("evt_start_001")
                .build()

        val roundtrippedSessionStartedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionStartedEvent),
                jacksonTypeRef<SessionStartedEvent>(),
            )

        assertThat(roundtrippedSessionStartedEvent).isEqualTo(sessionStartedEvent)
    }
}
