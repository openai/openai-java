// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.live

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.models.live.BuiltInVoice
import com.openai.models.live.ClientConfig
import com.openai.models.live.ClientDelegation
import com.openai.models.live.DataChannelConfig
import com.openai.models.live.FunctionTool
import com.openai.models.live.InitialItem
import com.openai.models.live.MediaSessionForkConfig
import com.openai.models.live.ResponsesDelegationUpdateConfig
import com.openai.models.live.sessions.SessionAcceptParams
import com.openai.models.live.sessions.SessionForkParams
import com.openai.models.live.sessions.SessionReferParams
import com.openai.models.live.sessions.SessionRejectParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class SessionServiceAsyncTest {

    @Test
    fun accept() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.live().sessions()

        val future =
            sessionServiceAsync.accept(
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
            )

        val response = future.get()
    }

    @Test
    fun downloadRecording(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.live().sessions()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val responseFuture = sessionServiceAsync.downloadRecording("live_SQ")

        val response = responseFuture.get()
        assertThat(response.body()).hasContent("abc")
    }

    @Test
    fun fork() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.live().sessions()

        val responseFuture =
            sessionServiceAsync.fork(
                SessionForkParams.builder()
                    .sessionId("session_id")
                    .transport(SessionForkParams.Transport.builder().sdp("x").build())
                    .session(
                        MediaSessionForkConfig.builder()
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
                            .delegation(
                                MediaSessionForkConfig.Delegation.builder()
                                    .responses(
                                        ResponsesDelegationUpdateConfig.builder()
                                            .instructions("instructions")
                                            .maxOutputTokens(16L)
                                            .model("model")
                                            .parallelToolCalls(true)
                                            .reasoning(
                                                ResponsesDelegationUpdateConfig.Reasoning.builder()
                                                    .effort(
                                                        ResponsesDelegationUpdateConfig.Reasoning
                                                            .Effort
                                                            .NONE
                                                    )
                                                    .summary(
                                                        ResponsesDelegationUpdateConfig.Reasoning
                                                            .Summary
                                                            .CONCISE
                                                    )
                                                    .build()
                                            )
                                            .serviceTier(
                                                ResponsesDelegationUpdateConfig.ServiceTier.AUTO
                                            )
                                            .text(
                                                ResponsesDelegationUpdateConfig.Text.builder()
                                                    .verbosity(
                                                        ResponsesDelegationUpdateConfig.Text
                                                            .Verbosity
                                                            .LOW
                                                    )
                                                    .build()
                                            )
                                            .toolChoice(
                                                ResponsesDelegationUpdateConfig.ToolChoice
                                                    .LiveToolChoiceEnum
                                                    .AUTO
                                            )
                                            .addTool(
                                                FunctionTool.builder()
                                                    .name("name")
                                                    .description("description")
                                                    .parameters(
                                                        FunctionTool.Parameters.builder()
                                                            .putAdditionalProperty(
                                                                "foo",
                                                                JsonValue.from("bar"),
                                                            )
                                                            .build()
                                                    )
                                                    .strict(true)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .store(true)
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun hangup() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.live().sessions()

        val future = sessionServiceAsync.hangup("session_id")

        val response = future.get()
    }

    @Test
    fun refer() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.live().sessions()

        val future =
            sessionServiceAsync.refer(
                SessionReferParams.builder()
                    .sessionId("session_id")
                    .targetUri("tel:+14155550123")
                    .build()
            )

        val response = future.get()
    }

    @Test
    fun reject() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val sessionServiceAsync = client.live().sessions()

        val future =
            sessionServiceAsync.reject(
                SessionRejectParams.builder().sessionId("session_id").statusCode(486L).build()
            )

        val response = future.get()
    }
}
