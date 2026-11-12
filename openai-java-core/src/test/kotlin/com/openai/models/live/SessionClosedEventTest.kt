// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.decisions.DecisionChoiceOption
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionClosedEventTest {

    @Test
    fun createAndRoundtrip() {
        val sessionClosedEvent =
            SessionClosedEvent.builder()
                .eventId("evt_closed_001")
                .reason(SessionClosedEvent.Reason.CLOSE_REQUESTED)
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
                        .delegation(ClientDelegation.builder().acknowledgementDelayMs(0L).build())
                        .input(listOf())
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .addTrigger(
                            DecisionTrigger.builder()
                                .decisions(
                                    DecisionTrigger.Decisions.builder()
                                        .addQuestion(
                                            DecisionQuestion.Choice.builder()
                                                .addChoice(
                                                    DecisionChoiceOption.builder()
                                                        .value("string")
                                                        .description("description")
                                                        .build()
                                                )
                                                .instructions("string")
                                                .name("name")
                                                .build()
                                        )
                                        .build()
                                )
                                .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                                .build()
                        )
                        .build()
                )
                .usage(SessionUsage.builder().seconds(45.8).build())
                .clientEventId("evt_close_001")
                .build()

        assertThat(sessionClosedEvent.eventId()).contains("evt_closed_001")
        assertThat(sessionClosedEvent.reason()).contains(SessionClosedEvent.Reason.CLOSE_REQUESTED)
        assertThat(sessionClosedEvent.session())
            .contains(
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
                    .delegation(ClientDelegation.builder().acknowledgementDelayMs(0L).build())
                    .input(listOf())
                    .instructions(
                        "Help the caller plan a restaurant reservation. Confirm details before booking."
                    )
                    .store(true)
                    .addTrigger(
                        DecisionTrigger.builder()
                            .decisions(
                                DecisionTrigger.Decisions.builder()
                                    .addQuestion(
                                        DecisionQuestion.Choice.builder()
                                            .addChoice(
                                                DecisionChoiceOption.builder()
                                                    .value("string")
                                                    .description("description")
                                                    .build()
                                            )
                                            .instructions("string")
                                            .name("name")
                                            .build()
                                    )
                                    .build()
                            )
                            .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                            .build()
                    )
                    .build()
            )
        assertThat(sessionClosedEvent.usage())
            .contains(SessionUsage.builder().seconds(45.8).build())
        assertThat(sessionClosedEvent.clientEventId()).contains("evt_close_001")

        val jsonMapper = jsonMapper()

        val roundtrippedSessionClosedEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionClosedEvent),
                jacksonTypeRef<SessionClosedEvent>(),
            )

        assertThat(roundtrippedSessionClosedEvent).isEqualTo(sessionClosedEvent)
    }
}
