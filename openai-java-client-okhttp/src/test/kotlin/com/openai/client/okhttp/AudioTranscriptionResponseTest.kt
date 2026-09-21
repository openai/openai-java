package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.core.JsonValue
import com.openai.core.http.HttpResponseFor
import com.openai.core.jsonMapper
import com.openai.errors.BadRequestException
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.audio.AudioModel
import com.openai.models.audio.AudioResponseFormat
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.transcriptions.TranscriptionCreateResponse
import com.openai.models.audio.transcriptions.TranscriptionStreamEvent
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

internal class AudioTranscriptionResponseTest {
    private val basic = """{"text":"hello","future_field":{"retained":true}}"""
    private val diarized =
        """{"text":"hello","duration":1.0,"task":"transcribe","segments":[{"id":"seg_1","start":0.0,"end":1.0,"speaker":"speaker_1","text":"hello","type":"transcript.text.segment","future_segment":true}],"future_field":{"retained":true}}"""
    private val verbose =
        """{"text":"hello","duration":1.0,"language":"english","segments":[{"id":7,"seek":0,"start":0.0,"end":1.0,"text":"hello","tokens":[1],"temperature":0.0,"avg_logprob":-0.1,"compression_ratio":1.0,"no_speech_prob":0.0,"future_segment":true}],"future_field":{"retained":true}}"""
    private val emptyDiarized =
        """{"text":"hello","duration":1.0,"task":"transcribe","segments":[],"future_field":{"retained":true}}"""
    private val emptyVerbose =
        """{"text":"hello","duration":1.0,"language":"english","task":"transcribe","segments":[],"future_field":{"retained":true}}"""

    private data class Case(
        val name: String,
        val format: String?,
        val body: String,
        val kind: String,
        val override: JsonValue? = null,
        val wireFormat: String? = format,
        val rawResponse: Boolean = false,
    )

    private val cases =
        listOf(
            Case("default", null, basic, "basic"),
            Case("JSON", "json", basic, "basic"),
            Case("future format", "future_json", basic, "basic"),
            Case("diarized", "diarized_json", diarized, "diarized", rawResponse = true),
            Case("empty diarized", "diarized_json", emptyDiarized, "diarized"),
            Case("verbose", "verbose_json", verbose, "verbose"),
            Case(
                "ambiguous empty verbose",
                "verbose_json",
                emptyVerbose,
                "verbose",
                rawResponse = true,
            ),
            Case(
                "JSON to diarized",
                "json",
                diarized,
                "diarized",
                JsonValue.from("diarized_json"),
                "diarized_json",
            ),
            Case(
                "text to verbose",
                "text",
                emptyVerbose,
                "verbose",
                JsonValue.from("verbose_json"),
                "verbose_json",
            ),
            Case(
                "diarized to JSON",
                "diarized_json",
                basic,
                "basic",
                JsonValue.from("json"),
                "json",
            ),
            Case(
                "verbose to text",
                "verbose_json",
                "Héllo 世界\n",
                "plain",
                JsonValue.from("text"),
                "text",
                rawResponse = true,
            ),
            Case("null override", "text", basic, "basic", JsonValue.from(null), null),
            Case("non-string override", "text", basic, "basic", JsonValue.from(7), "7"),
            Case("text", "text", "Héllo 世界\nline two\r\n", "plain"),
            Case("SRT", "srt", "1\n00:00:00,000 --> 00:00:01,000\nhello\n\n", "plain"),
            Case("VTT", "vtt", "WEBVTT\n\n00:00.000 --> 00:01.000\nhello\n", "plain"),
        )

    @TestFactory
    fun selectsModelsFromEffectiveFormat() =
        listOf(false, true).flatMap { async ->
            listOf("normal", "parsed", "raw").flatMap { mode ->
                cases
                    .filter { mode == "normal" || it.rawResponse }
                    .map { case ->
                        dynamicTest("${case.name} async=$async mode=$mode") {
                            withClient { client, server ->
                                server.enqueue(
                                    MockResponse()
                                        .setHeader(
                                            "Content-Type",
                                            if (case.kind == "plain") "text/plain"
                                            else "application/json",
                                        )
                                        .setHeader("x-request-id", "synthetic-audio-request")
                                        .setBody(case.body)
                                )
                                val params = params(case.format, case.override)
                                if (mode == "normal") {
                                    assertParsed(create(client, params, async), case)
                                } else {
                                    raw(client, params, async).use { response ->
                                        assertThat(response.requestId())
                                            .contains("synthetic-audio-request")
                                        if (mode == "raw") {
                                            assertThat(
                                                    response
                                                        .body()
                                                        .readBytes()
                                                        .toString(Charsets.UTF_8)
                                                )
                                                .isEqualTo(case.body)
                                        } else {
                                            val parsed = response.parse()
                                            assertParsed(parsed, case)
                                            assertThat(response.parse()).isSameAs(parsed)
                                        }
                                    }
                                }
                                val request = server.takeRequest(5, TimeUnit.SECONDS)!!
                                assertThat(request.path).isEqualTo("/v1/audio/transcriptions")
                                val multipart = request.body.readUtf8()
                                val format =
                                    Regex("(?s)name=\"response_format\"\r\n.*?\r\n\r\n(.*?)\r\n--")
                                        .find(multipart)
                                        ?.groupValues
                                        ?.get(1)
                                assertThat(format).isEqualTo(case.wireFormat)
                            }
                        }
                    }
            }
        }

