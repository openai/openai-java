package com.openai.core.http

import java.util.Optional
import java.util.stream.Stream

interface StreamResponse<T> : AutoCloseable {

    /**
     * Returns the value of the `x-request-id` header, or an empty [Optional] if it's unavailable.
     */
    fun requestId(): Optional<String> = Optional.empty()

    fun stream(): Stream<T>

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()
}

@JvmSynthetic
internal fun <T, R> StreamResponse<T>.map(transform: (T) -> R): StreamResponse<R> =
    object : StreamResponse<R> {
        override fun requestId(): Optional<String> = this@map.requestId()

        override fun stream(): Stream<R> = this@map.stream().map(transform)

        override fun close() = this@map.close()
    }
