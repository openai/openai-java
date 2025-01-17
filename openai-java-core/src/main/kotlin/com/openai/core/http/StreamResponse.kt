package com.openai.core.http

import java.util.stream.Stream

interface StreamResponse<T> : AutoCloseable {

    fun stream(): Stream<T>
}

@JvmSynthetic
internal fun <T, R> StreamResponse<T>.map(transform: (T) -> R): StreamResponse<R> =
    object : StreamResponse<R> {
        override fun stream(): Stream<R> = this@map.stream().map(transform)

        override fun close() = this@map.close()
    }
