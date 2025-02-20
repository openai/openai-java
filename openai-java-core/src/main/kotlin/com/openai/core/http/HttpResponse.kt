package com.openai.core.http

import java.io.InputStream
import java.lang.AutoCloseable

interface HttpResponse : AutoCloseable {

    fun statusCode(): Int

    fun headers(): Headers

    fun body(): InputStream

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()

    interface Handler<T> {

        fun handle(response: HttpResponse): T
    }
}
