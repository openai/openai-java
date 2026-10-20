// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveCreateParamsTest {

    @Test
    fun create() {
        LiveCreateParams.builder()
            .session(
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
                    .build()
            )
            .transport(LiveCreateParams.Transport.builder().sdp("x").build())
            .build()
    }

    @Test
    fun body() {
        val params =
            LiveCreateParams.builder()
                .session(
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
                        .build()
                )
                .transport(LiveCreateParams.Transport.builder().sdp("x").build())
                .build()

        val body = params._body()

        assertThat(body.session())
            .isEqualTo(
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
                    .build()
            )
        assertThat(body.transport())
            .isEqualTo(LiveCreateParams.Transport.builder().sdp("x").build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            LiveCreateParams.builder()
                .session(
                    MediaSessionConfig.builder().model(MediaSessionConfig.Model.GPT_LIVE_1).build()
                )
                .transport(LiveCreateParams.Transport.builder().sdp("x").build())
                .build()

        val body = params._body()

        assertThat(body.session())
            .isEqualTo(
                MediaSessionConfig.builder().model(MediaSessionConfig.Model.GPT_LIVE_1).build()
            )
        assertThat(body.transport())
            .isEqualTo(LiveCreateParams.Transport.builder().sdp("x").build())
    }
}
