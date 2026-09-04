package com.openai.core

import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicReference
import java.util.function.BiFunction
import java.util.function.Function

/** Keeps cancellation connected across the stages of an SDK request on Java 8. */
internal class CancellableFuture<T>
private constructor(source: CompletableFuture<T>, private val cancelSource: (Boolean) -> Unit) :
    CompletableFuture<T>() {
    init {
        source.whenComplete { value, error ->
            if (error != null) completeExceptionally(error) else complete(value)
        }
    }

    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        if (!super.cancel(mayInterruptIfRunning)) return false
        cancelSource(mayInterruptIfRunning)
        return true
    }

    override fun <U> thenApply(fn: Function<in T, out U>): CompletableFuture<U> =
        wrap(super.thenApply(fn)) { cancel(it) }

    override fun <U> thenApplyAsync(fn: Function<in T, out U>): CompletableFuture<U> =
        wrap(super.thenApplyAsync(fn)) { cancel(it) }

    override fun <U> thenApplyAsync(
        fn: Function<in T, out U>,
        executor: Executor,
    ): CompletableFuture<U> = wrap(super.thenApplyAsync(fn, executor)) { cancel(it) }

    override fun <U> handle(fn: BiFunction<in T, Throwable, out U>): CompletableFuture<U> =
        wrap(super.handle(fn)) { cancel(it) }

    override fun <U> handleAsync(
        fn: BiFunction<in T, Throwable, out U>,
        executor: Executor,
    ): CompletableFuture<U> = wrap(super.handleAsync(fn, executor)) { cancel(it) }

    override fun <U> thenCompose(fn: Function<in T, out CompletionStage<U>>): CompletableFuture<U> =
        compose(fn) { super.thenCompose(it) }

    override fun <U> thenComposeAsync(
        fn: Function<in T, out CompletionStage<U>>
    ): CompletableFuture<U> = compose(fn) { super.thenComposeAsync(it) }

    override fun <U> thenComposeAsync(
        fn: Function<in T, out CompletionStage<U>>,
        executor: Executor,
    ): CompletableFuture<U> = compose(fn) { super.thenComposeAsync(it, executor) }

    private fun <U> compose(
        fn: Function<in T, out CompletionStage<U>>,
        apply: (Function<T, CompletionStage<U>>) -> CompletableFuture<U>,
    ): CompletableFuture<U> {
        val next = AtomicReference<CompletableFuture<U>?>()
        val cancelled = AtomicReference<Boolean?>()
        val result =
            apply(
                Function { value ->
                    if (cancelled.get() != null) {
                        CompletableFuture<U>().apply { cancel(false) }
                    } else {
                        fn.apply(value).toCompletableFuture().also { future ->
                            next.set(future)
                            cancelled.get()?.let { future.cancel(it) }
                        }
                    }
                }
            )
        return wrap(result) { interrupt ->
            cancelled.set(interrupt)
            cancel(interrupt)
            next.get()?.cancel(interrupt)
        }
    }

    companion object {
        fun <T> wrap(
            source: CompletableFuture<T>,
            onCancel: (Boolean) -> Unit = {},
        ): CompletableFuture<T> =
            CancellableFuture(source) { interrupt ->
                source.cancel(interrupt)
                onCancel(interrupt)
            }
    }
}
