package com.openai.core.http

import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference

/** Resource whose lifecycle is owned by the authenticated request pipeline. */
internal interface PipelineOwnedResource : AutoCloseable

/** Closes a pipeline-owned resource and preserves a primary failure when one exists. */
@JvmSynthetic
internal fun Any?.closeIfPipelineOwned(failure: Throwable? = null) {
    val resource = this as? PipelineOwnedResource ?: return
    try {
        resource.close()
    } catch (closeFailure: Throwable) {
        if (failure == null) throw closeFailure
        if (closeFailure !== failure) failure.addSuppressed(closeFailure)
    }
}

/** Returns one close-once pipeline wrapper for a response. */
@JvmSynthetic
internal fun HttpResponse.asPipelineOwned(): HttpResponse =
    if (this is PipelineOwnedResource) this else CloseOncePipelineHttpResponse(this)

/** Shares one response wrapper between completion and cancellation race participants. */
internal class PipelineResponseLease {
    private val response = AtomicReference<HttpResponse?>()

    fun acquire(candidate: HttpResponse): HttpResponse {
        response.get()?.let {
            return it
        }
        val owned = candidate.asPipelineOwned()
        return if (response.compareAndSet(null, owned)) owned else requireNotNull(response.get())
    }

    fun close(candidate: HttpResponse, failure: Throwable? = null) {
        acquire(candidate).closeIfPipelineOwned(failure)
    }

    fun discard(candidate: HttpResponse) {
        try {
            close(candidate)
        } catch (_: Throwable) {}
    }
}

/** Makes cancellation-time and parser-finally cleanup one underlying response close. */
internal class CloseOncePipelineHttpResponse(private val delegate: HttpResponse) :
    HttpResponse, PipelineOwnedResource {
    private val closed = AtomicBoolean()

    override fun statusCode(): Int = delegate.statusCode()

    override fun headers(): Headers = delegate.headers()

    override fun body() = delegate.body()

    override fun close() {
        if (closed.compareAndSet(false, true)) delegate.close()
    }
}
