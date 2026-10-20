package com.openai.core.http

import com.openai.core.JsonField
import com.openai.core.MultipartField
import java.io.InputStream
import java.util.Collections
import java.util.IdentityHashMap
import kotlin.jvm.optionals.getOrNull

/** Streams owned by a generated multipart value, without invoking its serializer. */
internal interface MultipartInputStreamProvider {
    @JvmSynthetic fun collectMultipartInputStreams(consumer: (InputStream) -> Unit)
}

/** Tracks construction ownership without changing stream types or configured serializers. */
internal object MultipartInputStreams {
    private val current = ThreadLocal<(InputStream) -> Unit>()

    @JvmSynthetic
    fun closeAttempted(input: InputStream) {
        current.get()?.invoke(input)
    }

    @JvmSynthetic
    fun <T> withInputs(values: Iterable<*>, action: () -> T): T {
        val inputs = mutableListOf<InputStream>()
        val remaining = Collections.newSetFromMap(IdentityHashMap<InputStream, Boolean>())
        val visited = Collections.newSetFromMap(IdentityHashMap<Any, Boolean>())
        fun collect(value: Any?) {
            // Retain only values that can own streams in the cycle guard.
            when (value) {
                is InputStream,
                is MultipartInputStreamProvider,
                is MultipartField<*>,
                is JsonField<*>,
                is Iterable<*>,
                is Map<*, *>,
                is Array<*> -> if (!visited.add(value)) return
                else -> return
            }
            when (value) {
                is InputStream -> {
                    inputs.add(value)
                    remaining.add(value)
                }
                is MultipartInputStreamProvider -> value.collectMultipartInputStreams(::collect)
                is MultipartField<*> -> collect(value.value)
                is JsonField<*> -> collect(value.asKnown().getOrNull())
                is Iterable<*> -> value.forEach(::collect)
                is Map<*, *> -> value.values.forEach(::collect)
                is Array<*> -> value.forEach(::collect)
            }
        }

        val previous = current.get()
        current.set { input ->
            remaining.remove(input)
            previous?.invoke(input)
        }
        try {
            values.forEach(::collect)
            return action()
        } catch (failure: Throwable) {
            inputs.forEach { input ->
                if (remaining.remove(input)) {
                    // A throwing close still counts as an attempt in every enclosing scope.
                    previous?.invoke(input)
                    try {
                        input.close()
                    } catch (cleanupFailure: Throwable) {
                        if (cleanupFailure !== failure) failure.addSuppressed(cleanupFailure)
                    }
                }
            }
            throw failure
        } finally {
            if (previous == null) current.remove() else current.set(previous)
        }
    }
}
