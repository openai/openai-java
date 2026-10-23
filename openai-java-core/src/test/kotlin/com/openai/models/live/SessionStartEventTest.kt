// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionStartEventTest {

    @Test
    fun createAndRoundtrip() {
        val sessionStartEvent =
            SessionStartEvent.builder()
                .session(
                    SessionConfig.builder()
                        .model(SessionConfig.Model.GPT_LIVE_1)
                        .audio(
                            SessionConfig.Audio.builder()
                                .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                                .output(
                                    SessionConfig.Audio.Output.builder()
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
                        .addInput(
                            InitialItem.Developer.builder()
                                .addContent(
                                    InitialItem.Developer.Content.builder()
                                        .text("text")
                                        .type(InitialItem.Developer.Content.Type.INPUT_TEXT)
                                        .build()
                                )
                                .id("id")
                                .status(InitialItem.Developer.Status.INCOMPLETE)
                                .type(InitialItem.Developer.Type.MESSAGE)
                                .build()
                        )
                        .instructions(
                            "Help the caller plan a restaurant reservation. Confirm details before booking."
                        )
                        .store(true)
                        .addTrigger(
                            DecisionTrigger.builder()
                                .decisions(
                                    DecisionTrigger.Decisions.builder()
                                        .addQuestion(
                                            DecisionTrigger.Decisions.Question.Predicate.builder()
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
                .eventId("evt_start_001")
                .build()

        assertThat(sessionStartEvent.session())
            .isEqualTo(
                SessionConfig.builder()
                    .model(SessionConfig.Model.GPT_LIVE_1)
                    .audio(
                        SessionConfig.Audio.builder()
                            .audioPcmFormat(AudioFormat.AudioPcm.Rate._24000)
                            .output(
                                SessionConfig.Audio.Output.builder()
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
                    .addInput(
                        InitialItem.Developer.builder()
                            .addContent(
                                InitialItem.Developer.Content.builder()
                                    .text("text")
                                    .type(InitialItem.Developer.Content.Type.INPUT_TEXT)
                                    .build()
                            )
                            .id("id")
                            .status(InitialItem.Developer.Status.INCOMPLETE)
                            .type(InitialItem.Developer.Type.MESSAGE)
                            .build()
                    )
                    .instructions(
                        "Help the caller plan a restaurant reservation. Confirm details before booking."
                    )
                    .store(true)
                    .addTrigger(
                        DecisionTrigger.builder()
                            .decisions(
                                DecisionTrigger.Decisions.builder()
                                    .addQuestion(
                                        DecisionTrigger.Decisions.Question.Predicate.builder()
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
        assertThat(sessionStartEvent.eventId()).contains("evt_start_001")

        val jsonMapper = jsonMapper()

        val roundtrippedSessionStartEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionStartEvent),
                jacksonTypeRef<SessionStartEvent>(),
            )

        assertThat(roundtrippedSessionStartEvent).isEqualTo(sessionStartEvent)
    }
}
