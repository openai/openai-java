package com.openai.core

import com.openai.client.OpenAIClientImpl
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

internal class DataResidencyTest {
    private val httpClient = mock<HttpClient>()

    private fun builder() = ClientOptions.builder().httpClient(httpClient).apiKey("test-api-key")

    @Test
    fun syncAndAsyncCopiesRouteOnlyThroughTheUrl() {
        val capture = CaptureClient()
        val original = OpenAIClientImpl(builder().httpClient(capture).build())
        val eu = original.withOptions { it.dataResidency(DataResidency.EU) }
        eu.models().list()
        eu.async().withOptions { it.dataResidency(DataResidency.US) }.models().list().join()
        original.models().list()
        assertThat(capture.requests.map { it.url() })
            .containsExactly(
                "https://eu.api.openai.com/v1/models",
                "https://us.api.openai.com/v1/models",
                "https://api.openai.com/v1/models",
            )
        capture.requests.forEach {
            assertThat(it.body).isNull()
            assertThat(it.headers.names()).noneMatch { name ->
                name.contains("residency", ignoreCase = true)
            }
            assertThat(it.headers.values("Authorization")).containsExactly("Bearer test-api-key")
        }
    }

    private class CaptureClient : HttpClient {
        val requests = mutableListOf<HttpRequest>()

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            return object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body() = """{"object":"list","data":[]}""".byteInputStream()

                override fun close() {}
            }
        }

        override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
            CompletableFuture.completedFuture(execute(request, requestOptions))

        override fun close() {}
    }
}
