// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MediaSessionConfigTest {

    @Test
    fun create() {
        val mediaSessionConfig =
            MediaSessionConfig.builder()
                .model(MediaSessionConfig.Model.GPT_LIVE_1)
                .audio(
                    MediaSessionConfig.Audio.builder()
                        .output(
                            MediaSessionConfig.Audio.Output.builder()
                                .voice(BuiltInVoice.ALLOY)
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

        assertThat(mediaSessionConfig.model()).isEqualTo(MediaSessionConfig.Model.GPT_LIVE_1)
        assertThat(mediaSessionConfig.audio())
            .contains(
                MediaSessionConfig.Audio.builder()
                    .output(
                        MediaSessionConfig.Audio.Output.builder().voice(BuiltInVoice.ALLOY).build()
                    )
                    .build()
            )
        assertThat(mediaSessionConfig.client())
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
        assertThat(mediaSessionConfig.delegation())
            .contains(MediaSessionConfig.Delegation.ofClient(ClientDelegation.builder().build()))
        assertThat(mediaSessionConfig.input().getOrNull())
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
        assertThat(mediaSessionConfig.instructions()).contains("instructions")
        assertThat(mediaSessionConfig.store()).contains(true)
        assertThat(mediaSessionConfig.triggers().getOrNull())
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
        val mediaSessionConfig =
            MediaSessionConfig.builder()
                .model(MediaSessionConfig.Model.GPT_LIVE_1)
                .audio(
                    MediaSessionConfig.Audio.builder()
                        .output(
                            MediaSessionConfig.Audio.Output.builder()
                                .voice(BuiltInVoice.ALLOY)
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

        val roundtrippedMediaSessionConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mediaSessionConfig),
                jacksonTypeRef<MediaSessionConfig>(),
            )

        assertThat(roundtrippedMediaSessionConfig).isEqualTo(mediaSessionConfig)
    }
}
