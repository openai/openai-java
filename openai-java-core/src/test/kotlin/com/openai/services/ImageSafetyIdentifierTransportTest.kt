package com.openai.services

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.jsonMapper
import com.openai.models.images.ImageEditParams
import com.openai.models.images.ImageGenerateParams
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ImageSafetyIdentifierTransportTest {
    companion object {
        @JvmStatic
        fun safetyIdentifierCases(): List<Arguments> =
            listOf(false, true).flatMap { edit ->
                listOf(false, true).flatMap { streaming ->
                    listOf("\"synthetic-image-safety-user\"", "null", null).map { wireValue ->
                        Arguments.of(edit, streaming, wireValue)
                    }
                }
            }
    }

    @ParameterizedTest(name = "edit={0}, streaming={1}, safety_identifier={2}")
    @MethodSource("safetyIdentifierCases")
    fun safetyIdentifiersSurviveImageResponsesAndStreams(
        edit: Boolean,
        streaming: Boolean,
        wireValue: String?,
    ) {
        val field = wireValue?.let { ",\"safety_identifier\":$it" } ?: ""
        val type = if (edit) "image_edit.completed" else "image_generation.completed"
        val json =
            if (streaming) {
                """{"type":"$type","b64_json":"c3ludGhldGlj","created_at":1620000000,"size":"1024x1024","quality":"high","background":"transparent","output_format":"png","usage":{"total_tokens":100,"input_tokens":50,"output_tokens":50,"input_tokens_details":{"text_tokens":10,"image_tokens":40}}$field}"""
            } else {
                """{"created":1620000000,"data":[{"b64_json":"c3ludGhldGlj"}]$field}"""
            }
        val transport = FakeHttpClient(if (streaming) "data: $json\n\n" else json, streaming)
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .baseUrl("https://example.test/v1")
                .apiKey("synthetic-key")
                .build()
        try {
            val client = OpenAIClientImpl(options)
            val generateParams =
                ImageGenerateParams.builder()
                    .prompt("A synthetic image")
                    .safetyIdentifier("synthetic-request-user")
                    .user("legacy-user")
                    .build()
            val editParams =
                ImageEditParams.builder()
                    .prompt("A synthetic image")
                    .image("synthetic image".byteInputStream())
                    .safetyIdentifier("synthetic-request-user")
                    .user("legacy-user")
                    .build()
            val actual =
                if (streaming) {
                    if (edit) {
                        client.images().editStreaming(editParams).use { response ->
                            val events = response.stream().toArray()
                            assertThat(events).hasSize(1)
                            (events.single() as com.openai.models.images.ImageEditStreamEvent)
                                .asCompleted()
                                .safetyIdentifier()
                                .orElse(null)
                        }
                    } else {
                        client.images().generateStreaming(generateParams).use { response ->
                            val events = response.stream().toArray()
                            assertThat(events).hasSize(1)
                            (events.single() as com.openai.models.images.ImageGenStreamEvent)
                                .asGenerationCompleted()
                                .safetyIdentifier()
                                .orElse(null)
                        }
                    }
                } else {
                    val response =
                        if (edit) client.images().edit(editParams)
                        else client.images().generate(generateParams)
                    response.safetyIdentifier().orElse(null)
                }
            val expected =
                if (wireValue == null || wireValue == "null") null
                else "synthetic-image-safety-user"
            assertThat(actual)
                .describedAs("edit=%s stream=%s value=%s", edit, streaming, wireValue)
                .isEqualTo(expected)
            assertThat(transport.requests).hasSize(1)
            val endpoint = if (edit) "edits" else "generations"
            assertThat(transport.requests.single().url())
                .isEqualTo("https://example.test/v1/images/$endpoint")
            val requestBody = transport.requestBodies.single()
            if (edit) {
                assertThat(requestBody)
                    .containsPattern(
                        "name=\"safety_identifier\"\\r\\nContent-Type: [^\\r]+\\r\\n\\r\\nsynthetic-request-user\\r\\n"
                    )
                    .containsPattern(
                        "name=\"user\"\\r\\nContent-Type: [^\\r]+\\r\\n\\r\\nlegacy-user\\r\\n"
                    )
            } else {
                val requestJson = jsonMapper().readTree(requestBody)
                assertThat(requestJson.get("safety_identifier").asText())
                    .isEqualTo("synthetic-request-user")
                assertThat(requestJson.get("user").asText()).isEqualTo("legacy-user")
            }
        } finally {
            options.close()
        }
    }

    private class FakeHttpClient(private val body: String, private val streaming: Boolean) :
        HttpClient {
        val requests = mutableListOf<HttpRequest>()
        val requestBodies = mutableListOf<String>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            val bytes = ByteArrayOutputStream()
            request.body!!.writeTo(bytes)
            requestBodies.add(bytes.toString("UTF-8"))
            return object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers =
                    Headers.builder()
                        .put(
                            "Content-Type",
                            if (streaming) "text/event-stream" else "application/json",
                        )
                        .build()

                override fun body(): InputStream = body.byteInputStream()

                override fun close() {}
            }
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }
}
