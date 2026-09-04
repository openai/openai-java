package com.openai.core

import com.openai.core.http.Headers
import com.openai.core.http.HttpResponse
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CancellableFutureTest {
    private class Response : HttpResponse {
        val closes = AtomicInteger()

        override fun statusCode() = 200

        override fun headers() = Headers.builder().build()

        override fun body() = "synthetic".byteInputStream()

        override fun close() {
            closes.incrementAndGet()
        }
    }

    @Test
    fun closesResponseWhenTransportCompletionWinsCancellationRace() {
        val response = Response()
        val source =
            object : CompletableFuture<HttpResponse>() {
                override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                    assertThat(complete(response)).isTrue()
                    return super.cancel(mayInterruptIfRunning)
                }
            }
        val result = CancellableFuture.wrap(source)
        assertThat(result.cancel(true)).isTrue()
        assertThat(source.isCancelled).isFalse()
        assertThat(result.isCancelled).isTrue()
        assertThat(response.closes.get()).isEqualTo(1)
    }

    @Test
    fun closesResponseCreatedByRunningStageAfterCancellation() {
        val response = Response()
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val executor = Executors.newSingleThreadExecutor()
        try {
            val result =
                CancellableFuture.wrap(CompletableFuture.completedFuture("ready"))
                    .thenApplyAsync(
                        {
                            entered.countDown()
                            check(release.await(5, TimeUnit.SECONDS))
                            response
                        },
                        executor,
                    )
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            release.countDown()
            executor.shutdown()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            assertThat(response.closes.get()).isEqualTo(1)
        } finally {
            release.countDown()
            executor.shutdownNow()
        }
    }

    @Test
    fun closesResponseDiscardedDuringRetryOutcomeHandoff() {
        val response = Response()
        val source = CompletableFuture<HttpResponse>()
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val executor = Executors.newSingleThreadExecutor()
        try {
            val result =
                CancellableFuture.wrap(source)
                    .handle(
                        { value, error ->
                            entered.countDown()
                            check(release.await(5, TimeUnit.SECONDS))
                            Pair(value, error)
                        },
                        { (value, _) -> value?.close() },
                    )
                    .thenCompose { (value, _) -> CompletableFuture.completedFuture(value) }
            executor.submit { source.complete(response) }
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            release.countDown()
            executor.shutdown()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            assertThat(response.closes.get()).isEqualTo(1)
        } finally {
            release.countDown()
            executor.shutdownNow()
        }
    }

    @Test
    fun closesResponseWhenQueuedCompositionIsCancelled() {
        val response = Response()
        var queued: Runnable? = null
        val result =
            CancellableFuture.wrap(CompletableFuture.completedFuture<HttpResponse>(response))
                .handle({ value, error -> Pair(value, error) }, { (value, _) -> value?.close() })
                .thenComposeAsync(
                    { (value, _) -> CompletableFuture.completedFuture(value) },
                    Executor { queued = it },
                )
        assertThat(result.cancel(true)).isTrue()
        checkNotNull(queued).run()
        assertThat(response.closes.get()).isEqualTo(1)
    }

    @Test
    fun deliveredResponseRemainsOwnedByCaller() {
        val response = Response()
        val result = CancellableFuture.wrap(CompletableFuture.completedFuture(response))
        assertThat(result.join()).isSameAs(response)
        assertThat(result.cancel(true)).isFalse()
        assertThat(response.closes.get()).isZero()
        response.close()
    }
}
