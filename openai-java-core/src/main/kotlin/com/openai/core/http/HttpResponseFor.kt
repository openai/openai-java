package com.openai.core.http

import java.io.InputStream

interface HttpResponseFor<T> : HttpResponse {

    fun parse(): T
}

@JvmSynthetic
internal fun <T> HttpResponse.parseable(parse: () -> T): HttpResponseFor<T> =
    if (this is PipelineOwnedResource) {
        PipelineOwnedHttpResponseFor(this, parse)
    } else {
        DefaultHttpResponseFor(this, parse)
    }

private open class DefaultHttpResponseFor<T>(private val response: HttpResponse, parse: () -> T) :
    HttpResponseFor<T> {
    private val parsed: T by lazy(parse)

    override fun parse(): T = parsed

    override fun statusCode(): Int = response.statusCode()

    override fun headers(): Headers = response.headers()

    override fun body(): InputStream = response.body()

    override fun close() = response.close()
}

private class PipelineOwnedHttpResponseFor<T>(response: HttpResponse, parse: () -> T) :
    DefaultHttpResponseFor<T>(response, parse), PipelineOwnedResource {
    override fun parse(): T =
        try {
            super.parse()
        } catch (failure: Throwable) {
            closeIfPipelineOwned(failure)
            throw failure
        }
}
