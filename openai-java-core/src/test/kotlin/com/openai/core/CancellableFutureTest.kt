package com.openai.core

import com.openai.client.OpenAIClientImpl
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.multipartFormData
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FilePurpose
import java.io.FilterInputStream
import java.io.IOException
import java.io.InputStream
import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    private fun completedChain(
        completion: Int,
        queue: ReferenceQueue<CompletableFuture<String>>,
    ): Pair<CompletableFuture<String>, WeakReference<CompletableFuture<String>>> {
        val source = CompletableFuture<String>()
        val reference = WeakReference(source, queue)
        val result =
            CancellableFuture.wrap(source)
                .thenCompose { CompletableFuture.completedFuture(it) }
                .handle { _, _ -> "finished" }
        when (completion) {
            0 -> source.complete("synthetic request payload")
            1 -> source.completeExceptionally(IllegalStateException("synthetic failure"))
            2 -> result.complete("finished")
            3 -> result.completeExceptionally(IllegalStateException("manual failure"))
        }
        return Pair(result, reference)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun completedChainReleasesCancellationTargets(completion: Int) {
        val queue = ReferenceQueue<CompletableFuture<String>>()
        val (result, reference) = completedChain(completion, queue)
        assertThat(result.isDone).isTrue()
        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
        var collected = false
        while (!collected && System.nanoTime() < deadline) {
            System.gc()
            collected = queue.remove(100) === reference
        }
        assertThat(collected).isTrue()
        assertThat(result.isDone).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cancellingPublicModelReadClosesRunningResponseBody(closeThrows: Boolean) {
        val reading = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val delivered = CompletableFuture<HttpResponse>()
        val isClosed = AtomicBoolean()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous request")

                override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
                    delivered

                override fun close() {}
            }
        val response =
            object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body() =
                    object : InputStream() {
                        override fun read(): Int {
                            reading.countDown()
                            check(closed.await(5, TimeUnit.SECONDS))
                            throw IOException("synthetic response closed")
                        }
                    }

                override fun close() {
                    if (isClosed.compareAndSet(false, true)) {
                        closed.countDown()
                        if (closeThrows) throw IOException("synthetic close failure")
                    }
                }
            }
        val sdk =
            OpenAIClientImpl(
                ClientOptions.builder().apiKey("synthetic-key").httpClient(transport).build()
            )
        val executor = Executors.newSingleThreadExecutor()
        try {
            val result = sdk.async().models().retrieve("synthetic-model")
            val delivery = executor.submit { delivered.complete(response) }
            assertThat(reading.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(isClosed.get()).isTrue()
            assertThat(result.isCancelled).isTrue()
            delivery.get(5, TimeUnit.SECONDS)
        } finally {
            response.close()
            executor.shutdownNow()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            sdk.close()
        }
    }

    @Test
    fun cancellingQueuedMultipartDispatchClosesUpload() {
        val closes = AtomicInteger()
        val dispatched = AtomicInteger()
        val upload =
            object : FilterInputStream("synthetic upload".byteInputStream()) {
                override fun close() {
                    closes.incrementAndGet()
                    super.close()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous dispatch")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    dispatched.incrementAndGet()
                    return CompletableFuture.completedFuture(Response())
                }

                override fun close() {}
            }
        val options = ClientOptions.builder().apiKey("synthetic-key").httpClient(transport).build()
        val params = FileCreateParams.builder().file(upload).purpose(FilePurpose.ASSISTANTS).build()
        var queued: Runnable? = null
        try {
            // The generated upload service prepares this request before queuing its HTTP dispatch.
            val result =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(options.baseUrl())
                    .addPathSegments("files")
                    .body(multipartFormData(options.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(options, params)
                    .thenComposeAsync(
                        { options.httpClient.executeAsync(it, RequestOptions.none()) },
                        Executor { queued = it },
                    )
            assertThat(result.cancel(true)).isTrue()
            checkNotNull(queued).run()
            assertThat(dispatched.get()).isZero()
            assertThat(closes.get()).isEqualTo(1)
        } finally {
            options.httpClient.close()
            if (closes.get() == 0) upload.close()
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
