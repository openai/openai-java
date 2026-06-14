package com.openai.core

import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicReference

@JvmSynthetic
internal fun <T, U> CompletableFuture<T>.thenApplyPropagatingCancellation(
    fn: (T) -> U
): CompletableFuture<U> {
    val upstream = this
    val result = CompletableFuture<U>()

    result.whenComplete { _, error ->
        if (result.isCancelled || error is CancellationException) {
            upstream.cancel(false)
        }
    }

    upstream.whenComplete { value, error ->
        if (result.isCancelled) {
            return@whenComplete
        }
        if (error != null) {
            result.completeExceptionally(error)
            return@whenComplete
        }

        try {
            result.complete(fn(value))
        } catch (e: Throwable) {
            result.completeExceptionally(e)
        }
    }

    return result
}

@JvmSynthetic
internal fun <T, U> CompletableFuture<T>.handlePropagatingCancellation(
    fn: (T?, Throwable?) -> U
): CompletableFuture<U> {
    val upstream = this
    val result = CompletableFuture<U>()

    result.whenComplete { _, error ->
        if (result.isCancelled || error is CancellationException) {
            upstream.cancel(false)
        }
    }

    upstream.whenComplete { value, error ->
        if (result.isCancelled) {
            return@whenComplete
        }

        try {
            result.complete(fn(value, error))
        } catch (e: Throwable) {
            result.completeExceptionally(e)
        }
    }

    return result
}

@JvmSynthetic
internal fun <T, U> CompletableFuture<T>.thenComposePropagatingCancellation(
    fn: (T) -> CompletableFuture<U>
): CompletableFuture<U> {
    val upstream = this
    val innerFuture = AtomicReference<CompletableFuture<U>?>()
    val result = CompletableFuture<U>()

    result.whenComplete { _, error ->
        if (result.isCancelled || error is CancellationException) {
            upstream.cancel(false)
            innerFuture.get()?.cancel(false)
        }
    }

    upstream.whenComplete { value, error ->
        if (result.isCancelled) {
            return@whenComplete
        }
        if (error != null) {
            result.completeExceptionally(error)
            return@whenComplete
        }

        val inner =
            try {
                fn(value)
            } catch (e: Throwable) {
                result.completeExceptionally(e)
                return@whenComplete
            }
        innerFuture.set(inner)

        if (result.isCancelled) {
            inner.cancel(false)
            return@whenComplete
        }

        inner.whenComplete { innerValue, innerError ->
            if (innerError != null) {
                result.completeExceptionally(innerError)
            } else {
                result.complete(innerValue)
            }
        }
    }

    return result
}

@JvmSynthetic
internal fun <T, U> CompletableFuture<T>.thenComposeAsyncPropagatingCancellation(
    fn: (T) -> CompletableFuture<U>
): CompletableFuture<U> {
    val upstream = this
    val innerFuture = AtomicReference<CompletableFuture<U>?>()
    val result = CompletableFuture<U>()

    result.whenComplete { _, error ->
        if (result.isCancelled || error is CancellationException) {
            upstream.cancel(false)
            innerFuture.get()?.cancel(false)
        }
    }

    upstream.whenCompleteAsync { value, error ->
        if (result.isCancelled) {
            return@whenCompleteAsync
        }
        if (error != null) {
            result.completeExceptionally(error)
            return@whenCompleteAsync
        }

        val inner =
            try {
                fn(value)
            } catch (e: Throwable) {
                result.completeExceptionally(e)
                return@whenCompleteAsync
            }
        innerFuture.set(inner)

        if (result.isCancelled) {
            inner.cancel(false)
            return@whenCompleteAsync
        }

        inner.whenComplete { innerValue, innerError ->
            if (innerError != null) {
                result.completeExceptionally(innerError)
            } else {
                result.complete(innerValue)
            }
        }
    }

    return result
}
