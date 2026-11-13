package com.openai.core.http

import com.openai.errors.OpenAIException
import java.io.InputStream

interface HttpResponseFor<T> : HttpResponse {

    fun parse(): T
}

@JvmSynthetic
internal fun <T> HttpResponse.parseable(parse: () -> T): HttpResponseFor<T> =
    object : HttpResponseFor<T> {

        private val parsed = lazy {
            val responseHeaders = this@parseable.headers()
            try {
                parse()
            } catch (e: OpenAIException) {
                e.attachHeaders(responseHeaders)
                throw e
            }
        }

        override fun parse(): T = parsed.value

        override fun statusCode(): Int = this@parseable.statusCode()

        override fun headers(): Headers = this@parseable.headers()

        override fun body(): InputStream = this@parseable.body()

        override fun close() {
            val stream = if (parsed.isInitialized()) parsed.value as? StreamResponse<*> else null
            if (stream != null) {
                stream.close()
            } else {
                this@parseable.close()
            }
        }
    }
