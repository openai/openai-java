package com.openai.core.http

import com.openai.core.ClientOptions
import com.openai.errors.NotFoundException
import com.openai.services.async.ResponseServiceAsyncImpl
import com.openai.services.blocking.ResponseServiceImpl
import java.io.ByteArrayInputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit.SECONDS
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class ResponseDeletionLifecycleTest {

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

    private fun delete(async: Boolean, retries: Int = 0) {
        if (async) {
            val result = ResponseServiceAsyncImpl(options(retries)).delete("resp_test")
            assertThat(result.get(5, SECONDS)).isNull()
        } else {
            ResponseServiceImpl(options(retries)).delete("resp_test")
        }
    }

    @ParameterizedTest
    @CsvSource("false, 200", "true, 200", "false, 204", "true, 204")
    fun successfulDeleteClosesResponseWithoutReadingBody(async: Boolean, status: Int) {
        val response = response(status, "ignored response body")
        returns(response)

        delete(async)

        verify(response).close()
        verify(response, never()).body()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun rawDeleteLeavesResponseOpenForCaller(async: Boolean) {
        val response = response(200)
        returns(response)

        val raw =
            if (async) {
                ResponseServiceAsyncImpl(options())
                    .withRawResponse()
                    .delete("resp_test")
                    .get(5, SECONDS)
            } else {
                ResponseServiceImpl(options()).withRawResponse().delete("resp_test")
            }

        verify(response, never()).close()
        raw.close()
        verify(response).close()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun deletePreservesApiErrorAndClosesResponse(async: Boolean) {
        val response = response(404, """{"error":{"message":"missing"}}""")
        returns(response)

        if (async) {
            val result = ResponseServiceAsyncImpl(options()).delete("resp_test")
            assertThatThrownBy { result.get(5, SECONDS) }
                .hasCauseInstanceOf(NotFoundException::class.java)
        } else {
            assertThatThrownBy { delete(false) }.isInstanceOf(NotFoundException::class.java)
        }
        verify(response).close()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun deleteClosesRetriedAndFinalResponses(async: Boolean) {
        val retry = response(429)
        val success = response(200)
        whenever(transport.execute(any(), any())).thenReturn(retry, success)
        whenever(transport.executeAsync(any(), any()))
            .thenReturn(
                CompletableFuture.completedFuture(retry),
                CompletableFuture.completedFuture(success),
            )

        delete(async, retries = 1)

        verify(retry).close()
        verify(success).close()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun deletePropagatesCloseFailure(async: Boolean) {
        val response = response(200)
        val failure = IllegalStateException("close failed")
        doThrow(failure).whenever(response).close()
        returns(response)

        if (async) {
            val result = ResponseServiceAsyncImpl(options()).delete("resp_test")
            assertThatThrownBy { result.get(5, SECONDS) }.hasCause(failure)
        } else {
            assertThatThrownBy { delete(false) }.isSameAs(failure)
        }
        verify(response).close()
    }

    @Test
    fun cancelledDeleteClosesResponseThatArrivesLater() {
        val pending = CompletableFuture<HttpResponse>()
        val started = CountDownLatch(1)
        whenever(transport.executeAsync(any(), any())).thenAnswer {
            started.countDown()
            pending
        }
        val result = ResponseServiceAsyncImpl(options()).delete("resp_test")
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
