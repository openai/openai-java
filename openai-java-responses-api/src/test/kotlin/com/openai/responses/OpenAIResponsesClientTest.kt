package com.openai.responses

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.getPackageVersion
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.util.concurrent.CompletableFuture
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

internal class OpenAIResponsesClientTest {
    @Test
    fun syncAndAsyncUseSdkUserAgents() {
        checkRequests(
            disableTelemetry = false,
            customAgent = null,
            syncAgents = listOf("OpenAIResponsesClient/Java ${getPackageVersion()}"),
            asyncAgents = listOf("OpenAIResponsesClientAsync/Java ${getPackageVersion()}"),
        )
    }

    @Test
    fun disablingTelemetryOmitsDefaultUserAgent() {
        checkRequests(true, null, emptyList(), emptyList())
    }

    @Test
    fun callerUserAgentSurvivesWithOrWithoutTelemetry() {
        for (disableTelemetry in listOf(false, true)) {
            checkRequests(disableTelemetry, "my-client", listOf("my-client"), listOf("my-client"))
        }
    }

    private fun checkRequests(
        disableTelemetry: Boolean,
        customAgent: String?,
        syncAgents: List<String>,
        asyncAgents: List<String>,
    ) {
        val transport = RecordingTransport()
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .baseUrl("https://example.test/v1")
                .apiKey("test-key")
                .putHeader("X-Client", "fixture")
                .disableTelemetry(disableTelemetry)
                .apply { customAgent?.let { putHeader("user-agent", it) } }
                .build()
        OpenAIResponsesClient(options).use { client ->
            client.responses().delete("resp_sync")
            client.async().responses().delete("resp_async").join()
        }
        assertEquals(1, transport.closes)
        assertEquals("https://example.test/v1/responses/resp_sync", transport.sync.url())
        assertEquals("https://example.test/v1/responses/resp_async", transport.async.url())
        assertEquals(syncAgents, transport.sync.headers.values("User-Agent"))
        assertEquals(asyncAgents, transport.async.headers.values("User-Agent"))
        for (request in listOf(transport.sync, transport.async)) {
            assertEquals(listOf("fixture"), request.headers.values("X-Client"))
            assertEquals(listOf("Bearer test-key"), request.headers.values("Authorization"))
        }
    }
}

internal class RecordingTransport : HttpClient {
    lateinit var sync: HttpRequest
    lateinit var async: HttpRequest
    var closes = 0

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        sync = request
        return response
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        async = request
        return CompletableFuture.completedFuture(response)
    }

    override fun close() {
        closes++
    }

    private val response =
        object : HttpResponse {
            override fun statusCode() = 200

            override fun headers() =
                Headers.builder().put("Content-Type", "application/json").build()

            override fun body() =
                """{"id":"resp_test","deleted":true,"object":"response.deleted"}"""
                    .byteInputStream()

            override fun close() {}
        }
}
