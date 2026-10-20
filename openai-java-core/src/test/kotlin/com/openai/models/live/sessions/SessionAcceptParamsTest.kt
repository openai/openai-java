// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live.sessions

import com.openai.models.live.BuiltInVoice
import com.openai.models.live.ClientDelegation
import com.openai.models.live.InitialItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SessionAcceptParamsTest {

    @Test
    fun create() {
        SessionAcceptParams.builder()
            .sessionId("session_id")
            .session(
                SessionAcceptParams.Session.builder()
                    .model(SessionAcceptParams.Session.Model.GPT_LIVE_1)
                    .audio(
                        SessionAcceptParams.Session.Audio.builder()
                            .output(
                                SessionAcceptParams.Session.Audio.Output.builder()
                                    .voice(BuiltInVoice.ALLOY)
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
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            SessionAcceptParams.builder()
                .sessionId("session_id")
                .session(
                    SessionAcceptParams.Session.builder()
                        .model(SessionAcceptParams.Session.Model.GPT_LIVE_1)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SessionAcceptParams.builder()
                .sessionId("session_id")
                .session(
                    SessionAcceptParams.Session.builder()
                        .model(SessionAcceptParams.Session.Model.GPT_LIVE_1)
                        .audio(
                            SessionAcceptParams.Session.Audio.builder()
                                .output(
                                    SessionAcceptParams.Session.Audio.Output.builder()
                                        .voice(BuiltInVoice.ALLOY)
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
                .build()

        val body = params._body()

        assertThat(body.session())
            .isEqualTo(
                SessionAcceptParams.Session.builder()
                    .model(SessionAcceptParams.Session.Model.GPT_LIVE_1)
                    .audio(
                        SessionAcceptParams.Session.Audio.builder()
                            .output(
                                SessionAcceptParams.Session.Audio.Output.builder()
                                    .voice(BuiltInVoice.ALLOY)
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SessionAcceptParams.builder()
                .sessionId("session_id")
                .session(
                    SessionAcceptParams.Session.builder()
                        .model(SessionAcceptParams.Session.Model.GPT_LIVE_1)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.session())
            .isEqualTo(
                SessionAcceptParams.Session.builder()
                    .model(SessionAcceptParams.Session.Model.GPT_LIVE_1)
                    .build()
            )
    }
}
