package com.openai.client.okhttp

import com.openai.client.OpenAIClientAsync
import com.openai.client.OpenAIClientAsyncImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionCreateParams
import java.util.Optional
import java.util.concurrent.AbstractExecutorService
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AsyncRequestDispatchTest {
    private val context = ThreadLocal<String>()

    @Test fun asyncClientPreservesEachCallersContext() = verifyRequestDispatch(false)

    @Test fun syncClientAsyncViewPreservesEachCallersContext() = verifyRequestDispatch(true)

    private fun verifyRequestDispatch(fromSyncClient: Boolean) {
        val releaseResponse = CountDownLatch(1)
        val server =
            server(
                releaseResponse,
                """{"id":"model-test","object":"model","created":0,"owned_by":"test"}""",
            )
        val dispatcher = ContextExecutor("request-dispatcher", context)
        val client: OpenAIClientAsync =
            if (fromSyncClient) {
                OpenAIOkHttpClient.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/").toString())
                    .dispatcherExecutorService(dispatcher)
                    .maxRetries(0)
                    .build()
                    .async()
            } else {
                OpenAIOkHttpClientAsync.builder()
                    .apiKey("test-key")
                    .baseUrl(server.url("/").toString())
                    .dispatcherExecutorService(dispatcher)
                    .maxRetries(0)
                    .build()
            }
        try {
            context.set("first-request")
            val first = client.models().retrieve("model-test")
            context.set("second-request")
            val second = client.models().withRawResponse().retrieve("model-test")
            context.remove()

            assertThat(first.isDone).isFalse()
            assertThat(second.isDone).isFalse()
            releaseResponse.countDown()
            assertThat(first.get(5, TimeUnit.SECONDS).id()).isEqualTo("model-test")
            second.get(5, TimeUnit.SECONDS).use { response ->
                assertThat(response.parse().id()).isEqualTo("model-test")
            }
            assertThat(dispatcher.submissions)
                .containsExactlyInAnyOrder("first-request", "second-request")
        } finally {
            context.remove()
            releaseResponse.countDown()
            client.close()
            server.shutdown()
        }
    }

    @Test fun streamingCallbacksUseConfiguredContextExecutor() = verifyStreamingCallbacks(false)

    @Test fun streamingCallbacksUseExplicitContextExecutor() = verifyStreamingCallbacks(true)

    private fun verifyStreamingCallbacks(explicitExecutor: Boolean) {
        val releaseResponse = CountDownLatch(1)
        val body =
            "data: {\"id\":\"chunk-test\",\"object\":\"chat.completion.chunk\",\"created\":0,\"model\":\"model-test\",\"choices\":[{\"index\":0,\"delta\":{\"content\":\"hello\"},\"finish_reason\":null}]}\n\ndata: [DONE]\n\n"
        val server = server(releaseResponse, body)
        val dispatcher = ContextExecutor("request-dispatcher", context)
        val configured = ContextExecutor("configured-callback", context)
        val explicit = ContextExecutor("explicit-callback", context)
        val selected = if (explicitExecutor) explicit else configured
        val client =
            OpenAIOkHttpClientAsync.builder()
                .apiKey("test-key")
                .baseUrl(server.url("/").toString())
                .dispatcherExecutorService(dispatcher)
                .streamHandlerExecutor(configured)
                .maxRetries(0)
                .build()
        val observed = CopyOnWriteArrayList<Pair<String?, String>>()
        val content = CopyOnWriteArrayList<String>()
        val errors = CopyOnWriteArrayList<Throwable>()
        try {
            context.set("stream-request")
            val stream =
                client
                    .chat()
                    .completions()
                    .createStreaming(
                        ChatCompletionCreateParams.builder()
                            .model("model-test")
                            .addUserMessage("hello")
                            .build()
                    )
            val handler =
                object : AsyncStreamResponse.Handler<ChatCompletionChunk> {
                    override fun onNext(value: ChatCompletionChunk) {
                        observed.add(context.get() to Thread.currentThread().name)
                        content.add(value.choices().single().delta().content().orElse(""))
                    }

                    override fun onComplete(error: Optional<Throwable>) {
                        observed.add(context.get() to Thread.currentThread().name)
                        error.ifPresent(errors::add)
                    }
                }
            if (explicitExecutor) stream.subscribe(handler, explicit) else stream.subscribe(handler)
            context.remove()
            assertThat(stream.onCompleteFuture().isDone).isFalse()
            releaseResponse.countDown()
            stream.onCompleteFuture().get(5, TimeUnit.SECONDS)

            assertThat(errors).isEmpty()
            assertThat(content).containsExactly("hello")
            assertThat(observed)
                .containsExactly(
                    "stream-request" to selected.threadName,
                    "stream-request" to selected.threadName,
                )
            assertThat(dispatcher.submissions).containsExactly("stream-request")
            assertThat(selected.submissions).containsExactly("stream-request")
            if (explicitExecutor) assertThat(configured.submissions).isEmpty()
        } finally {
            context.remove()
            releaseResponse.countDown()
            client.close()
            explicit.shutdownNow()
            server.shutdown()
        }
    }

    @Test fun synchronousTransportFailureRemainsAnExceptionalFuture() = verifyTransportFailure(true)

    @Test fun failedTransportFutureIsPropagated() = verifyTransportFailure(false)

    private fun verifyTransportFailure(throwsSynchronously: Boolean) {
        val failure = IllegalStateException("test transport failure")
        val caller = Thread.currentThread()
        val dispatchedOn = CompletableFuture<Thread>()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("The synchronous transport must not be called")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> {
                    dispatchedOn.complete(Thread.currentThread())
                    if (throwsSynchronously) throw failure
                    return CompletableFuture<HttpResponse>().also {
                        it.completeExceptionally(failure)
                    }
                }

                override fun close() {}
            }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder()
                    .httpClient(transport)
                    .apiKey("test-key")
                    .maxRetries(0)
                    .build()
            )
        try {
            val future = client.models().retrieve("model-test")
            val error = assertThrows<ExecutionException> { future.get(5, TimeUnit.SECONDS) }
            assertThat(error.cause).isSameAs(failure)
            assertThat(dispatchedOn.get(5, TimeUnit.SECONDS)).isSameAs(caller)
        } finally {
            client.close()
        }
    }

    private fun server(releaseResponse: CountDownLatch, body: String): MockWebServer =
        MockWebServer().apply {
            dispatcher =
                object : Dispatcher() {
                    override fun dispatch(request: RecordedRequest): MockResponse {
                        check(releaseResponse.await(5, TimeUnit.SECONDS))
                        return MockResponse()
                            .setHeader(
                                "Content-Type",
                                if (body.startsWith("data:")) "text/event-stream"
                                else "application/json",
                            )
                            .setBody(body)
                    }
                }
            start()
        }
}

// Model an executor that captures application context at submission, as managed executors do.
private class ContextExecutor(val threadName: String, private val context: ThreadLocal<String>) :
    AbstractExecutorService() {
    private val delegate = Executors.newSingleThreadExecutor { Thread(it, threadName) }
    val submissions = CopyOnWriteArrayList<String?>()

    override fun execute(command: Runnable) {
        val captured = context.get()
        submissions.add(captured)
        delegate.execute {
            val previous = context.get()
            try {
                context.set(captured)
                command.run()
            } finally {
                if (previous == null) context.remove() else context.set(previous)
            }
        }
    }

    override fun shutdown() = delegate.shutdown()

    override fun shutdownNow(): MutableList<Runnable> = delegate.shutdownNow()

    override fun isShutdown(): Boolean = delegate.isShutdown

    override fun isTerminated(): Boolean = delegate.isTerminated

    override fun awaitTermination(timeout: Long, unit: TimeUnit): Boolean =
        delegate.awaitTermination(timeout, unit)
}
