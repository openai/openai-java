// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionResourceTest {

    @Test
    fun create() {
        val sessionResource =
            SessionResource.builder()
                .id("id")
                .expiresAt(0L)
                .model(SessionResource.Model.GPT_LIVE_1)
                .audio(
                    SessionResource.Audio.builder()
                        .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
                        .output(
                            SessionResource.Audio.Output.builder().voice(BuiltInVoice.ALLOY).build()
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
                .build()

        assertThat(sessionResource.id()).isEqualTo("id")
        assertThat(sessionResource.expiresAt()).isEqualTo(0L)
        assertThat(sessionResource.model()).isEqualTo(SessionResource.Model.GPT_LIVE_1)
        assertThat(sessionResource.audio())
            .contains(
                SessionResource.Audio.builder()
                    .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
                    .output(
                        SessionResource.Audio.Output.builder().voice(BuiltInVoice.ALLOY).build()
                    )
                    .build()
            )
        assertThat(sessionResource.client())
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
        assertThat(sessionResource.delegation())
            .contains(SessionResource.Delegation.ofClient(ClientDelegation.builder().build()))
        assertThat(sessionResource.input().getOrNull())
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
        assertThat(sessionResource.instructions()).contains("instructions")
        assertThat(sessionResource.store()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sessionResource =
            SessionResource.builder()
                .id("id")
                .expiresAt(0L)
                .model(SessionResource.Model.GPT_LIVE_1)
                .audio(
                    SessionResource.Audio.builder()
                        .audioPcmFormat(AudioFormat.AudioPcm.Rate._16000)
                        .output(
                            SessionResource.Audio.Output.builder().voice(BuiltInVoice.ALLOY).build()
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
                .build()

        val roundtrippedSessionResource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sessionResource),
                jacksonTypeRef<SessionResource>(),
            )

        assertThat(roundtrippedSessionResource).isEqualTo(sessionResource)
    }
}
