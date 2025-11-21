package com.openai.core

import com.openai.core.http.CancellationTokenSource
import java.util.concurrent.CompletableFuture

/**
 * Wraps a [CompletableFuture] with cancellation token support.
 *
 * This extension method provides a clean way to add cancellation support to CompletableFutures.
 *
 * @param tokenSource the cancellation token source to use
 * @return a [CancellableCompletableFuture] that can be cancelled via the token
 */
fun <T> CompletableFuture<T>.withCancellation(
    tokenSource: CancellationTokenSource
): CancellableCompletableFuture<T> {
    return CancellableCompletableFuture.wrap(tokenSource, this)
}
