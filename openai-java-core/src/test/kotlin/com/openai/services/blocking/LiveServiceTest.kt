// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.live.BuiltInVoice
import com.openai.models.live.ClientConfig
import com.openai.models.live.ClientDelegation
import com.openai.models.live.DataChannelConfig
import com.openai.models.live.InitialItem
import com.openai.models.live.LiveCreateParams
import com.openai.models.live.MediaSessionConfig
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class LiveServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val liveService = client.live()

        val live =
            liveService.create(
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
            )

        live.validate()
    }
}
