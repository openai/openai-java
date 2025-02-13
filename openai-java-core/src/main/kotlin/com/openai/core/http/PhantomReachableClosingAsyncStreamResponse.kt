package com.openai.core.http

import com.openai.core.closeWhenPhantomReachable
import com.openai.core.http.AsyncStreamResponse.Handler
import java.util.Optional
import java.util.concurrent.Executor

/**
 * A delegating wrapper around an `AsyncStreamResponse` that closes it once it's only phantom
 * reachable.
 *
 * This class ensures the `AsyncStreamResponse` is closed even if the user forgets to close it.
 */
internal class PhantomReachableClosingAsyncStreamResponse<T>(
    private val asyncStreamResponse: AsyncStreamResponse<T>
) : AsyncStreamResponse<T> {

    /**
     * An object used for keeping `asyncStreamResponse` open while the object is still reachable.
     */
    private val reachabilityTracker = Object()

    init {
        closeWhenPhantomReachable(reachabilityTracker, asyncStreamResponse::close)
    }

    override fun subscribe(handler: Handler<T>): AsyncStreamResponse<T> = apply {
        asyncStreamResponse.subscribe(TrackedHandler(handler, reachabilityTracker))
    }

    override fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T> =
        apply {
            asyncStreamResponse.subscribe(TrackedHandler(handler, reachabilityTracker), executor)
        }

    override fun close() = asyncStreamResponse.close()
}

/**
 * A wrapper around a `Handler` that also references a `reachabilityTracker` object.
 *
 * Referencing the `reachabilityTracker` object prevents it from getting reclaimed while the handler
 * is still reachable.
 */
private class TrackedHandler<T>(
    private val handler: Handler<T>,
    private val reachabilityTracker: Any,
) : Handler<T> {
    override fun onNext(value: T) = handler.onNext(value)

    override fun onComplete(error: Optional<Throwable>) = handler.onComplete(error)
}
