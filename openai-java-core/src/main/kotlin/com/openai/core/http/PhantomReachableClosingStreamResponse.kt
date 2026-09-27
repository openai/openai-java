package com.openai.core.http

import com.openai.core.closeWhenPhantomReachable
import java.util.stream.Stream

/**
 * A delegating wrapper around a `StreamResponse` that closes it once it's only phantom reachable.
 *
 * This class ensures the `StreamResponse` is closed even if the user forgets to close it.
 */
internal class PhantomReachableClosingStreamResponse<T>(
    private val streamResponse: StreamResponse<T>
) : StreamResponse<T> {
    init {
        closeWhenPhantomReachable(this, streamResponse)
    }

    override fun stream(): Stream<T> =
        streamResponse
            .stream()
            // Retain this owner in the traversal pipeline, including iterators and
            // spliterators obtained from it. The monitor keeps the owner live until
            // each pending read has returned on Java 8 as well as newer runtimes.
            .map { value -> synchronized(this) { value } }
            .onClose(this::close)

    override fun close() = streamResponse.close()
}
