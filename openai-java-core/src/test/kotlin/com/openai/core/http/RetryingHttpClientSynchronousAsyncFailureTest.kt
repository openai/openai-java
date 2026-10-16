package com.openai.core.http

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.OpenAIRetryableException
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class RetryingHttpClientSynchronousAsyncFailureTest {

    private class RecordingSleeper : Sleeper {
        val durations = mutableListOf<Duration>()

        override fun sleep(duration: Duration) {
            durations.add(duration)
        }

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
            durations.add(duration)
            return CompletableFuture.completedFuture(null)
        }

        override fun close() {}
    }

    @ParameterizedTest
    @CsvSource("false, false", "false, true", "true, false", "true, true")
    fun executeAsync_retriesSynchronousRetryableFailure(
        authenticated: Boolean,
        ioFailure: Boolean,
    ) {
        val attempts = mutableListOf<Int>()
        var callCount = 0
        val success = response(200)
        val delegate =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("not used")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    callCount++
                    attempts.add(request.headers.values("X-Stainless-Retry-Count").single().toInt())
                    if (callCount == 1) {
                        if (ioFailure) throw IOException("synchronous I/O failure")
                        throw OpenAIRetryableException("retryable synchronous failure")
                    }
                    return CompletableFuture.completedFuture(success)
                }

                override fun close() {}
            }
        val sleeper = RecordingSleeper()
        val client = client(delegate, sleeper, 1, authenticated)

        val actual = client.executeAsync(request()).get()

        assertThat(actual).isSameAs(success)
        assertThat(callCount).isEqualTo(2)
        assertThat(attempts).containsExactly(0, 1)
        assertThat(sleeper.durations).hasSize(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun executeAsync_returnsFailedFutureForSynchronousNonRetryableFailure(authenticated: Boolean) {
        val failure = IllegalStateException("non-retryable synchronous failure")
        var callCount = 0
        val delegate =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("not used")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    callCount++
                    throw failure
                }

                override fun close() {}
            }
        val sleeper = RecordingSleeper()
        val client = client(delegate, sleeper, 2, authenticated)

        val call = runCatching { client.executeAsync(request()) }

        assertThat(call.isSuccess).isTrue()
        val thrown = assertThrows<ExecutionException> { call.getOrThrow().get() }
        assertThat(thrown.cause).isSameAs(failure)
        assertThat(callCount).isEqualTo(1)
        assertThat(sleeper.durations).isEmpty()
    }

    private fun client(
        delegate: HttpClient,
        sleeper: Sleeper,
        maxRetries: Int,
        authenticated: Boolean,
    ): HttpClient {
        if (!authenticated) {
            return RetryingHttpClient.builder()
                .httpClient(delegate)
                .sleeper(sleeper)
                .maxRetries(maxRetries)
                .build()
        }
        val authenticator = mock<HttpRequestAuthenticator>()
        whenever(authenticator.authenticateAsync(any())).thenAnswer {
            CompletableFuture.completedFuture(it.getArgument<HttpRequest>(0))
        }
        return ClientOptions.builder()
            .httpClient(delegate)
            .httpRequestAuthenticator(authenticator)
            .sleeper(sleeper)
            .maxRetries(maxRetries)
            .build()
            .httpClient
    }

    private fun request(): HttpRequest =
        HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://api.example.com").build()

    private fun response(statusCode: Int): HttpResponse =
        object : HttpResponse {
            override fun statusCode(): Int = statusCode

            override fun headers(): Headers = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

            override fun close() {}
        }
}
