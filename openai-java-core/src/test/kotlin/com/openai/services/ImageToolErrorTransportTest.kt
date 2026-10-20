package com.openai.services

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.io.InputStream
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ImageToolErrorTransportTest {
    @ParameterizedTest
    @EnumSource(Route::class)
    fun imageErrorFieldsSurviveTransport(route: Route) {
        for (errorCase in ErrorCase.values()) {
            val transport = FakeHttpClient(payload(errorCase))
            val options =
                ClientOptions.builder()
                    .httpClient(transport)
                    .baseUrl("https://example.test/v1")
                    .apiKey("synthetic-key")
                    .responseValidation(false)
                    .build()
            val client = OpenAIClientImpl(options)
            try {
                val actual =
                    when (route) {
                        Route.BLOCKING,
                        Route.ASYNC -> {
                            val response =
                                if (route == Route.BLOCKING) {
                                    client.responses().retrieve("resp_synthetic")
                                } else {
                                    client.async().responses().retrieve("resp_synthetic").join()
                                }
                            val call = response.output().single().asImageGenerationCall()
                            assertThat(call.id()).isEqualTo("img_synthetic")
                            call
                                .error()
                                .map { error ->
                                    ErrorView(
                                        error.code().orElse(null),
                                        error.param().orElse(null),
                                        error.message(),
                                        error.type(),
                                        error
                                            .moderationDetails()
                                            .map { it.moderationStage().toString() }
                                            .orElse(null),
                                        error
                                            .moderationDetails()
                                            .map { it.categories() }
                                            .orElse(null),
                                    )
                                }
                                .orElse(null)
                        }
                        Route.BETA_BLOCKING,
                        Route.BETA_ASYNC -> {
                            val response =
                                if (route == Route.BETA_BLOCKING) {
                                    client.beta().responses().retrieve("resp_synthetic")
                                } else {
                                    client
                                        .async()
                                        .beta()
                                        .responses()
                                        .retrieve("resp_synthetic")
                                        .join()
                                }
                            val call = response.output().single().asImageGenerationCall()
                            assertThat(call.id()).isEqualTo("img_synthetic")
                            call
                                .error()
                                .map { error ->
                                    ErrorView(
                                        error.code().orElse(null),
                                        error.param().orElse(null),
                                        error.message(),
                                        error.type(),
                                        error
                                            .moderationDetails()
                                            .map { it.moderationStage().toString() }
                                            .orElse(null),
                                        error
                                            .moderationDetails()
                                            .map { it.categories() }
                                            .orElse(null),
                                    )
                                }
                                .orElse(null)
                        }
                    }
                val expected =
                    if (errorCase == ErrorCase.NO_ERROR) null
                    else
                        ErrorView(
                            if (errorCase == ErrorCase.NULLS) null else "synthetic_code",
                            if (errorCase == ErrorCase.NULLS) null else "synthetic_param",
                            "synthetic blocked",
                            "image_generation_error",
                            if (errorCase == ErrorCase.NO_MODERATION) null else "output",
                            if (errorCase == ErrorCase.NO_MODERATION) null
                            else listOf("synthetic_category"),
                        )
                assertThat(actual).describedAs("%s / %s", route, errorCase).isEqualTo(expected)
                assertThat(transport.requests).hasSize(1)
                val request = transport.requests.single()
                assertThat(request.url())
                    .startsWith("https://example.test/v1/responses/resp_synthetic")
                if (route == Route.BETA_BLOCKING || route == Route.BETA_ASYNC) {
                    assertThat(request.url()).contains("beta=true")
                }
            } finally {
                options.close()
            }
        }
    }

    private fun payload(errorCase: ErrorCase): String {
        val code = if (errorCase == ErrorCase.NULLS) "null" else "\"synthetic_code\""
        val param = if (errorCase == ErrorCase.NULLS) "null" else "\"synthetic_param\""
        val moderation =
            if (errorCase == ErrorCase.NO_MODERATION) ""
            else
                """, "moderation_details": {"moderation_stage":"output", "categories":["synthetic_category"]}"""
        val error =
            if (errorCase == ErrorCase.NO_ERROR) ""
            else
                """, "error":{"code":$code, "param":$param, "message":"synthetic blocked", "type":"image_generation_error"$moderation}"""
        return """{"id":"resp_synthetic", "object":"response", "output":[{"id":"img_synthetic", "type":"image_generation_call", "status":"failed", "result":null$error}]}"""
    }

    private data class ErrorView(
        val code: String?,
        val param: String?,
        val message: String,
        val type: String,
        val stage: String?,
        val categories: List<String>?,
    )

    private class FakeHttpClient(private val body: String) : HttpClient {
        val requests = mutableListOf<HttpRequest>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            return object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers =
                    Headers.builder().put("Content-Type", "application/json").build()

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

    internal enum class Route {
        BLOCKING,
        ASYNC,
        BETA_BLOCKING,
        BETA_ASYNC,
    }

    private enum class ErrorCase {
        VALUES,
        NULLS,
        NO_MODERATION,
        NO_ERROR,
    }
}
