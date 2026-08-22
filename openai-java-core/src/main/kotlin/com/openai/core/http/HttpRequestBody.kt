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
     * The default implementation buffers the bytes produced by [writeTo] so existing third-party
     * implementations remain compatible. Implementations backed by an existing byte array or stream
     * should override this method to avoid buffering.
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
