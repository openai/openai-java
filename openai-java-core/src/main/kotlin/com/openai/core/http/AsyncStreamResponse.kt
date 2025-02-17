package com.openai.core.http

import com.openai.core.http.AsyncStreamResponse.Handler
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicReference

interface AsyncStreamResponse<T> {

    fun subscribe(handler: Handler<T>): AsyncStreamResponse<T>

    fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T>

    /**
     * Closes this resource, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because this response should not be
     * synchronously closed via try-with-resources.
     */
    fun close()

    fun interface Handler<in T> {

        fun onNext(value: T)

        fun onComplete(error: Optional<Throwable>) {}
    }
}

@JvmSynthetic
internal fun <T> CompletableFuture<StreamResponse<T>>.toAsync(streamHandlerExecutor: Executor) =
    PhantomReachableClosingAsyncStreamResponse(
        object : AsyncStreamResponse<T> {

            private val state = AtomicReference(State.NEW)

            override fun subscribe(handler: Handler<T>): AsyncStreamResponse<T> =
                subscribe(handler, streamHandlerExecutor)

            override fun subscribe(
                handler: Handler<T>,
                executor: Executor,
            ): AsyncStreamResponse<T> = apply {
                // TODO(JDK): Use `compareAndExchange` once targeting JDK 9.
                check(state.compareAndSet(State.NEW, State.SUBSCRIBED)) {
                    if (state.get() == State.SUBSCRIBED) "Cannot subscribe more than once"
                    else "Cannot subscribe after the response is closed"
                }

                this@toAsync.whenCompleteAsync(
                    { streamResponse, futureError ->
                        if (state.get() == State.CLOSED) {
                            // Avoid doing any work if `close` was called before the future
                            // completed.
                            return@whenCompleteAsync
                        }

                        if (futureError != null) {
                            // An error occurred before we started passing chunks to the handler.
                            handler.onComplete(Optional.of(futureError))
                            return@whenCompleteAsync
                        }

                        var streamError: Throwable? = null
                        try {
                            streamResponse.stream().forEach(handler::onNext)
                        } catch (e: Throwable) {
                            streamError = e
                        }

                        try {
                            handler.onComplete(Optional.ofNullable(streamError))
                        } finally {
                            close()
                        }
                    },
                    executor,
                )
            }

            override fun close() {
                val previousState = state.getAndSet(State.CLOSED)
                if (previousState == State.CLOSED) {
                    return
                }

                this@toAsync.whenComplete { streamResponse, _ -> streamResponse?.close() }
            }
        }
    )

private enum class State {
    NEW,
    SUBSCRIBED,
    CLOSED,
}