    @TestFactory
    fun effectiveBodyOverridesDeclaredFormat() =
        listOf(false, true).flatMap { async ->
            listOf(null to "text", "json" to "text", "text" to "json").map { (declared, effective)
                ->
                dynamicTest("retained override-$declared-to-$effective async=$async") {
                    withClient { client, server ->
                        val text =
                            if (effective == "text") "effective body text\n"
                            else "effective body JSON"
                        val body = if (effective == "text") text else """{"text":"$text"}"""
                        server.enqueue(MockResponse().setBody(body))
                        val response =
                            create(client, params(declared, JsonValue.from(effective)), async)
                        assertThat(response.asTranscription().text()).isEqualTo(text)
                        val multipart = server.takeRequest(5, TimeUnit.SECONDS)!!.body.readUtf8()
                        val wireFormat =
                            Regex("(?s)name=\"response_format\"\r\n.*?\r\n\r\n(.*?)\r\n--")
                                .find(multipart)
                                ?.groupValues
                                ?.get(1)
                        assertThat(wireFormat).isEqualTo(effective)
                    }
                }
            }
        }

    @TestFactory
    fun requiredRichFieldsRespectOptionalValidation() =
        listOf(false, true).flatMap { async ->
            listOf(false, true).flatMap { validate ->
                listOf(
                        "duration" to emptyDiarized.replace("\"duration\":1.0,", ""),
                        "task" to emptyDiarized.replace("\"task\":\"transcribe\",", ""),
                        "speaker" to diarized.replace("\"speaker\":\"speaker_1\",", ""),
                    )
                    .map { (field, body) ->
                        dynamicTest("missing $field async=$async validate=$validate") {
                            withClient(validate) { client, server ->
                                server.enqueue(MockResponse().setBody(body))
                                val params = params("diarized_json")
                                if (validate) {
                                    val error =
                                        if (async)
                                            assertThrows<ExecutionException> {
                                                    create(client, params, true)
                                                }
                                                .cause
                                        else
                                            assertThrows<OpenAIInvalidDataException> {
                                                create(client, params, false)
                                            }
                                    assertThat(error)
                                        .isInstanceOf(OpenAIInvalidDataException::class.java)
                                    assertThat(error!!.message).contains(field)
                                } else {
                                    val response = create(client, params, async)
                                    assertThat(response.isDiarized()).isTrue()
                                    assertThrows<OpenAIInvalidDataException> {
                                        response.asDiarized().validate()
                                    }
                                }
                            }
                        }
                    }
            }
        }

    @TestFactory
    fun richRequestsPreserveErrorsAndLazyParsing() =
        listOf(false, true).flatMap { async ->
            listOf(200, 400).map { status ->
                dynamicTest("invalid response status=$status async=$async") {
                    withClient { client, server ->
                        server.enqueue(
                            MockResponse()
                                .setResponseCode(status)
                                .setBody(
                                    if (status == 400)
                                        """{"error":{"message":"synthetic rejection","type":"invalid_request_error"}}"""
                                    else "not JSON"
                                )
                        )
                        if (status == 400) {
                            val error =
                                if (async)
                                    assertThrows<ExecutionException> {
                                            raw(client, params("diarized_json"), true)
                                        }
                                        .cause
                                else
                                    assertThrows<BadRequestException> {
                                        raw(client, params("diarized_json"), false)
                                    }
                            assertThat(error).isInstanceOf(BadRequestException::class.java)
                            assertThat(error!!.message).contains("synthetic rejection")
                        } else {
                            raw(client, params("diarized_json"), async).use { response ->
                                assertThat(response.statusCode()).isEqualTo(200)
                                assertThrows<OpenAIInvalidDataException> { response.parse() }
                            }
                        }
                    }
                }
            }
        }

