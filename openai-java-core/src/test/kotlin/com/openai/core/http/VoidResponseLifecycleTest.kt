package com.openai.core.http

import com.openai.core.ClientOptions
import com.openai.errors.NotFoundException
import com.openai.services.async.ResponseServiceAsyncImpl
import com.openai.services.async.realtime.CallServiceAsyncImpl
import com.openai.services.blocking.ResponseServiceImpl
import com.openai.services.blocking.realtime.CallServiceImpl
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit.SECONDS
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class VoidResponseLifecycleTest {

    enum class Endpoint(
        val blocking: (ClientOptions) -> Unit,
        val async: (ClientOptions) -> CompletableFuture<Void?>,
        val rawBlocking: (ClientOptions) -> HttpResponse,
        val rawAsync: (ClientOptions) -> CompletableFuture<HttpResponse>,
    ) {
        RESPONSES_DELETE(
            { ResponseServiceImpl(it).delete("resp_test") },
            { ResponseServiceAsyncImpl(it).delete("resp_test") },
            { ResponseServiceImpl(it).withRawResponse().delete("resp_test") },
            { ResponseServiceAsyncImpl(it).withRawResponse().delete("resp_test") },
        ),
        REALTIME_HANGUP(
            { CallServiceImpl(it).hangup("call_test") },
            { CallServiceAsyncImpl(it).hangup("call_test") },
            { CallServiceImpl(it).withRawResponse().hangup("call_test") },
            { CallServiceAsyncImpl(it).withRawResponse().hangup("call_test") },
        ),
    }

    companion object {
        @JvmStatic
        fun endpointModes(): List<Arguments> =
            Endpoint.values().flatMap { endpoint ->
                listOf(Arguments.of(endpoint, false), Arguments.of(endpoint, true))
            }
    }

    private val transport = mock<HttpClient>()

    private fun options(retries: Int = 0) =
        ClientOptions.builder()
            .httpClient(transport)
            .apiKey("test-key")
            .baseUrl("https://example.test")
            .maxRetries(retries)
            .build()

    private fun response(status: Int, body: String = ""): HttpResponse =
        mock<HttpResponse>().also {
            whenever(it.statusCode()).thenReturn(status)
            whenever(it.headers()).thenReturn(Headers.builder().put("retry-after-ms", "1").build())
            whenever(it.body()).thenReturn(ByteArrayInputStream(body.toByteArray()))
        }

    private fun returns(response: HttpResponse) {
        whenever(transport.execute(any(), any())).thenReturn(response)
        whenever(transport.executeAsync(any(), any()))
            .thenReturn(CompletableFuture.completedFuture(response))
    }

    private fun call(endpoint: Endpoint, async: Boolean, retries: Int = 0) {
        if (async) {
            val result = endpoint.async(options(retries))
            assertThat(result.get(5, SECONDS)).isNull()
        } else {
            endpoint.blocking(options(retries))
        }
    }

    @ParameterizedTest
    @MethodSource("endpointModes")
    fun successClosesResponseWithoutReadingBody(endpoint: Endpoint, async: Boolean) {
        for (status in listOf(200, 204)) {
            val response = response(status, "ignored response body")
            returns(response)

            call(endpoint, async)

            verify(response).close()
            verify(response, never()).body()
        }
    }

    @ParameterizedTest
    @MethodSource("endpointModes")
    fun rawResponseRemainsOpenForCaller(endpoint: Endpoint, async: Boolean) {
        val response = response(200)
        returns(response)

        val raw =
            if (async) {
                endpoint.rawAsync(options()).get(5, SECONDS)
            } else {
                endpoint.rawBlocking(options())
            }

        verify(response, never()).close()
        raw.close()
        verify(response).close()
    }

    @ParameterizedTest
    @MethodSource("endpointModes")
    fun apiErrorClosesResponse(endpoint: Endpoint, async: Boolean) {
        val response = response(404, """{"error":{"message":"missing"}}""")
        returns(response)

        if (async) {
            val result = endpoint.async(options())
            assertThatThrownBy { result.get(5, SECONDS) }
                .hasCauseInstanceOf(NotFoundException::class.java)
        } else {
            assertThatThrownBy { call(endpoint, false) }.isInstanceOf(NotFoundException::class.java)
        }
        verify(response).close()
    }

    @ParameterizedTest
    @MethodSource("endpointModes")
    fun retryClosesRetriedAndFinalResponses(endpoint: Endpoint, async: Boolean) {
        val retry = response(429)
        val success = response(200)
        whenever(transport.execute(any(), any())).thenReturn(retry, success)
        whenever(transport.executeAsync(any(), any()))
            .thenReturn(
                CompletableFuture.completedFuture(retry),
                CompletableFuture.completedFuture(success),
            )

        call(endpoint, async, retries = 1)

        verify(retry).close()
        verify(success).close()
    }

    @ParameterizedTest
    @MethodSource("endpointModes")
    fun closeFailurePropagates(endpoint: Endpoint, async: Boolean) {
        val response = response(200)
        val failure = IllegalStateException("close failed")
        doThrow(failure).whenever(response).close()
        returns(response)

        if (async) {
            val result = endpoint.async(options())
            assertThatThrownBy { result.get(5, SECONDS) }.hasCause(failure)
        } else {
            assertThatThrownBy { call(endpoint, false) }.isSameAs(failure)
        }
        verify(response).close()
    }

    @ParameterizedTest
    @EnumSource(Endpoint::class)
    fun cancellationClosesResponseThatArrivesLater(endpoint: Endpoint) {
        val pending = CompletableFuture<HttpResponse>()
        val started = CountDownLatch(1)
        whenever(transport.executeAsync(any(), any())).thenAnswer {
            started.countDown()
            pending
        }
        val result = endpoint.async(options())
        assertThat(started.await(5, SECONDS)).isTrue()
        assertThat(result.cancel(true)).isTrue()
        val response = response(200)
        val closed = CountDownLatch(1)
        doAnswer { closed.countDown() }.whenever(response).close()

        assertThat(pending.complete(response)).isTrue()

        assertThat(closed.await(5, SECONDS)).isTrue()
        verify(response).close()
        verify(response, never()).body()
        assertThat(result.isCancelled).isTrue()
    }
}
