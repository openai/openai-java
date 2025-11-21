package com.openai.core

import com.openai.core.http.CancellationToken
import com.openai.core.http.CancellationTokenSource
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.function.BiConsumer
import java.util.function.BiFunction
import java.util.function.Consumer
import java.util.function.Function

/**
 * A [CompletableFuture] that supports cancellation via a [CancellationToken].
 *
 * When [cancel] is called, this future will:
 * 1. Request cancellation via the associated [CancellationToken]
 * 2. Complete exceptionally with a [java.util.concurrent.CancellationException]
 * 3. Allow the underlying operation to clean up resources via the token's callbacks
 *
 * @param T the result type
 */
class CancellableCompletableFuture<T>
private constructor(
    private val cancellationTokenSource: CancellationTokenSource,
    private val delegate: CompletableFuture<T>
) : CompletableFuture<T>() {

    init {
        // Forward completion from delegate to this future
        delegate.whenComplete { result, error ->
            if (error != null) {
                this.completeExceptionally(error)
            } else {
                this.complete(result)
            }
        }
    }

    /**
     * Returns the [CancellationToken] associated with this future.
     */
    fun cancellationToken(): CancellationToken = cancellationTokenSource.token()

    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        // Request cancellation via the token (this will trigger any registered callbacks)
        cancellationTokenSource.cancel()

        // Complete the delegate future exceptionally if not already done
        val cancelled =
            delegate.completeExceptionally(
                java.util.concurrent.CancellationException("Future was cancelled")
            )

        // Also mark this future as cancelled
        super.cancel(mayInterruptIfRunning)

        return cancelled
    }

    override fun isCancelled(): Boolean {
        return super.isCancelled() || delegate.isCancelled()
    }

    // Delegated methods that return CancellableCompletableFuture to maintain type
    override fun <U> thenApply(fn: Function<in T, out U>): CancellableCompletableFuture<U> {
        return wrap(cancellationTokenSource, delegate.thenApply(fn))
    }

    override fun <U> thenApplyAsync(fn: Function<in T, out U>): CancellableCompletableFuture<U> {
        return wrap(cancellationTokenSource, delegate.thenApplyAsync(fn))
    }

    override fun <U> thenCompose(
        fn: Function<in T, out CompletionStage<U>>
    ): CancellableCompletableFuture<U> {
        return wrap(cancellationTokenSource, delegate.thenCompose(fn).toCompletableFuture())
    }

    override fun <U> thenComposeAsync(
        fn: Function<in T, out CompletionStage<U>>
    ): CancellableCompletableFuture<U> {
        return wrap(cancellationTokenSource, delegate.thenComposeAsync(fn).toCompletableFuture())
    }

    override fun thenAccept(action: Consumer<in T>): CancellableCompletableFuture<Void> {
        return wrap(cancellationTokenSource, delegate.thenAccept(action))
    }

    override fun thenAcceptAsync(action: Consumer<in T>): CancellableCompletableFuture<Void> {
        return wrap(cancellationTokenSource, delegate.thenAcceptAsync(action))
    }

    override fun thenRun(action: Runnable): CancellableCompletableFuture<Void> {
        return wrap(cancellationTokenSource, delegate.thenRun(action))
    }

    override fun thenRunAsync(action: Runnable): CancellableCompletableFuture<Void> {
        return wrap(cancellationTokenSource, delegate.thenRunAsync(action))
    }

    override fun <U> handle(fn: BiFunction<in T, Throwable, out U>): CancellableCompletableFuture<U> {
        return wrap(cancellationTokenSource, delegate.handle(fn))
    }

    override fun <U> handleAsync(
        fn: BiFunction<in T, Throwable, out U>
    ): CancellableCompletableFuture<U> {
        return wrap(cancellationTokenSource, delegate.handleAsync(fn))
    }

    override fun whenComplete(
        action: BiConsumer<in T, in Throwable>
    ): CancellableCompletableFuture<T> {
        return wrap(cancellationTokenSource, delegate.whenComplete(action))
    }

    override fun whenCompleteAsync(
        action: BiConsumer<in T, in Throwable>
    ): CancellableCompletableFuture<T> {
        return wrap(cancellationTokenSource, delegate.whenCompleteAsync(action))
    }

    override fun exceptionally(fn: Function<Throwable, out T>): CancellableCompletableFuture<T> {
        return wrap(cancellationTokenSource, delegate.exceptionally(fn))
    }

    companion object {
        /**
         * Creates a new [CancellableCompletableFuture] with a new cancellation token source.
         */
        @JvmStatic
        fun <T> create(): CancellableCompletableFuture<T> {
            return CancellableCompletableFuture(
                CancellationTokenSource(),
                CompletableFuture<T>()
            )
        }

        /**
         * Wraps an existing [CompletableFuture] with cancellation support.
         *
         * @param tokenSource the cancellation token source to use
         * @param delegate the future to wrap
         */
        @JvmStatic
        fun <T> wrap(
            tokenSource: CancellationTokenSource,
            delegate: CompletableFuture<T>
        ): CancellableCompletableFuture<T> {
            return CancellableCompletableFuture(tokenSource, delegate)
        }
    }
}
