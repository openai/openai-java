package com.openai.core.http

import com.openai.core.RequestOptions
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class HttpClientTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun legacyClient_reportsUnavailableUrlBeforeDelegating(async: Boolean) {
        val events = mutableListOf<String>()
        val request = request()
        val options = RequestOptions.builder().build()
        val response = response()
        val client = legacyClient { actualRequest, actualOptions ->
            assertThat(actualRequest).isSameAs(request)
            assertThat(actualOptions).isSameAs(options)
            events.add("execute")
            response
        }
        val observer = RequestObserver { method, url ->
            assertThat(method).isEqualTo(HttpMethod.GET)
            assertThat(url).isNull()
            events.add("observe")
        }

        val actualResponse =
            if (async) client.executeAsync(request, options, observer).get()
            else client.execute(request, options, observer)

        assertThat(actualResponse).isSameAs(response)
        assertThat(events).containsExactly("observe", "execute")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun observerFailure_doesNotPreventLegacyDispatch(async: Boolean) {
        val response = response()
        val client = legacyClient { _, _ -> response }
        val observer = RequestObserver { _, _ -> throw IllegalStateException("Observer failed") }

        val actualResponse =
            if (async) client.executeAsync(request(), RequestOptions.none(), observer).get()
            else client.execute(request(), RequestOptions.none(), observer)

        assertThat(actualResponse).isSameAs(response)
    }

    private fun legacyClient(execute: (HttpRequest, RequestOptions) -> HttpResponse): HttpClient =
        object : HttpClient {
            override fun execute(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): HttpResponse = execute.invoke(request, requestOptions)

            override fun executeAsync(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): CompletableFuture<HttpResponse> =
                CompletableFuture.completedFuture(execute(request, requestOptions))

            override fun close() {}
        }

    private fun request() =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl("https://example.com/user name")
            .build()

    private fun response() =
        object : HttpResponse {
            override fun statusCode() = 200

            override fun headers() = Headers.builder().build()

            override fun body() = ByteArrayInputStream(ByteArray(0))

            override fun close() {}
        }
}
