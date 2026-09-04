package com.openai.core

import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import java.util.function.BiFunction
import java.util.function.Consumer
import java.util.function.Function

/** Keeps cancellation connected across the stages of an SDK request on Java 8. */
internal class CancellableFuture<T>
private constructor(
    source: CompletableFuture<T>,
    private val discard: (T) -> Unit = { value ->
        when (value) {
            is HttpResponse -> value.close()
            is HttpRequest -> value.body?.close()
        }
    },
    cancelSource: (Boolean) -> Unit,
) : CompletableFuture<T>() {
    private val cancellation = AtomicReference<((Boolean) -> Unit)?>(cancelSource)

    init {
        super.whenComplete { _, _ -> cancellation.set(null) }
        source.whenComplete { value, error ->
            if (error != null) {
                completeExceptionally(error)
            } else if (!complete(value)) {
                discard(value)
            }
        }
    }

    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        // Completion callbacks run inside super.cancel, so retain the action before winning.
        val action = cancellation.getAndSet(null)
        if (!super.cancel(mayInterruptIfRunning)) return false
        action?.invoke(mayInterruptIfRunning)
        return true
    }

    override fun <U> thenApply(fn: Function<in T, out U>): CompletableFuture<U> =
        transform(fn) { super.thenApply(it) }

    override fun thenAccept(action: Consumer<in T>): CompletableFuture<Void> =
        CancellableFuture(super.thenAccept(action)) { cancel(it) }

    override fun exceptionally(fn: Function<Throwable, out T>): CompletableFuture<T> =
        CancellableFuture(super.exceptionally(fn)) { cancel(it) }

    override fun <U> thenApplyAsync(fn: Function<in T, out U>): CompletableFuture<U> =
        transform(fn) { super.thenApplyAsync(it) }

    override fun <U> thenApplyAsync(
        fn: Function<in T, out U>,
        executor: Executor,
    ): CompletableFuture<U> = transform(fn) { super.thenApplyAsync(it, executor) }

    private fun <U> transform(
        fn: Function<in T, out U>,
        apply: (Function<T, U>) -> CompletableFuture<U>,
    ): CompletableFuture<U> {
        val active = AtomicReference<T?>()
        val cancelled = AtomicBoolean()
        val result =
            apply(
                Function { value ->
                    active.set(value)
                    try {
                        if (cancelled.get()) {
                            active.getAndSet(null)?.let(discard)
                            throw CancellationException()
                        }
                        fn.apply(value)
                    } finally {
                        active.set(null)
                    }
                }
            )
        return CancellableFuture(result) { interrupt ->
            cancelled.set(true)
            // Headers may already have completed the parent while this handler reads the body.
            try {
                active.getAndSet(null)?.let(discard)
            } catch (_: Exception) {
                // A cleanup failure must not change the already-established cancellation outcome.
            } finally {
                cancel(interrupt)
            }
        }
    }

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
