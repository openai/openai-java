// File generated from our OpenAPI spec by Stainless.

package com.openai.core.http

import java.io.InputStream
import java.util.Optional

interface HttpResponse : AutoCloseable {

    fun statusCode(): Int

    fun headers(): Headers

    /**
     * Returns the value of the `x-request-id` header, or an empty [Optional] if there's no such
     * header in the response.
     */
    fun requestId(): Optional<String> =
        Optional.ofNullable(headers().values("x-request-id").firstOrNull())

    fun body(): InputStream

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()

    interface Handler<T> {

        fun handle(response: HttpResponse): T
    }
}
