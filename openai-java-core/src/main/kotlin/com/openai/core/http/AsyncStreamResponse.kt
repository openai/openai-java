package com.openai.core.http

import com.openai.core.http.AsyncStreamResponse.Handler
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicReference

/**
 * A class providing access to an API response as an asynchronous stream of chunks of type [T],
 * where each chunk can be individually processed as soon as it arrives instead of waiting on the
 * full response.
 */
interface AsyncStreamResponse<T> {

    /**
     * Registers [handler] to be called for events of this stream.
     *
     * [handler]'s methods will be called in the client's configured or default thread pool.
     *
     * @throws IllegalStateException if [subscribe] has already been called.
     */
    fun subscribe(handler: Handler<T>): AsyncStreamResponse<T>

    /**
     * Registers [handler] to be called for events of this stream.
     *
     * [handler]'s methods will be called in the given [executor].
     *
     * @throws IllegalStateException if [subscribe] has already been called.
     */
    fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T>

    /**
     * Returns a future that completes when a stream is fully consumed, errors, or gets closed
     * early.
     */
    fun onCompleteFuture(): CompletableFuture<Void?>

    /**
     * Closes this resource, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because this response should not be
     * synchronously closed via try-with-resources.
     */
    fun close()

    /** A class for handling streaming events. */
    fun interface Handler<in T> {

        /** Called whenever a chunk is received. */
        fun onNext(value: T)

        /**
         * Called when a stream is fully consumed, errors, or gets closed early.
         *
         * [onNext] will not be called once this method is called.
         *
         * @param error Non-empty if the stream completed due to an error.
         */
        fun onComplete(error: Optional<Throwable>) {}
    }
}

@JvmSynthetic
internal fun <T> CompletableFuture<StreamResponse<T>>.toAsync(streamHandlerExecutor: Executor) =
    PhantomReachableClosingAsyncStreamResponse(
        object : AsyncStreamResponse<T> {

            private val onCompleteFuture = CompletableFuture<Void?>()
            private val state = AtomicReference(State.NEW)

            init {
                this@toAsync.whenComplete { _, error ->
                    // If an error occurs from the original future, then we should resolve the
                    // `onCompleteFuture` even if `subscribe` has not been called.
                    error?.let(onCompleteFuture::completeExceptionally)
                }
            }

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
                            try {
                                // Notify completion via the `onCompleteFuture` as well. This is in
                                // a separate `try-finally` block so that we still complete the
                                // future if `handler.onComplete` throws.
                                if (streamError == null) {
                                    onCompleteFuture.complete(null)
                                } else {
                                    onCompleteFuture.completeExceptionally(streamError)
                                }
                            } finally {
                                close()
                            }
                        }
                    },
                    executor,
                )
            }

            override fun onCompleteFuture(): CompletableFuture<Void?> = onCompleteFuture

            override fun close() {
                val previousState = state.getAndSet(State.CLOSED)
                if (previousState == State.CLOSED) {
                    return
                }

                this@toAsync.whenComplete { streamResponse, error -> streamResponse?.close() }
                // When the stream is closed, we should always consider it closed. If it closed due
                // to an error, then we will have already completed the future earlier, and this
                // will be a no-op.
                onCompleteFuture.complete(null)
            }
        }
    )

private enum class State {
    NEW,
    SUBSCRIBED,
    CLOSED,
}
