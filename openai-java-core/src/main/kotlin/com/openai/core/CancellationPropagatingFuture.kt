package com.openai.core

import com.openai.core.http.HttpRequest
import com.openai.core.http.PipelineOwnedResource
import com.openai.core.http.PropagatesCancellationToUpstream
import com.openai.core.http.discardPipelineBody
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import java.util.concurrent.Executor
import java.util.concurrent.Future
import java.util.concurrent.atomic.AtomicReference
import java.util.function.BiConsumer
import java.util.function.Consumer
import java.util.function.Function

internal class CancellationPropagatingFuture<T>
private constructor(
    private val asyncExecutor: Executor? = null,
    private val cancelUpstream: () -> Unit,
) : CompletableFuture<T>(), PropagatesCancellationToUpstream {
    override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
        val cancelled = super.cancel(mayInterruptIfRunning)
        if (cancelled) cancelUpstream()
        return cancelled
    }

    override fun <U> thenApply(function: Function<in T, out U>): CompletableFuture<U> {
        val input = InFlightCloseable()
        val result =
            CancellationPropagatingFuture<U> {
                cancel(true)
                input.close()
            }
        whenComplete { value, error ->
            if (result.isDone) {
                discard(value)
                return@whenComplete
            }
            if (error != null) result.completeExceptionally(error)
            else {
                input.acquire(value)
                if (result.isDone) {
                    input.close()
                    return@whenComplete
                }
                try {
                    val mapped = function.apply(value)
                    if (!result.complete(mapped)) discard(mapped)
                } catch (failure: Throwable) {
                    result.completeExceptionally(failure)
                } finally {
                    input.release(value)
                }
            }
        }
        return result
    }

    override fun thenAccept(action: Consumer<in T>): CompletableFuture<Void> {
        val input = InFlightCloseable()
        val result =
            CancellationPropagatingFuture<Void> {
                cancel(true)
                input.close()
            }
        whenComplete { value, error ->
            if (result.isDone) {
                discard(value)
                return@whenComplete
            }
            if (error != null) result.completeExceptionally(error)
            else {
                input.acquire(value)
                if (result.isDone) {
                    input.close()
                    return@whenComplete
                }
                try {
                    action.accept(value)
                    result.complete(null)
                } catch (failure: Throwable) {
                    result.completeExceptionally(failure)
                } finally {
                    input.release(value)
                }
            }
        }
        return result
    }

    override fun <U> thenComposeAsync(
        function: Function<in T, out CompletionStage<U>>
    ): CompletableFuture<U> {
        val active = AtomicReference<Future<*>>(this)
        val input = InFlightCloseable()
        val result =
            CancellationPropagatingFuture<U> {
                active.get().cancel(true)
                input.close()
            }
        val completion =
            BiConsumer<T?, Throwable?> { value, error ->
                if (result.isDone) {
                    if (error == null) discard(value)
                    return@BiConsumer
                }
                if (error != null) {
                    result.completeExceptionally(error)
                    return@BiConsumer
                }
                input.acquire(value)
                if (result.isDone) {
                    input.close()
                    return@BiConsumer
                }
                val future =
                    try {
                        function.apply(value).toCompletableFuture()
                    } catch (failure: Throwable) {
                        discardPreparedRequest(value)
                        result.completeExceptionally(failure)
                        return@BiConsumer
                    } finally {
                        input.release(value)
                    }
                active.set(future)
                if (result.isDone) {
                    if (!future.cancel(true)) {
                        future.whenComplete { composedValue, composedError ->
                            if (composedError == null) discard(composedValue)
                        }
                    }
                    return@BiConsumer
                }
                future.whenComplete { composedValue, composedError ->
                    if (composedError == null) {
                        if (!result.complete(composedValue)) discard(composedValue)
                    } else result.completeExceptionally(composedError)
                }
            }
        if (asyncExecutor == null) whenCompleteAsync(completion)
        else whenCompleteAsync(completion, asyncExecutor)
        return result
    }

    companion object {
        private class InFlightCloseable {
            private val value = AtomicReference<Any?>()

            fun acquire(candidate: Any?) {
                if (candidate is HttpRequest || candidate is PipelineOwnedResource) {
                    value.set(candidate)
                }
            }

            fun release(candidate: Any?) {
                value.compareAndSet(candidate, null)
            }

            fun close() = discard(value.getAndSet(null))
        }

        private fun discard(value: Any?) {
            try {
                if (value is HttpRequest) value.discardPipelineBody()
                else (value as? AutoCloseable)?.close()
            } catch (_: Exception) {}
        }

        private fun discardPreparedRequest(value: Any?) {
            if (value is HttpRequest) value.discardPipelineBody()
        }

        fun <T> completed(
            value: T,
            asyncExecutor: Executor? = null,
        ): CancellationPropagatingFuture<T> =
            CancellationPropagatingFuture<T>(asyncExecutor) {}.apply { complete(value) }
    }
}
