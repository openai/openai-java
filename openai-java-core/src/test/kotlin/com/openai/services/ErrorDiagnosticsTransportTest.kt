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

internal class ErrorDiagnosticsTransportTest {
    @ParameterizedTest
    @EnumSource(Route::class)
    fun diagnosticsSurviveTransport(route: Route) {
        for (shape in listOf("values", "nulls", "omitted")) {
            val fields =
                when (shape) {
                    "values" -> """, "type":"synthetic_error", "param":"input[0]""""
                    "nulls" -> """, "type":null, "param":null"""
                    else -> ""
                }
            val transport =
                FakeHttpClient(
                    """{"error":{"code":"server_error","message":"Synthetic failure"$fields}}"""
                )
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
                        Route.BLOCKING -> {
                            val error = client.responses().retrieve("resp_synthetic").error().get()
                            listOf(
                                error.type().orElse(null),
                                error.param().orElse(null),
                                error.code().toString(),
                                error.message(),
                            )
                        }
                        Route.ASYNC -> {
                            val error =
                                client
                                    .async()
                                    .responses()
                                    .retrieve("resp_synthetic")
                                    .join()
                                    .error()
                                    .get()
                            listOf(
                                error.type().orElse(null),
                                error.param().orElse(null),
                                error.code().toString(),
                                error.message(),
                            )
                        }
                        Route.BETA_BLOCKING -> {
                            val error =
                                client.beta().responses().retrieve("resp_synthetic").error().get()
                            listOf(
                                error.type().orElse(null),
                                error.param().orElse(null),
                                error.code().toString(),
                                error.message(),
                            )
                        }
                        Route.BETA_ASYNC -> {
                            val error =
                                client
                                    .async()
                                    .beta()
                                    .responses()
                                    .retrieve("resp_synthetic")
                                    .join()
                                    .error()
                                    .get()
                            listOf(
                                error.type().orElse(null),
                                error.param().orElse(null),
                                error.code().toString(),
                                error.message(),
                            )
                        }
                        Route.VIDEO_BLOCKING -> {
                            val error = client.videos().retrieve("video_synthetic").error().get()
                            listOf(
                                error.type().orElse(null),
                                error.param().orElse(null),
                                error.code().toString(),
                                error.message(),
                            )
                        }
                        Route.VIDEO_ASYNC -> {
                            val error =
                                client
                                    .async()
                                    .videos()
                                    .retrieve("video_synthetic")
                                    .join()
                                    .error()
                                    .get()
                            listOf(
                                error.type().orElse(null),
                                error.param().orElse(null),
                                error.code().toString(),
                                error.message(),
                            )
                        }
                    }
                assertThat(actual)
                    .isEqualTo(
                        listOf(
                            if (shape == "values") "synthetic_error" else null,
                            if (shape == "values") "input[0]" else null,
                            "server_error",
                            "Synthetic failure",
                        )
                    )
                assertThat(transport.requests).hasSize(1)
                val path =
                    if (route == Route.VIDEO_BLOCKING || route == Route.VIDEO_ASYNC)
                        "videos/video_synthetic"
                    else "responses/resp_synthetic"
                val query =
                    if (route == Route.BETA_BLOCKING || route == Route.BETA_ASYNC) "?beta=true"
                    else ""
                assertThat(transport.requests.single().url())
                    .isEqualTo("https://example.test/v1/$path$query")
            } finally {
                options.close()
            }
        }
    }

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
        VIDEO_BLOCKING,
        VIDEO_ASYNC,
    }
}
