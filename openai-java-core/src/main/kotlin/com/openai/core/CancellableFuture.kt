package com.openai.core

import com.openai.core.http.HttpResponse
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicReference
import java.util.function.BiFunction
import java.util.function.Consumer
import java.util.function.Function

/** Keeps cancellation connected across the stages of an SDK request on Java 8. */
internal class CancellableFuture<T>
private constructor(
    source: CompletableFuture<T>,
    private val discard: (T) -> Unit = { value -> if (value is HttpResponse) value.close() },
    private val cancelSource: (Boolean) -> Unit,
) : CompletableFuture<T>() {
    init {
        source.whenComplete { value, error ->
            if (error != null) {
                completeExceptionally(error)
            } else if (!complete(value)) {
                discard(value)
            }
        }
    }

    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        if (!super.cancel(mayInterruptIfRunning)) return false
        cancelSource(mayInterruptIfRunning)
        return true
    }

    override fun <U> thenApply(fn: Function<in T, out U>): CompletableFuture<U> =
        CancellableFuture(super.thenApply(fn)) { cancel(it) }

    override fun thenAccept(action: Consumer<in T>): CompletableFuture<Void> =
        CancellableFuture(super.thenAccept(action)) { cancel(it) }

    override fun exceptionally(fn: Function<Throwable, out T>): CompletableFuture<T> =
        CancellableFuture(super.exceptionally(fn)) { cancel(it) }

    override fun <U> thenApplyAsync(fn: Function<in T, out U>): CompletableFuture<U> =
        CancellableFuture(super.thenApplyAsync(fn)) { cancel(it) }

    override fun <U> thenApplyAsync(
        fn: Function<in T, out U>,
        executor: Executor,
    ): CompletableFuture<U> = CancellableFuture(super.thenApplyAsync(fn, executor)) { cancel(it) }

    override fun <U> handle(fn: BiFunction<in T?, Throwable?, out U>): CompletableFuture<U> =
        CancellableFuture(super.handle(fn)) { cancel(it) }

    fun <U> handle(
        fn: BiFunction<in T?, Throwable?, out U>,
        onDiscard: (U) -> Unit,
    ): CompletableFuture<U> = CancellableFuture(super.handle(fn), onDiscard) { cancel(it) }

    override fun <U> handleAsync(
        fn: BiFunction<in T?, Throwable?, out U>,
        executor: Executor,
    ): CompletableFuture<U> = CancellableFuture(super.handleAsync(fn, executor)) { cancel(it) }

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
                        discard(value)
                        CompletableFuture<U>().apply { cancel(false) }
                    } else {
                        fn.apply(value).toCompletableFuture().also { future ->
                            next.set(future)
                            cancelled.get()?.let { future.cancel(it) }
                        }
                    }
                }
            )
        return CancellableFuture(result) { interrupt ->
            cancelled.set(interrupt)
            cancel(interrupt)
            next.get()?.cancel(interrupt)
        }
    }

    companion object {
        fun <T> wrap(
            source: CompletableFuture<T>,
            onCancel: (Boolean) -> Unit = {},
        ): CancellableFuture<T> =
            CancellableFuture(source) { interrupt ->
                source.cancel(interrupt)
                onCancel(interrupt)
            }
    }
}
