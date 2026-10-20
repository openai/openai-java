package com.openai.client.okhttp

import com.openai.client.OpenAIClient
import com.openai.core.JsonValue
import com.openai.core.http.HttpResponseFor
import com.openai.errors.BadRequestException
import com.openai.models.audio.AudioModel
import com.openai.models.audio.translations.TranslationCreateParams
import com.openai.models.audio.translations.TranslationCreateResponse
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

internal class AudioTranslationMediaTest {
    private data class Case(
        val name: String,
        val format: String?,
        val body: String,
        val bodyFormat: JsonValue? = null,
        val wireFormat: String? = format,
        val json: Boolean = false,
    )

    private val jsonBody = """{"text":"translated","future_field":{"retained":true}}"""
    private val verboseBody =
        """{"text":"translated","duration":1.0,"language":"english","segments":[],"future_field":true}"""
    private val cases =
        listOf(
            Case("text", "text", "Héllo 世界\nline two\r\n"),
            Case("srt", "srt", "1\n00:00:00,000 --> 00:00:01,000\nHéllo 世界\n\n"),
            Case("vtt", "vtt", "WEBVTT\n\n00:00.000 --> 00:01.000\nHéllo 世界\n"),
            Case("empty", "text", ""),
            Case("JSON-looking text", "text", jsonBody),
            Case("JSON to text override", "json", "full text\n", JsonValue.from("text"), "text"),
            Case("missing to SRT override", null, "1\nsubtitle\n", JsonValue.from("srt"), "srt"),
            Case("text to VTT override", "text", "WEBVTT\n\n", JsonValue.from("vtt"), "vtt"),
            Case("default JSON", null, jsonBody, json = true),
            Case("JSON", "json", jsonBody, json = true),
            Case("verbose JSON", "verbose_json", verboseBody, json = true),
            Case("future format", "future_json", jsonBody, json = true),
            Case("text to JSON override", "text", jsonBody, JsonValue.from("json"), "json", true),
            Case(
                "text to verbose override",
                "text",
                verboseBody,
                JsonValue.from("verbose_json"),
                "verbose_json",
                true,
            ),
            Case("non-string override", "text", jsonBody, JsonValue.from(7), "7", true),
            Case("null override", "text", jsonBody, JsonValue.from(null), null, true),
        )

    @TestFactory
    fun preservesResponseBodiesAndEffectiveFormats() =
        listOf(false, true).flatMap { async ->
            listOf("normal", "parsed", "raw").flatMap { mode ->
                cases.map { case ->
                    dynamicTest("${case.name} async=$async mode=$mode") {
                        withClient { client, server ->
                            server.enqueue(
                                MockResponse()
                                    .setHeader(
                                        "Content-Type",
                                        if (case.json) "application/json"
                                        else "text/plain; charset=utf-8",
                                    )
                                    .setBody(case.body)
                            )
                            val params =
                                TranslationCreateParams.builder()
                                    .file("synthetic audio".byteInputStream())
                                    .model(AudioModel.WHISPER_1)
                                    .apply {
                                        case.format?.let {
                                            responseFormat(
                                                TranslationCreateParams.ResponseFormat.of(it)
                                            )
                                        }
                                        case.bodyFormat?.let {
                                            putAdditionalBodyProperty("response_format", it)
                                        }
                                    }
                                    .build()
                            if (mode == "normal") {
                                assertParsed(create(client, params, async), case)
                            } else {
                                raw(client, params, async).use { response ->
                                    if (mode == "raw") {
                                        assertThat(
                                                response.body().readBytes().toString(Charsets.UTF_8)
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
                            assertThat(request.path).isEqualTo("/v1/audio/translations")
                            val multipart = request.body.readUtf8()
                            assertThat(multipart)
                                .contains("name=\"file\"", "synthetic audio", "whisper-1")
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
    fun plaintextRequestsPreserveApiErrors() =
        listOf(false, true).map { async ->
            dynamicTest("API error async=$async") {
                withClient { client, server ->
                    server.enqueue(
                        MockResponse()
                            .setResponseCode(400)
                            .setHeader("Content-Type", "application/json")
                            .setBody(
                                """{"error":{"message":"synthetic rejection","type":"invalid_request_error"}}"""
                            )
                    )
                    val params =
                        TranslationCreateParams.builder()
                            .file("synthetic audio".byteInputStream())
                            .model(AudioModel.WHISPER_1)
                            .responseFormat(TranslationCreateParams.ResponseFormat.of("text"))
                            .build()
                    val error =
                        if (async) {
                            assertThrows<ExecutionException> { create(client, params, true) }.cause
                        } else {
                            assertThrows<BadRequestException> { create(client, params, false) }
                        }
                    assertThat(error).isInstanceOf(BadRequestException::class.java)
                    assertThat(error!!.message).contains("synthetic rejection")
                }
            }
        }

    private fun assertParsed(response: TranslationCreateResponse, case: Case) {
        if (case.json) {
            assertThat(response._json()).isPresent()
            assertThat(response._json().get().asObject().get()).containsKey("future_field")
            val text =
                if (response.isTranslation()) response.asTranslation().text()
                else response.asVerbose().text()
            assertThat(text).isEqualTo("translated")
        } else {
            assertThat(response.asTranslation().text()).isEqualTo(case.body)
            assertThat(response._json()).isEmpty()
        }
    }

    private fun create(
        client: OpenAIClient,
        params: TranslationCreateParams,
        async: Boolean,
    ): TranslationCreateResponse =
        if (async) client.async().audio().translations().create(params).get(5, TimeUnit.SECONDS)
        else client.audio().translations().create(params)

    private fun raw(
        client: OpenAIClient,
        params: TranslationCreateParams,
        async: Boolean,
    ): HttpResponseFor<TranslationCreateResponse> =
        if (async) {
            client
                .async()
                .audio()
                .translations()
                .withRawResponse()
                .create(params)
                .get(5, TimeUnit.SECONDS)
        } else client.audio().translations().withRawResponse().create(params)

    private fun withClient(block: (OpenAIClient, MockWebServer) -> Unit) {
        MockWebServer().use { server ->
            val client =
                OpenAIOkHttpClient.builder()
                    .apiKey("synthetic-translation-key")
                    .baseUrl(server.url("/v1/").toString())
                    .maxRetries(0)
                    .responseValidation(true)
                    .build()
            try {
                block(client, server)
            } finally {
                client.close()
            }
        }
    }
}
