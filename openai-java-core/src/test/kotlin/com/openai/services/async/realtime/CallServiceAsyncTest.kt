// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.realtime

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.realtime.AudioTranscription
import com.openai.models.realtime.NoiseReductionType
import com.openai.models.realtime.RealtimeAudioConfig
import com.openai.models.realtime.RealtimeAudioConfigInput
import com.openai.models.realtime.RealtimeAudioConfigOutput
import com.openai.models.realtime.RealtimeAudioFormats
import com.openai.models.realtime.RealtimeAudioInputTurnDetection
import com.openai.models.realtime.RealtimeFunctionTool
import com.openai.models.realtime.RealtimeReasoning
import com.openai.models.realtime.RealtimeReasoningEffort
import com.openai.models.realtime.RealtimeSessionCreateRequest
import com.openai.models.realtime.RealtimeTruncation
import com.openai.models.realtime.calls.CallAcceptParams
import com.openai.models.realtime.calls.CallCreateParams
import com.openai.models.realtime.calls.CallReferParams
import com.openai.models.realtime.calls.CallRejectParams
import com.openai.models.responses.ResponsePrompt
import com.openai.models.responses.ToolChoiceOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class CallServiceAsyncTest {

    @Test
    fun create(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Work around Steady's JSON multipart decoding limitations with a local wire-contract mock.
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            val callServiceAsync = client.realtime().calls()
            val params =
                CallCreateParams.builder()
                    .sdp("sdp")
                    .session(
                        RealtimeSessionCreateRequest.builder()
                            .audio(
                                RealtimeAudioConfig.builder()
                                    .input(
                                        RealtimeAudioConfigInput.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .noiseReduction(
                                                RealtimeAudioConfigInput.NoiseReduction.builder()
                                                    .type(NoiseReductionType.NEAR_FIELD)
                                                    .build()
                                            )
                                            .transcription(
                                                AudioTranscription.builder()
                                                    .delay(AudioTranscription.Delay.MINIMAL)
                                                    .addKeyword("string")
                                                    .language("language")
                                                    .addLanguage("string")
                                                    .model(AudioTranscription.Model.WHISPER_1)
                                                    .prompt("prompt")
                                                    .build()
                                            )
                                            .turnDetection(
                                                RealtimeAudioInputTurnDetection.ServerVad.builder()
                                                    .createResponse(true)
                                                    .idleTimeoutMs(5000L)
                                                    .interruptResponse(true)
                                                    .prefixPaddingMs(0L)
                                                    .silenceDurationMs(0L)
                                                    .threshold(0.0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeAudioConfigOutput.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .speed(0.25)
                                            .voice(
                                                RealtimeAudioConfigOutput.Voice.UnionMember1.ALLOY
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .addInclude(
                                RealtimeSessionCreateRequest.Include
                                    .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                            )
                            .instructions("instructions")
                            .maxOutputTokensInf()
                            .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
                            .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
                            .parallelToolCalls(true)
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .reasoning(
                                RealtimeReasoning.builder()
                                    .effort(RealtimeReasoningEffort.MINIMAL)
                                    .build()
                            )
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                RealtimeFunctionTool.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(RealtimeFunctionTool.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                            .build()
                    )
                    .build()
            stubFor(post(anyUrl()).willReturn(ok().withBody("abc")))

            callServiceAsync.create(params).get().use { response ->
                assertThat(response.body()).hasContent("abc")
            }

            val requests = findAll(postRequestedFor(anyUrl()))
            assertThat(requests).hasSize(1)
            val request = requests.single()
            assertThat(request.isMultipart).isTrue()
            val encodings =
                mapOf(
                    "sdp" to ("application/sdp" to false),
                    "session" to ("application/json" to true),
                )
            for ((name, encoding) in encodings) {
                val parts = request.parts.filter { it.name == name }
                assertThat(request.parts.map { it.name }).noneMatch { it.startsWith("${name}[") }
                val field = params._body()[name]
                if (field == null || field.value.isMissing()) {
                    assertThat(parts).isEmpty()
                    continue
                }
                assertThat(parts).hasSize(1)
                val part = parts.single()
                assertThat(part.getHeader("Content-Type").firstValue()).isEqualTo(encoding.first)
                assertThat(part.getHeader("Content-Disposition").firstValue())
                    .doesNotContain("filename=")
                val expected = jsonMapper().readTree(jsonMapper().writeValueAsString(field.value))
                if (encoding.second) {
                    assertThat(jsonMapper().readTree(part.body.asString())).isEqualTo(expected)
                } else {
                    assertThat(part.body.asString()).isEqualTo(expected.textValue())
                }
            }
        } finally {
            client.close()
        }
    }

    @Test
    fun accept() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val callServiceAsync = client.realtime().calls()

        val future =
            callServiceAsync.accept(
                CallAcceptParams.builder()
                    .callId("call_id")
                    .realtimeSessionCreateRequest(
                        RealtimeSessionCreateRequest.builder()
                            .audio(
                                RealtimeAudioConfig.builder()
                                    .input(
                                        RealtimeAudioConfigInput.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .noiseReduction(
                                                RealtimeAudioConfigInput.NoiseReduction.builder()
                                                    .type(NoiseReductionType.NEAR_FIELD)
                                                    .build()
                                            )
                                            .transcription(
                                                AudioTranscription.builder()
                                                    .delay(AudioTranscription.Delay.MINIMAL)
                                                    .addKeyword("string")
                                                    .language("language")
                                                    .addLanguage("string")
                                                    .model(AudioTranscription.Model.WHISPER_1)
                                                    .prompt("prompt")
                                                    .build()
                                            )
                                            .turnDetection(
                                                RealtimeAudioInputTurnDetection.ServerVad.builder()
                                                    .createResponse(true)
                                                    .idleTimeoutMs(5000L)
                                                    .interruptResponse(true)
                                                    .prefixPaddingMs(0L)
                                                    .silenceDurationMs(0L)
                                                    .threshold(0.0)
                                                    .build()
                                            )
                                            .build()
                                    )
                                    .output(
                                        RealtimeAudioConfigOutput.builder()
                                            .format(
                                                RealtimeAudioFormats.AudioPcm.builder()
                                                    .rate(RealtimeAudioFormats.AudioPcm.Rate._24000)
                                                    .type(
                                                        RealtimeAudioFormats.AudioPcm.Type.AUDIO_PCM
                                                    )
                                                    .build()
                                            )
                                            .speed(0.25)
                                            .voice(
                                                RealtimeAudioConfigOutput.Voice.UnionMember1.ALLOY
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .addInclude(
                                RealtimeSessionCreateRequest.Include
                                    .ITEM_INPUT_AUDIO_TRANSCRIPTION_LOGPROBS
                            )
                            .instructions("instructions")
                            .maxOutputTokensInf()
                            .model(RealtimeSessionCreateRequest.Model.GPT_REALTIME)
                            .addOutputModality(RealtimeSessionCreateRequest.OutputModality.TEXT)
                            .parallelToolCalls(true)
                            .prompt(
                                ResponsePrompt.builder()
                                    .id("id")
                                    .variables(
                                        ResponsePrompt.Variables.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("string"))
                                            .build()
                                    )
                                    .version("version")
                                    .build()
                            )
                            .reasoning(
                                RealtimeReasoning.builder()
                                    .effort(RealtimeReasoningEffort.MINIMAL)
                                    .build()
                            )
                            .toolChoice(ToolChoiceOptions.NONE)
                            .addTool(
                                RealtimeFunctionTool.builder()
                                    .description("description")
                                    .name("name")
                                    .parameters(JsonValue.from(mapOf<String, Any>()))
                                    .type(RealtimeFunctionTool.Type.FUNCTION)
                                    .build()
                            )
                            .tracingAuto()
                            .truncation(RealtimeTruncation.RealtimeTruncationStrategy.AUTO)
                            .build()
                    )
                    .build()
            )

        val response = future.get()
    }

    @Test
    fun hangup() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val callServiceAsync = client.realtime().calls()

        val future = callServiceAsync.hangup("call_id")

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
        val callServiceAsync = client.realtime().calls()

        val future =
            callServiceAsync.refer(
                CallReferParams.builder().callId("call_id").targetUri("tel:+14155550123").build()
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
        val callServiceAsync = client.realtime().calls()

        val future =
            callServiceAsync.reject(
                CallRejectParams.builder().callId("call_id").statusCode(486L).build()
            )

        val response = future.get()
    }
}
