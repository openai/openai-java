package com.openai.core.http

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.lang.AutoCloseable

interface HttpRequestBody : AutoCloseable {

    fun writeTo(outputStream: OutputStream)

    /**
     * Returns the request body content as an input stream.
     *
     * The stream produces the same bytes as [writeTo]. Close the returned stream after each
     * attempt, and close this body after the final attempt, including on failure or cancellation.
     * Closing a stream may release its underlying upload resources. Always close the body too, even
     * if opening or reading the stream fails.
     *
     * If [repeatable] is true, each call returns a fresh stream over equivalent content. Otherwise,
     * consume the body only once, using either this method or [writeTo]. Concurrent consumption is
     * not supported.
     *
     * The default implementation buffers the bytes produced by [writeTo] so existing third-party
     * implementations remain compatible. Implementations backed by an existing byte array or stream
     * should override this method to avoid buffering.
     *
     * ```java
     * try (InputStream content = body.content()) {
     *     // Pass content to the HTTP transport and wait for consumption to finish.
     * }
     * // Close body after the final transport attempt.
     * ```
     */
    fun content(): InputStream {
        val outputStream = ByteArrayOutputStream()
        writeTo(outputStream)
        return outputStream.toByteArray().inputStream()
    }

    fun contentType(): String?

    fun contentLength(): Long

    /**
     * Determines if a request can be repeated in a meaningful way, for example before doing a
     * retry.
     *
     * The most typical case when a request can't be retried is if the request body is being
     * streamed. In this case the body data isn't available on subsequent attempts.
     */
    fun repeatable(): Boolean

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()
}

/** Internal coordination shared by a multipart body and SDK body wrappers. */
internal interface MultipartTransportGuard {
    fun <T> beforeTransport(action: () -> T): T
}
