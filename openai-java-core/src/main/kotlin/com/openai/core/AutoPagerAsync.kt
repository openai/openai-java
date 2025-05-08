// File generated from our OpenAPI spec by Stainless.

package com.openai.core

import com.openai.core.http.AsyncStreamResponse
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicReference

class AutoPagerAsync<T>
private constructor(private val firstPage: PageAsync<T>, private val defaultExecutor: Executor) :
    AsyncStreamResponse<T> {

    companion object {

        fun <T> from(firstPage: PageAsync<T>, defaultExecutor: Executor): AutoPagerAsync<T> =
            AutoPagerAsync(firstPage, defaultExecutor)
    }

    private val onCompleteFuture = CompletableFuture<Void?>()
    private val state = AtomicReference(State.NEW)

    override fun subscribe(handler: AsyncStreamResponse.Handler<T>): AsyncStreamResponse<T> =
        subscribe(handler, defaultExecutor)

    override fun subscribe(
        handler: AsyncStreamResponse.Handler<T>,
        executor: Executor,
    ): AsyncStreamResponse<T> = apply {
        // TODO(JDK): Use `compareAndExchange` once targeting JDK 9.
        check(state.compareAndSet(State.NEW, State.SUBSCRIBED)) {
            if (state.get() == State.SUBSCRIBED) "Cannot subscribe more than once"
            else "Cannot subscribe after the response is closed"
        }

        fun PageAsync<T>.handle(): CompletableFuture<Void?> {
            if (state.get() == State.CLOSED) {
                return CompletableFuture.completedFuture(null)
            }

            items().forEach { handler.onNext(it) }
            return if (hasNextPage()) nextPage().thenCompose { it.handle() }
            else CompletableFuture.completedFuture(null)
        }

        executor.execute {
            firstPage.handle().whenComplete { _, error ->
                val actualError =
                    if (error is CompletionException && error.cause != null) error.cause else error
                try {
                    handler.onComplete(Optional.ofNullable(actualError))
                } finally {
                    try {
                        if (actualError == null) {
                            onCompleteFuture.complete(null)
                        } else {
                            onCompleteFuture.completeExceptionally(actualError)
                        }
                    } finally {
                        close()
                    }
                }
            }
        }
    }

    override fun onCompleteFuture(): CompletableFuture<Void?> = onCompleteFuture

    override fun close() {
        val previousState = state.getAndSet(State.CLOSED)
        if (previousState == State.CLOSED) {
            return
        }

        // When the stream is closed, we should always consider it closed. If it closed due
        // to an error, then we will have already completed the future earlier, and this
        // will be a no-op.
        onCompleteFuture.complete(null)
    }
}

private enum class State {
    NEW,
    SUBSCRIBED,
    CLOSED,
}
