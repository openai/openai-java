package com.openai.core

import com.openai.client.OpenAIClientImpl
import com.openai.core.http.DelegatingHttpResponse
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.LoggingHttpClient
import com.openai.core.http.multipartFormData
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FilePurpose
import com.openai.models.models.Model
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
import java.util.concurrent.atomic.AtomicReference
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
        runCatching { result.join() }
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
        val closeCalls = AtomicInteger()
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
                    closeCalls.incrementAndGet()
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
            // Non-async model parsing runs on the delivery thread; enroll before delivery.
            val delivery = executor.submit { delivered.complete(response) }
            assertThat(reading.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(isClosed.get()).isTrue()
            assertThat(result.isCancelled).isTrue()
            delivery.get(5, TimeUnit.SECONDS)
            assertThat(closeCalls.get()).isEqualTo(1)
        } finally {
            if (!isClosed.get()) response.close()
            executor.shutdownNow()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            sdk.close()
        }
    }

    @Test
    fun cancellingPublicRawModelParserClosesResponseExactlyOnce() {
        val reading = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val closes = AtomicInteger()
        val response =
            object : HttpResponse {
                override fun statusCode() = 200

                override fun headers() =
                    Headers.builder().put("Content-Type", "application/json").build()

                override fun body(): InputStream =
                    object : InputStream() {
                        override fun read(): Int {
                            reading.countDown()
                            check(closed.await(5, TimeUnit.SECONDS))
                            throw IOException("synthetic response closed")
                        }
                    }

                override fun close() {
                    closes.incrementAndGet()
                    closed.countDown()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous request")

                override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
                    CompletableFuture.completedFuture<HttpResponse>(response)

                override fun close() {}
            }
        val sdk =
            OpenAIClientImpl(
                ClientOptions.builder().apiKey("synthetic-key").httpClient(transport).build()
            )
        val executor = Executors.newSingleThreadExecutor()
        try {
            val raw =
                sdk.async()
                    .models()
                    .withRawResponse()
                    .retrieve("synthetic-model")
                    .get(5, TimeUnit.SECONDS)
            val pending = CompletableFuture<HttpResponseFor<Model>>()
            val result = CancellableFuture.wrap(pending).thenApply { it.parse() }
            val delivery = executor.submit { pending.complete(raw) }
            assertThat(reading.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            delivery.get(5, TimeUnit.SECONDS)
            assertThat(closes.get()).isEqualTo(1)
        } finally {
            closed.countDown()
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
    fun containsSourceCancellationExceptionAndRunsCleanup() {
        val cleaned = AtomicBoolean()
        val source =
            object : CompletableFuture<HttpResponse>() {
                override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                    throw IOException("synthetic transport cleanup failure")
                }
            }
        val result = CancellableFuture.wrap(source) { cleaned.set(true) }
        assertThat(result.cancel(true)).isTrue()
        assertThat(result.isCancelled).isTrue()
        assertThat(cleaned.get()).isTrue()
    }

    @Test
    fun cancellingPublicModelRequestContainsTransportCancellationException() {
        val cancellationCalls = AtomicInteger()
        val dispatched = CountDownLatch(1)
        val pending =
            object : CompletableFuture<HttpResponse>() {
                override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                    cancellationCalls.incrementAndGet()
                    throw IOException("synthetic transport cleanup failure")
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous request")

                override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
                    pending.also { dispatched.countDown() }

                override fun close() {}
            }
        val sdk =
            OpenAIClientImpl(
                ClientOptions.builder().apiKey("synthetic-key").httpClient(transport).build()
            )
        try {
            val result = sdk.async().models().retrieve("synthetic-model")
            assertThat(dispatched.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(result.isCancelled).isTrue()
            val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
            while (cancellationCalls.get() == 0 && System.nanoTime() < deadline) Thread.sleep(1)
            assertThat(cancellationCalls.get()).isEqualTo(1)
        } finally {
            sdk.close()
        }
    }

    @Test
    fun propagatesFatalSourceCancellationError() {
        val source =
            object : CompletableFuture<HttpResponse>() {
                override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                    throw LinkageError("synthetic fatal transport failure")
                }
            }
        val result = CancellableFuture.wrap(source)
        assertThrows<LinkageError> { result.cancel(true) }
        assertThat(result.isCancelled).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["handle", "handleAsync", "handleAsyncExecutor"])
    fun cancellationClosesResponseWhileHandleIsReadingHeadersExactlyOnce(stage: String) {
        val response =
            object : HttpResponse {
                val entered = CountDownLatch(1)
                val closed = CountDownLatch(1)
                val closes = AtomicInteger()

                override fun statusCode(): Int {
                    entered.countDown()
                    check(closed.await(5, TimeUnit.SECONDS))
                    return 200
                }

                override fun headers() = Headers.builder().build()

                override fun body() = "synthetic".byteInputStream()

                override fun close() {
                    closes.incrementAndGet()
                    closed.countDown()
                }
            }
        val executor = Executors.newSingleThreadExecutor()
        try {
            val pending = CompletableFuture<HttpResponse>()
            val source = CancellableFuture.wrap(pending)
            val read =
                java.util.function.BiFunction<HttpResponse?, Throwable?, HttpResponse> { value, _ ->
                    checkNotNull(value).also { it.statusCode() }
                }
            val result =
                when (stage) {
                    "handle" -> source.handle(read)
                    "handleAsync" -> source.handleAsync(read)
                    else -> source.handleAsync(read, executor)
                }
            val delivery = executor.submit { pending.complete(response) }
            assertThat(response.entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(response.closed.await(5, TimeUnit.SECONDS)).isTrue()
            delivery.get(5, TimeUnit.SECONDS)
            executor.shutdown()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            assertThat(response.closes.get()).isEqualTo(1)
        } finally {
            response.closed.countDown()
            executor.shutdownNow()
        }
    }

    @Test
    fun nonAsyncStagesPreserveCallerAndCompletionThreadContext() {
        val context = ThreadLocal<String>()
        val pending = CompletableFuture<String>()
        val source = CancellableFuture.wrap(pending)
        val seen = mutableListOf<String?>()
        context.set("attaching")
        try {
            val completed = CancellableFuture.wrap(CompletableFuture.completedFuture("ready"))
            val immediate =
                completed
                    .thenApply {
                        seen += context.get()
                        it
                    }
                    .handle { value, _ ->
                        seen += context.get()
                        value
                    }
            val immediateDiscard =
                completed.handle(
                    { value, _ ->
                        seen += context.get()
                        value
                    },
                    { _: String? -> },
                )
            assertThat(immediate.join()).isEqualTo("ready")
            assertThat(immediateDiscard.join()).isEqualTo("ready")
            assertThat(seen).containsExactly("attaching", "attaching", "attaching")

            val applied =
                source.thenApply {
                    seen += context.get()
                    it
                }
            val handled =
                source.handle { value, _ ->
                    seen += context.get()
                    value
                }
            val discarded =
                source.handle(
                    { value, _ ->
                        seen += context.get()
                        value
                    },
                    { _: String? -> },
                )
            val executor = Executors.newSingleThreadExecutor()
            try {
                executor
                    .submit {
                        context.set("delivering")
                        try {
                            pending.complete("delivered")
                        } finally {
                            context.remove()
                        }
                    }
                    .get(5, TimeUnit.SECONDS)
                assertThat(applied.join()).isEqualTo("delivered")
                assertThat(handled.join()).isEqualTo("delivered")
                assertThat(discarded.join()).isEqualTo("delivered")
                assertThat(seen.drop(3)).containsExactly("delivering", "delivering", "delivering")
            } finally {
                executor.shutdownNow()
            }
        } finally {
            context.remove()
        }
    }

    @Test
    fun cancellingPublicRequestClosesResponseDuringLoggingHeaderRead() {
        val entered = CountDownLatch(1)
        val closed = CountDownLatch(1)
        val closes = AtomicInteger()
        val response =
            object : HttpResponse {
                override fun statusCode() = 200

                override fun headers(): Headers {
                    entered.countDown()
                    check(closed.await(5, TimeUnit.SECONDS))
                    return Headers.builder().build()
                }

                override fun body() = "synthetic".byteInputStream()

                override fun close() {
                    closes.incrementAndGet()
                    closed.countDown()
                }
            }
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected synchronous request")

                override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
                    CompletableFuture.completedFuture<HttpResponse>(response)

                override fun close() {}
            }
        val logging = LoggingHttpClient.builder().httpClient(transport).level(LogLevel.INFO).build()
        val sdk =
            OpenAIClientImpl(
                ClientOptions.builder().apiKey("synthetic-key").httpClient(logging).build()
            )
        try {
            val result = sdk.async().models().retrieve("synthetic-model")
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            assertThat(closed.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.isCancelled).isTrue()
            assertThat(closes.get()).isEqualTo(1)
        } finally {
            closed.countDown()
            sdk.close()
        }
    }

    @Test
    fun cancellationClosesDistinctResponseReturnedByRunningHandle() {
        val input = Response()
        val output = Response()
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val executor = Executors.newSingleThreadExecutor()
        try {
            val result =
                CancellableFuture.wrap(CompletableFuture.completedFuture<HttpResponse>(input))
                    .handleAsync(
                        { _, _ ->
                            entered.countDown()
                            check(release.await(5, TimeUnit.SECONDS))
                            output
                        },
                        executor,
                    )
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            release.countDown()
            executor.shutdown()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            assertThat(input.closes.get()).isEqualTo(1)
            assertThat(output.closes.get()).isEqualTo(1)
        } finally {
            release.countDown()
            executor.shutdownNow()
        }
    }

    @Test
    fun cancellationDoesNotCloseLoggingWrapperOfDiscardedInputTwice() {
        val input = Response()
        val wrapper =
            object : HttpResponse, DelegatingHttpResponse {
                override val wrappedResponse: HttpResponse = input

                override fun statusCode() = input.statusCode()

                override fun headers() = input.headers()

                override fun body() = input.body()

                override fun close() = input.close()
            }
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val executor = Executors.newSingleThreadExecutor()
        try {
            val result =
                CancellableFuture.wrap(CompletableFuture.completedFuture<HttpResponse>(input))
                    .handleAsync(
                        { _, _ ->
                            entered.countDown()
                            check(release.await(5, TimeUnit.SECONDS))
                            wrapper
                        },
                        executor,
                    )
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            release.countDown()
            executor.shutdown()
            assertThat(executor.awaitTermination(5, TimeUnit.SECONDS)).isTrue()
            assertThat(input.closes.get()).isEqualTo(1)
        } finally {
            release.countDown()
            executor.shutdownNow()
        }
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
        val queued = AtomicReference<Runnable?>()
        val result =
            CancellableFuture.wrap(CompletableFuture.completedFuture<HttpResponse>(response))
                .handle({ value, error -> Pair(value, error) }, { (value, _) -> value?.close() })
                .thenComposeAsync(
                    { (value, _) -> CompletableFuture.completedFuture(value) },
                    Executor { queued.set(it) },
                )
        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
        while (queued.get() == null && System.nanoTime() < deadline) Thread.sleep(1)
        assertThat(result.cancel(true)).isTrue()
        checkNotNull(queued.get()).run()
        assertThat(response.closes.get()).isEqualTo(1)
    }

    @Test
    fun cancellingActiveCompositionDiscardsSharedInputAndOutputOnce() {
        val response = Response()
        val source = CompletableFuture<HttpResponse>()
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val closed = AtomicBoolean()
        val closeOnce: (HttpResponse) -> Unit = {
            if (closed.compareAndSet(false, true)) it.close()
        }
        val executor = Executors.newSingleThreadExecutor()
        try {
            val result =
                CancellableFuture.wrap(source)
                    .thenCompose(
                        { value ->
                            entered.countDown()
                            check(release.await(5, TimeUnit.SECONDS))
                            CompletableFuture.completedFuture(value)
                        },
                        closeOnce,
                        closeOnce,
                    )
            val delivery = executor.submit { source.complete(response) }
            assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()
            release.countDown()
            delivery.get(5, TimeUnit.SECONDS)
            assertThat(response.closes.get()).isEqualTo(1)
        } finally {
            release.countDown()
            executor.shutdownNow()
        }
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
