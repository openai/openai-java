package com.openai.core

import com.openai.core.http.DelegatingHttpResponse
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
        try {
            action?.invoke(mayInterruptIfRunning)
        } catch (_: Exception) {
            // The public cancellation already won; transport cleanup is best effort.
        }
        return true
    }

    override fun <U> thenApply(fn: Function<in T, out U>): CompletableFuture<U> =
        transform(fn) { super.thenApplyAsync(it) }

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
        handleStage(fn, { super.handleAsync(it) })

    fun <U> handle(
        fn: BiFunction<in T?, Throwable?, out U>,
        onDiscard: (U) -> Unit,
    ): CompletableFuture<U> = handleStage(fn, { super.handleAsync(it) }, onDiscard)

    override fun <U> handleAsync(
        fn: BiFunction<in T?, Throwable?, out U>,
        executor: Executor,
    ): CompletableFuture<U> = handleStage(fn, { super.handleAsync(it, executor) })

    override fun <U> handleAsync(fn: BiFunction<in T?, Throwable?, out U>): CompletableFuture<U> =
        handleStage(fn, { super.handleAsync(it) })

    private fun <U> handleStage(
        fn: BiFunction<in T?, Throwable?, out U>,
        apply: (BiFunction<T?, Throwable?, U>) -> CompletableFuture<U>,
        onDiscard: (U) -> Unit = { value ->
            when (value) {
                is HttpResponse -> value.close()
                is HttpRequest -> value.body?.close()
            }
        },
    ): CompletableFuture<U> {
        // Retained discard callbacks must not keep the completed parent and its source alive.
        val discardInput = discard
        val active = AtomicReference<T?>()
        val discardedInput = AtomicReference<T?>()
        val cancelled = AtomicBoolean()
        val ownership = Any()
        fun discardActive() {
            // Record ownership before calling user-supplied close(), which may unblock the handler.
            val input =
                synchronized(ownership) { active.getAndSet(null)?.also { discardedInput.set(it) } }
            input?.let(discardInput)
        }
        val discardOutput: (U) -> Unit = { output ->
            discardActive()
            val input = discardedInput.get()
            val wrapsInput = output is DelegatingHttpResponse && output.wrappedResponse === input
            if (
                input == null ||
                    (output !== input &&
                        !wrapsInput &&
                        (output !is Pair<*, *> || output.first !== input))
            ) {
                onDiscard(output)
            }
        }
        val result =
            apply(
                BiFunction { value, error ->
                    if (value != null) active.set(value)
                    try {
                        if (cancelled.get()) {
                            discardActive()
                            throw CancellationException()
                        }
                        val handled = fn.apply(value, error)
                        if (cancelled.get()) {
                            discardActive()
                            discardOutput(handled)
                            throw CancellationException()
                        }
                        handled
                    } finally {
                        active.set(null)
                    }
                }
            )
        return CancellableFuture(result, discardOutput) { interrupt ->
            cancelled.set(true)
            try {
                discardActive()
            } catch (_: Exception) {
                // Cleanup must not change the established cancellation result.
            } finally {
                cancel(interrupt)
            }
        }
    }

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
        val enrollment = CancellationEnrollment.Scope()
        val result =
            apply(
                Function { value ->
                    if (cancelled.get() != null) {
                        discard(value)
                        CompletableFuture<U>().apply { cancel(false) }
                    } else {
                        enrollment
                            .during { fn.apply(value).toCompletableFuture() }
                            .also { future ->
                                next.set(future)
                                cancelled.get()?.let { future.cancel(it) }
                            }
                    }
                }
            )
        return CancellableFuture(result) { interrupt ->
            cancelled.set(interrupt)
            var failure: Throwable? = null
            fun cleanup(action: () -> Unit) {
                try {
                    action()
                } catch (error: Throwable) {
                    if (failure == null) failure = error
                    else if (failure !== error) failure?.addSuppressed(error)
                }
            }
            cleanup { enrollment.cancel(interrupt) }
            cleanup { cancel(interrupt) }
            cleanup { next.get()?.cancel(interrupt) }
            failure?.let { throw it }
        }
    }

    companion object {
        fun <T> wrap(
            source: CompletableFuture<T>,
            onCancel: (Boolean) -> Unit = {},
        ): CancellableFuture<T> =
            CancellableFuture(source) { interrupt ->
                try {
                    source.cancel(interrupt)
                } catch (_: Exception) {
                    // A failed transport cancellation must still run SDK cleanup.
                }
                onCancel(interrupt)
            }
    }
}
