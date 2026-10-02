package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.OpenAIRetryableException
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun executeAsync_retriesSynchronousRetryableFailure() {
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
                    attempts.add(
                        request.headers.values("X-Stainless-Retry-Count").single().toInt()
                    )
                    if (callCount == 1) {
                        throw OpenAIRetryableException("retryable synchronous failure")
                    }
                    return CompletableFuture.completedFuture(success)
                }

                override fun close() {}
            }
        val sleeper = RecordingSleeper()
        val client =
            RetryingHttpClient.builder()
                .httpClient(delegate)
                .sleeper(sleeper)
                .maxRetries(1)
                .build()

        val actual = client.executeAsync(request()).get()

        assertThat(actual).isSameAs(success)
        assertThat(callCount).isEqualTo(2)
        assertThat(attempts).containsExactly(0, 1)
        assertThat(sleeper.durations).hasSize(1)
    }

    @Test
    fun executeAsync_returnsFailedFutureForSynchronousNonRetryableFailure() {
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
        val client =
            RetryingHttpClient.builder()
                .httpClient(delegate)
                .sleeper(sleeper)
                .maxRetries(2)
                .build()

        val call = runCatching { client.executeAsync(request()) }

        assertThat(call.isSuccess).isTrue()
        val thrown = assertThrows<ExecutionException> { call.getOrThrow().get() }
        assertThat(thrown.cause).isSameAs(failure)
        assertThat(callCount).isEqualTo(1)
        assertThat(sleeper.durations).isEmpty()
    }

    private fun request(): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl("https://api.example.com")
            .build()

    private fun response(statusCode: Int): HttpResponse =
        object : HttpResponse {
            override fun statusCode(): Int = statusCode

            override fun headers(): Headers = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

            override fun close() {}
        }
}
