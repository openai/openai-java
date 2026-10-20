// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionConfigTest {

    @Test
    fun create() {
        val sessionConfig =
            SessionConfig.builder()
                .model(SessionConfig.Model.GPT_LIVE_1)
                .audio(
                    SessionConfig.Audio.builder()
                        .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
                        .output(
                            SessionConfig.Audio.Output.builder().voice(BuiltInVoice.ALLOY).build()
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
                .instructions("instructions")
                .store(true)
                .addTrigger(
                    DecisionTrigger.builder()
                        .decisions(
                            DecisionTrigger.Decisions.builder()
                                .addQuestion(
                                    DecisionTrigger.Decisions.Question.Predicate.builder()
                                        .instructions("instructions")
                                        .name("name")
                                        .build()
                                )
                                .build()
                        )
                        .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                        .build()
                )
                .build()

        assertThat(sessionConfig.model()).isEqualTo(SessionConfig.Model.GPT_LIVE_1)
        assertThat(sessionConfig.audio())
            .contains(
                SessionConfig.Audio.builder()
                    .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
                    .output(SessionConfig.Audio.Output.builder().voice(BuiltInVoice.ALLOY).build())
                    .build()
            )
        assertThat(sessionConfig.client())
            .contains(
                ClientConfig.builder()
                    .dataChannel(
                        DataChannelConfig.builder()
                            .allowedClientEventsOfStrings(listOf("string"))
                            .allowedServerEventsAll()
                            .build()
                    )
                    .build()
            )
        assertThat(sessionConfig.delegation())
            .contains(SessionConfig.Delegation.ofClient(ClientDelegation.builder().build()))
        assertThat(sessionConfig.input().getOrNull())
            .containsExactly(
                InitialItem.ofDeveloper(
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
            )
        assertThat(sessionConfig.instructions()).contains("instructions")
        assertThat(sessionConfig.store()).contains(true)
        assertThat(sessionConfig.triggers().getOrNull())
            .containsExactly(
                DecisionTrigger.builder()
                    .decisions(
                        DecisionTrigger.Decisions.builder()
                            .addQuestion(
                                DecisionTrigger.Decisions.Question.Predicate.builder()
                                    .instructions("instructions")
                                    .name("name")
                                    .build()
                            )
                            .build()
                    )
                    .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionConfig =
            SessionConfig.builder()
                .model(SessionConfig.Model.GPT_LIVE_1)
                .audio(
                    SessionConfig.Audio.builder()
                        .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
                        .output(
                            SessionConfig.Audio.Output.builder().voice(BuiltInVoice.ALLOY).build()
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
                .instructions("instructions")
                .store(true)
                .addTrigger(
                    DecisionTrigger.builder()
                        .decisions(
                            DecisionTrigger.Decisions.builder()
                                .addQuestion(
                                    DecisionTrigger.Decisions.Question.Predicate.builder()
                                        .instructions("instructions")
                                        .name("name")
                                        .build()
                                )
                                .build()
                        )
                        .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
                        .build()
                )
                .build()

        val roundtrippedSessionConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionConfig),
                jacksonTypeRef<SessionConfig>(),
            )

        assertThat(roundtrippedSessionConfig).isEqualTo(sessionConfig)
    }
}
