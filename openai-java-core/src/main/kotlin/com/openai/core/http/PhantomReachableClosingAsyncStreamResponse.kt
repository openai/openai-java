package com.openai.core.http

import com.openai.core.closeWhenPhantomReachable
import com.openai.core.http.AsyncStreamResponse.Handler
import java.util.concurrent.Executor

internal class PhantomReachableClosingAsyncStreamResponse<T>(
    private val asyncStreamResponse: AsyncStreamResponse<T>
) : AsyncStreamResponse<T> {
    init {
        closeWhenPhantomReachable(this, asyncStreamResponse::close)
    }

    override fun subscribe(handler: Handler<T>): AsyncStreamResponse<T> = apply {
        asyncStreamResponse.subscribe(handler)
    }

    override fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T> =
        apply {
            asyncStreamResponse.subscribe(handler, executor)
        }

    override fun close() = asyncStreamResponse.close()
}
