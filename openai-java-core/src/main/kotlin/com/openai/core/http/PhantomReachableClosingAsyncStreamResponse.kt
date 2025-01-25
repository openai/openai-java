package com.openai.core.http

import com.openai.core.closeWhenPhantomReachable
import com.openai.core.http.AsyncStreamResponse.Handler
import java.util.Optional
import java.util.concurrent.Executor

internal class PhantomReachableClosingAsyncStreamResponse<T>(
    private val asyncStreamResponse: AsyncStreamResponse<T>
) : AsyncStreamResponse<T> {
    init {
        closeWhenPhantomReachable(this, asyncStreamResponse::close)
    }

    override fun subscribe(handler: Handler<T>): AsyncStreamResponse<T> = apply {
        asyncStreamResponse.subscribe(HandlerReferencingAsyncStreamResponse(handler, this))
    }

    override fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T> =
        apply {
            asyncStreamResponse.subscribe(
                HandlerReferencingAsyncStreamResponse(handler, this),
                executor
            )
        }

    override fun close() = asyncStreamResponse.close()
}

/**
 * A wrapper around a `Handler` that also references an `AsyncStreamResponse` so that the latter
 * will not only be phantom reachable and get reclaimed early while the handler itself is reachable
 * and subscribed to the response.
 */
private class HandlerReferencingAsyncStreamResponse<T>(
    private val handler: Handler<T>,
    private val asyncStreamResponse: AsyncStreamResponse<T>
) : Handler<T> {
    override fun onNext(value: T) = handler.onNext(value)

    override fun onComplete(error: Optional<Throwable>) = handler.onComplete(error)
}