    @TestFactory
    fun streamingRetainsTypedEvents() =
        listOf(false, true).flatMap { async ->
            listOf("json", "diarized_json").map { format ->
                dynamicTest("stream format=$format async=$async") {
                    withClient { client, server ->
                        val event =
                            if (format == "json")
                                """{"type":"transcript.text.delta","delta":"hello"}"""
                            else
                                """{"type":"transcript.text.segment","id":"seg_1","start":0.0,"end":1.0,"speaker":"speaker_1","text":"hello"}"""
                        server.enqueue(
                            MockResponse()
                                .setHeader("Content-Type", "text/event-stream")
                                .setBody("data: $event\n\ndata: [DONE]\n\n")
                        )
                        val events = mutableListOf<TranscriptionStreamEvent>()
                        if (async) {
                            val stream =
                                client
                                    .async()
                                    .audio()
                                    .transcriptions()
                                    .createStreaming(params(format))
                            try {
                                stream
                                    .subscribe { events.add(it) }
                                    .onCompleteFuture()
                                    .get(5, TimeUnit.SECONDS)
                            } finally {
                                stream.close()
                            }
                        } else {
                            client.audio().transcriptions().createStreaming(params(format)).use {
                                stream ->
                                stream.stream().forEach { events.add(it) }
                            }
                        }
                        assertThat(events).hasSize(1)
                        if (format == "json")
                            assertThat(events.single().asTranscriptTextDelta().delta())
                                .isEqualTo("hello")
                        else {
                            assertThat(events.single().asTranscriptTextSegment().id())
                                .isEqualTo("seg_1")
                            assertThat(events.single().asTranscriptTextSegment().speaker())
                                .isEqualTo("speaker_1")
                        }
                    }
                }
            }
        }

    @Test
    fun directUnionDecodingRetainsItsExistingScoringAndJson() {
        val response = jsonMapper().readValue(emptyVerbose, TranscriptionCreateResponse::class.java)
        assertThat(response.isDiarized()).isTrue()
        assertThat(response._json()).isPresent()
        assertThat(response.asDiarized()._additionalProperties()).containsKey("language")
    }

    private fun assertParsed(response: TranscriptionCreateResponse, case: Case) {
        when (case.kind) {
            "diarized" -> {
                val model = response.asDiarized()
                assertThat(model.text()).isEqualTo("hello")
                assertThat(model.duration()).isEqualTo(1.0)
                assertThat(model._additionalProperties())
                    .containsEntry("future_field", JsonValue.from(mapOf("retained" to true)))
                model.segments().forEach {
                    assertThat(it.id()).isEqualTo("seg_1")
                    assertThat(it.speaker()).isEqualTo("speaker_1")
                    assertThat(it._additionalProperties())
                        .containsEntry("future_segment", JsonValue.from(true))
                }
                assertThat(model.segments()).hasSize(if (case.body == emptyDiarized) 0 else 1)
                assertThat(response._json()).isEmpty()
            }
            "verbose" -> {
                val model = response.asVerbose()
                assertThat(model.text()).isEqualTo("hello")
                assertThat(model.language()).isEqualTo("english")
                assertThat(model._additionalProperties()).containsKey("future_field")
                model.segments().get().forEach {
                    assertThat(it.id()).isEqualTo(7L)
                    assertThat(it._additionalProperties())
                        .containsEntry("future_segment", JsonValue.from(true))
                }
                assertThat(model.segments().get()).hasSize(if (case.body == emptyVerbose) 0 else 1)
                assertThat(response._json()).isEmpty()
            }
            "basic" -> {
                assertThat(response.asTranscription().text()).isEqualTo("hello")
                assertThat(response.asTranscription()._additionalProperties())
                    .containsKey("future_field")
                assertThat(response._json()).isPresent()
            }
            else -> assertThat(response.asTranscription().text()).isEqualTo(case.body)
        }
    }

    private fun params(format: String?, override: JsonValue? = null): TranscriptionCreateParams =
        TranscriptionCreateParams.builder()
            .file("synthetic audio".byteInputStream())
            .model(AudioModel.WHISPER_1)
            .apply {
                format?.let { responseFormat(AudioResponseFormat.of(it)) }
                override?.let { putAdditionalBodyProperty("response_format", it) }
            }
            .build()

    private fun create(client: OpenAIClient, params: TranscriptionCreateParams, async: Boolean) =
        if (async) client.async().audio().transcriptions().create(params).get(5, TimeUnit.SECONDS)
        else client.audio().transcriptions().create(params)

    private fun raw(
        client: OpenAIClient,
        params: TranscriptionCreateParams,
        async: Boolean,
    ): HttpResponseFor<TranscriptionCreateResponse> =
        if (async)
            client
                .async()
                .audio()
                .transcriptions()
                .withRawResponse()
                .create(params)
                .get(5, TimeUnit.SECONDS)
        else client.audio().transcriptions().withRawResponse().create(params)

    private fun withClient(validate: Boolean = true, block: (OpenAIClient, MockWebServer) -> Unit) {
        MockWebServer().use { server ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("synthetic-transcription-key")
                    .baseUrl(server.url("/v1/").toString())
                    .maxRetries(0)
                    .responseValidation(validate)
                    .build()
            try {
                block(client, server)
            } finally {
                client.close()
            }
        }
    }
}
