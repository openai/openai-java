package com.openai.core.http

import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.stream.Stream
import kotlin.streams.asStream
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*

@ExtendWith(MockitoExtension::class)
internal class AsyncStreamResponseTest {

    companion object {
        private val ERROR = RuntimeException("ERROR!")
    }

    private val streamResponse =
        spy<StreamResponse<String>> {
            doReturn(Stream.of("chunk1", "chunk2", "chunk3")).whenever(it).stream()
        }
    private val erroringStreamResponse =
        spy<StreamResponse<String>> {
            doReturn(
                    sequence {
                            yield("chunk1")
                            yield("chunk2")
                            throw ERROR
                        }
                        .asStream()
                )
                .whenever(it)
                .stream()
        }
    private val executor =
        spy<Executor> {
            doAnswer { invocation -> invocation.getArgument<Runnable>(0).run() }
                .whenever(it)
                .execute(any())
        }
    private val handler = mock<AsyncStreamResponse.Handler<String>>()

    @Test
    fun subscribe_whenAlreadySubscribed_throws() {
        val asyncStreamResponse = CompletableFuture<StreamResponse<String>>().toAsync(executor)
        asyncStreamResponse.subscribe {}

        val throwable = catchThrowable { asyncStreamResponse.subscribe {} }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
        assertThat(throwable).hasMessage("Cannot subscribe more than once")
        verify(executor, never()).execute(any())
    }

    @Test
    fun subscribe_whenClosed_throws() {
        val asyncStreamResponse = CompletableFuture<StreamResponse<String>>().toAsync(executor)
        asyncStreamResponse.close()

        val throwable = catchThrowable { asyncStreamResponse.subscribe {} }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
        assertThat(throwable).hasMessage("Cannot subscribe after the response is closed")
        verify(executor, never()).execute(any())
    }

    @Test
    fun subscribe_whenFutureCompletesAfterClose_doesNothing() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(handler)
        asyncStreamResponse.close()

        future.complete(streamResponse)

        verify(handler, never()).onNext(any())
        verify(handler, never()).onComplete(any())
        verify(executor, times(1)).execute(any())
    }

    @Test
    fun subscribe_whenFutureErrors_callsOnComplete() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(handler)

        future.completeExceptionally(ERROR)

        verify(handler, never()).onNext(any())
        verify(handler, times(1)).onComplete(Optional.of(ERROR))
        verify(executor, times(1)).execute(any())
    }

    @Test
    fun subscribe_whenFutureCompletes_runsHandler() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(handler)

        future.complete(streamResponse)

        inOrder(handler, streamResponse) {
            verify(handler, times(1)).onNext("chunk1")
            verify(handler, times(1)).onNext("chunk2")
            verify(handler, times(1)).onNext("chunk3")
            verify(handler, times(1)).onComplete(Optional.empty())
            verify(streamResponse, times(1)).close()
        }
        verify(executor, times(1)).execute(any())
    }

    @Test
    fun subscribe_whenStreamErrors_callsOnCompleteEarly() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(handler)

        future.complete(erroringStreamResponse)

        inOrder(handler, erroringStreamResponse) {
            verify(handler, times(1)).onNext("chunk1")
            verify(handler, times(1)).onNext("chunk2")
            verify(handler, times(1)).onComplete(Optional.of(ERROR))
            verify(erroringStreamResponse, times(1)).close()
        }
        verify(executor, times(1)).execute(any())
    }

    @Test
    fun onCompleteFuture_whenStreamResponseFutureNotCompleted_onCompleteFutureNotCompleted() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isNotCompleted
    }

    @Test
    fun onCompleteFuture_whenStreamResponseFutureErrors_onCompleteFutureCompletedExceptionally() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        future.completeExceptionally(ERROR)

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isCompletedExceptionally
    }

    @Test
    fun onCompleteFuture_whenStreamResponseFutureCompletedButStillStreaming_onCompleteFutureNotCompleted() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        future.complete(streamResponse)

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isNotCompleted
    }

    @Test
    fun onCompleteFuture_whenStreamResponseFutureCompletedAndStreamErrors_onCompleteFutureCompletedExceptionally() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(handler)
        future.complete(erroringStreamResponse)

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isCompletedExceptionally
    }

    @Test
    fun onCompleteFuture_whenStreamResponseFutureCompletedAndStreamCompleted_onCompleteFutureCompleted() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(handler)
        future.complete(streamResponse)

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isCompleted
    }

    @Test
    fun onCompleteFuture_whenHandlerOnCompleteWithoutThrowableThrows_onCompleteFutureCompleted() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(
            object : AsyncStreamResponse.Handler<String> {
                override fun onNext(value: String) {}

                override fun onComplete(error: Optional<Throwable>) = throw ERROR
            }
        )
        future.complete(streamResponse)

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isCompleted
    }

    @Test
    fun onCompleteFuture_whenHandlerOnCompleteWithThrowableThrows_onCompleteFutureCompletedExceptionally() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.subscribe(
            object : AsyncStreamResponse.Handler<String> {
                override fun onNext(value: String) {}

                override fun onComplete(error: Optional<Throwable>) = throw ERROR
            }
        )
        future.complete(erroringStreamResponse)

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isCompletedExceptionally
    }

    @Test
    fun onCompleteFuture_whenClosed_onCompleteFutureCompleted() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.close()

        val onCompletableFuture = asyncStreamResponse.onCompleteFuture()

        assertThat(onCompletableFuture).isCompleted
    }

    @Test
    fun close_whenNotClosed_closesStreamResponse() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)

        asyncStreamResponse.close()
        future.complete(streamResponse)

        verify(streamResponse, times(1)).close()
    }

    @Test
    fun close_whenAlreadyClosed_doesNothing() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.close()
        future.complete(streamResponse)

        asyncStreamResponse.close()

        verify(streamResponse, times(1)).close()
    }

    @Test
    fun close_whenFutureErrors_doesNothing() {
        val future = CompletableFuture<StreamResponse<String>>()
        val asyncStreamResponse = future.toAsync(executor)
        asyncStreamResponse.close()

        assertDoesNotThrow { future.completeExceptionally(ERROR) }
    }
}
